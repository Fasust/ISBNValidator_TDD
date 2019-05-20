package validator;

public class ValidateISBN {

    public boolean checkISBN(String isbn) throws NumberFormatException{
        isbn = isbn.toUpperCase();
        isbn = isbn.replace("-","");

        if(!(isbn.length() == 10 || isbn.length() == 13)) throw new NumberFormatException("ISBN must be 10 or 13 Digits Long");
        if(!isbn.matches("^[0-9]*[0-9X]$"))throw new NumberFormatException("ISBN must only be Digits");

        int total = 0;
        int divisor = 0;

        if(isbn.length() == 10){
            divisor = 11;
            total = add10DigitISBN(isbn);
        }else{
            divisor = 10;
            total = add13DigitISBN(isbn);
        }

        return total % divisor == 0;
    }

    private int add10DigitISBN(String isbn){
        int total = 0;
        for(int i = 0; i< isbn.length(); i++){
            if(isbn.charAt(i) == 'X'){
                total += 10;
                continue;
            }
            total += Character.getNumericValue(isbn.charAt(i)) * (10 - i);
        }
        return total;
    }

    private int add13DigitISBN(String isbn){
        int total = 0;
        for(int i = 0; i< isbn.length(); i++){
            if(isbn.charAt(i) == 'X'){
                total += 10;
                continue;
            }
            if(i%2 == 0){
                total += Character.getNumericValue(isbn.charAt(i));
            }else {
                total += Character.getNumericValue(isbn.charAt(i)) *3;
            }
        }
        return total;
    }
}
