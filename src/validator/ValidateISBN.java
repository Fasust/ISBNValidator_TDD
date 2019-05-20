package validator;

public class ValidateISBN {

    private static final int SHORT_LENGTH = 10;
    private static final int LONG_LENGTH = 13;
    private static final int SHORT_DIVISOR = 11;
    private static final int LONG_DIVISOR = 10;

    private static final int VALUE_OF_X = 10;

    public boolean checkISBN(String isbn) throws NumberFormatException{
        //Pre-Formatting
        isbn = isbn.toUpperCase();
        isbn = isbn.replace("-","");

        //Length and Digit Validation
        if(!(isbn.length() == SHORT_LENGTH || isbn.length() == LONG_LENGTH))
            throw new NumberFormatException("ISBN must be "+SHORT_LENGTH+" or "+LONG_LENGTH+" Digits Long");

        if(!isbn.matches("^[0-9]*[0-9X]$"))
            throw new NumberFormatException("ISBN must only be Digits or can END in an \'X\'");

        int total;
        int divisor;

        //Calculation of Check Number
        if(isbn.length() == SHORT_LENGTH){
            divisor = SHORT_DIVISOR;
            total = addShortISBN(isbn);
        }else{
            divisor = LONG_DIVISOR;
            total = addLongISBN(isbn);
        }

        return total % divisor == 0;
    }

    private int addShortISBN(String isbn){
        int total = 0;
        for(int i = 0; i< SHORT_LENGTH; i++){
            if(isbn.charAt(i) == 'X'){
                total += VALUE_OF_X;
                continue;
            }
            total += Character.getNumericValue(isbn.charAt(i)) * (SHORT_LENGTH - i);
        }
        return total;
    }

    private int addLongISBN(String isbn){
        int total = 0;
        for(int i = 0; i< LONG_LENGTH; i++){
            if(isbn.charAt(i) == 'X'){
                total += VALUE_OF_X;
                continue;
            }
            if(i%2 == 0){
                total += Character.getNumericValue(isbn.charAt(i));
            }else {
                total += Character.getNumericValue(isbn.charAt(i)) * 3;
            }
        }
        return total;
    }
}
