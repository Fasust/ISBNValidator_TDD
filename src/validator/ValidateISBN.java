package validator;

public class ValidateISBN {

    public boolean checkISBN(String isbn) throws NumberFormatException{
        if(isbn.length() != 10) throw new NumberFormatException("ISBN must be 10 Digits Long");
        if(!isbn.matches("^[0-9]*$"))throw new NumberFormatException("ISBN must only be Digits");

        int total = 0;

        for(int i = 0; i< 10; i++){
            total += (int) isbn.charAt(i) * (10 - i);
        }

        return total % 11 == 0;
    }
}
