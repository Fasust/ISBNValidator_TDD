package validator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class StockManagementTest {

    @Test
    public void canGetACorrectLocatorCode(){
        String isbn = "0143126563";
        StockManager manager = new StockManager();

        //Mocks ----------
        ExternalISBNService dbService = mock(ExternalISBNService.class);
        ExternalISBNService webService = mock(ExternalISBNService.class);

        manager.setWebService(webService);
        manager.setDataBaseService(dbService);

        when(dbService.lookUp(isbn))
                .thenReturn(new Book(isbn, "Getting Things Done: The Art of Stress-Free Productivity", "David Alan"));
        when(webService.lookUp(anyString()))
                .thenReturn(null);

        // ---------------
        String locatorCode = manager.getLocatorCode(isbn);

        //6563 + David Alan + Getting Things Done: The Art of Stress-Free Productivity (8)
        //assertEquals(expected, input);
        assertEquals("6563D8", locatorCode);
    }

    @Test
    public void dbIsUsedWhenDateIsPresent(){
        StockManager manager = new StockManager();
        String isbn = "0143126563";

        //Mocks ----------
        ExternalISBNService dbService = mock(ExternalISBNService.class);
        ExternalISBNService webService = mock(ExternalISBNService.class);

        manager.setWebService(webService);
        manager.setDataBaseService(dbService);

        when(dbService.lookUp(isbn))
                .thenReturn(new Book(isbn, "abc","abc"));
        // ---------------

        manager.getLocatorCode(isbn);

        verify(dbService, times(1))
                .lookUp(isbn);

        verify(webService, never())
                .lookUp(anyString());
    }

    @Test
    public void webServiceIsUsedWhenDataIsNotPresentInDB(){
        StockManager manager = new StockManager();
        String isbn = "0143126563";

        //Mocks ----------
        ExternalISBNService dbService = mock(ExternalISBNService.class);
        ExternalISBNService webService = mock(ExternalISBNService.class);

        manager.setWebService(webService);
        manager.setDataBaseService(dbService);

        when(dbService.lookUp(isbn))
                .thenReturn(null);
        when(webService.lookUp(isbn))
                .thenReturn(new Book(isbn, "abc","abc"));
        // ---------------

        manager.getLocatorCode(isbn);

        verify(dbService, times(1))
                .lookUp(isbn);

        verify(webService, times(1))
                .lookUp(isbn);
    }
}
