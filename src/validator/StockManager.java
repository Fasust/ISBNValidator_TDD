package validator;

public class StockManager {

    private ExternalISBNService webService;
    private ExternalISBNService dataBaseService;

    public void setWebService(ExternalISBNService service) {
        this.webService = service;
    }
    public void setDataBaseService(ExternalISBNService service) {
        this.dataBaseService = service;
    }

    /**
    *LocatorCode = Last 4 Digits of ISBN + Initial of Author + Number of Words in Title
    *First Tray tp Lookup in local DB, if not saved, get it from webService
    **/
     public String getLocatorCode(String isbn) {
        Book book = dataBaseService.lookUp(isbn);
        if(book == null) book = webService.lookUp(isbn);

        return isbn.substring(isbn.length() - 4) +
                book.getAuthor().substring(0, 1) +
                book.getTitle().split(" ").length;
    }
}
