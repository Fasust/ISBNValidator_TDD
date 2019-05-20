package validator;

public class StockManager {

    private ExternalISBNService service;

    public void setService(ExternalISBNService service) {
        this.service = service;
    }

    //LocatorCode = Last 4 Digits of ISBN + Initial of Author + Number of Words in Title
    public String getLocatorCode(String isbn) {
        Book book = service.lookUp(isbn);
        StringBuilder locator = new StringBuilder();

        locator.append(isbn, isbn.length() - 4, isbn.length());
        locator.append(book.getAuthor(), 0, 1);
        locator.append(book.getTitle().split(" ").length);

        return locator.toString();
    }
}
