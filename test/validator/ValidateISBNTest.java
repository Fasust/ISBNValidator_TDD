package validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidateISBNTest {

    @Test
    public void checkAValidISBN(){
        ValidateISBN validator = new ValidateISBN();

        boolean res = validator.checkISBN("0143126563");
        assertTrue(res,"First: Testing \"How to Get Things Done\"");

        res = validator.checkISBN("1473695988");
        assertTrue(res,"Second: Testing \"Brief Answers to the Big Questions\"");
    }

    @Test
    public void checkAInvalidISBN(){
        ValidateISBN validator = new ValidateISBN();
        boolean res = validator.checkISBN("0143126562");
        assertFalse(res, "First: Incorrect ISBN");
    }

    @Test
    public void nineDigitISBNsAreNotAllowed(){
        ValidateISBN validator = new ValidateISBN();

        assertThrows(NumberFormatException.class,() -> {
            validator.checkISBN("123456789");
        });
    }

    @Test
    public void makeSureISBNIsOnlyNumbers(){
        ValidateISBN validator = new ValidateISBN();

        assertThrows(NumberFormatException.class,() -> {
            validator.checkISBN("HelloWorld");
        });
    }
}
