package validator;

public class StockManager {

    private ExternalISBNService service;

    public void setService(ExternalISBNService service) {
        this.service = service;
    }

    //LocatorCode = Last 4 Digits of ISBN + Initial of Author + Number of Words in Title
    public String getLocatorCode(String isbn) {
        Book book = service.lookUp(isbn);

        return isbn.substring(isbn.length() - 4) +
                book.getAuthor().substring(0, 1) +
                book.getTitle().split(" ").length;
    }
}
