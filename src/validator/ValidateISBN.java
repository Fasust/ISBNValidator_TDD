package validator;

public class ValidateISBN {

    public boolean checkISBN(String isbn) {
        int total = 0;

        for(int i = 0; i< isbn.length(); i++){
            total += (int) isbn.charAt(i) * (10 - i);
        }

        return total % 11 == 0;
    }
}