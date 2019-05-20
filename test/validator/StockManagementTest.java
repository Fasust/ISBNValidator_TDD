package validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StockManagementTest {

    @Test
    public void canGetACorrectLocatorCode(){
        ExternalISBNService mockWebService = isbn -> new Book(
            isbn, "Getting Things Done: The Art of Stress-Free Productivity", "David Alan");

        ExternalISBNService mockDBService = isbn -> null;

        StockManager manager = new StockManager();
        manager.setWebService(mockWebService);
        manager.setDataBaseService(mockDBService);

        String isbn = "0143126563";
        String locatorCode = manager.getLocatorCode(isbn);

        //6563 + David Alan + Getting Things Done: The Art of Stress-Free Productivity (8)
        //assertEquals(expected, input);
        assertEquals("6563D8", locatorCode);
    }

    @Test
    public void dbIsUsedWhenDateIsPresent(){
        fail();
    }

    @Test
    public void webServiceIsUsedWhenDataIsNotPresentInDB(){
        fail();
    }
}
