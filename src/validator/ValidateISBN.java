package validator;

public class ValidateISBN {

    public boolean checkISBN(String isbn) throws NumberFormatException{
        isbn = isbn.toUpperCase();
        isbn = isbn.replace("-","");

        if(!(isbn.length() == 10 || isbn.length() == 13)) throw new NumberFormatException("ISBN must be 10 or 13 Digits Long");
        if(!isbn.matches("^[0-9]*[0-9X]$"))throw new NumberFormatException("ISBN must only be Digits");

        int total = 0;

        for(int i = 0; i< isbn.length(); i++){
            if(isbn.charAt(i) == 'X'){
                total += 10;
                continue;
            }
            total += Character.getNumericValue(isbn.charAt(i)) * (10 - i);
        }

        return total % 11 == 0;
    }
}
