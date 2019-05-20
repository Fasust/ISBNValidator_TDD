package validator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ValidateISBNTest {

    @Test
    public void checkAValidISBN(){
        ValidateISBN validator = new ValidateISBN();
        boolean res = validator.checkISBN(0143126563);
        assertTrue(res);
    }

    @Test
    public void checkAInvalidISBN(){
        ValidateISBN validator = new ValidateISBN();
        boolean res = validator.checkISBN(0143126562);
        assertFalse(res);
    }
}
