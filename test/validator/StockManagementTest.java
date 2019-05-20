package validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StockManagementTest {

    @Test
    public void canGetACorrectLocatorCode(){
        ExternalISBNService mockService = new ExternalISBNService() {
            @Override
            public Book lookUp(String isbn) {
                return new Book(
                    isbn, "Getting Things Done: The Art of Stress-Free Productivity", "David Alan");
            }
        };

        StockManager manager = new StockManager();
        manager.setService(mockService);

        String isbn = "0143126563";
        String locatorCode = manager.getLocatorCode(isbn);

        //6563 + David Alan + Getting Things Done: The Art of Stress-Free Productivity (8)
        //assertEquals(expected, input);
        assertEquals("6563D8", locatorCode);
    }
}
