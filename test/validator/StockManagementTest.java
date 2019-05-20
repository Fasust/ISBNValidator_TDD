package validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StockManagementTest {

    /**
     * LocatorCode = Last 4 Digits of ISBN + Initial of Author + Number of Words in Title
     */
    @Test
    public void canGetACorrectLocatorCode(){
        String isbn = "0143126563";
        StockManager manager = new StockManager();

        String locatorCode = manager.getLocatorCode(isbn);

        //6563 + David Alan + Getting Things Done: The Art of Stress-Free Productivity (8)
        //assertEquals(expected, input);
        assertEquals("6563D8", locatorCode);
    }
}
