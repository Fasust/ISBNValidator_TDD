package validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class StockManagementTest {

    private final static String ISBN = "0143126563";
    private ExternalISBNService dbService;
    private ExternalISBNService webService;
    private StockManager manager;

    @BeforeEach
    public void setup(){
        dbService = mock(ExternalISBNService.class);
        webService = mock(ExternalISBNService.class);

        manager = new StockManager();
        manager.setWebService(webService);
        manager.setDataBaseService(dbService);
    }

    @Test
    public void canGetACorrectLocatorCode(){
        //Mocks ----------
        when(dbService.lookUp(ISBN))
                .thenReturn(new Book(ISBN, "Getting Things Done: The Art of Stress-Free Productivity", "David Alan"));
        when(webService.lookUp(anyString()))
                .thenReturn(null);
        // ---------------

        String locatorCode = manager.getLocatorCode(ISBN);

        //6563 + David Alan + Getting Things Done: The Art of Stress-Free Productivity (8)
        //assertEquals(expected, input);
        assertEquals("6563D8", locatorCode);
    }

    @Test
    public void dbIsUsedWhenDateIsPresent(){
        //Mocks ----------
        when(dbService.lookUp(ISBN))
                .thenReturn(new Book(ISBN, "abc","abc"));
        // ---------------

        manager.getLocatorCode(ISBN);

        verify(dbService, times(1))
                .lookUp(ISBN);

        verify(webService, never())
                .lookUp(anyString());
    }

    @Test
    public void webServiceIsUsedWhenDataIsNotPresentInDB(){
        //Mocks ----------
        when(dbService.lookUp(ISBN))
                .thenReturn(null);
        when(webService.lookUp(ISBN))
                .thenReturn(new Book(ISBN, "abc","abc"));
        // ---------------

        manager.getLocatorCode(ISBN);

        verify(dbService, times(1))
                .lookUp(ISBN);

        verify(webService, times(1))
                .lookUp(ISBN);
    }
}
