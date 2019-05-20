package validator;

public class ValidateISBN {

    public boolean checkISBN(String isbn) throws NumberFormatException{
        if(isbn.length() != 10) {
            throw new NumberFormatException();
        }
        int total = 0;

        for(int i = 0; i< 10; i++){
            total += (int) isbn.charAt(i) * (10 - i);
        }

        return total % 11 == 0;
    }
}
