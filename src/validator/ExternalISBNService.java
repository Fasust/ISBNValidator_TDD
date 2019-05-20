package validator;

public interface ExternalISBNService {
    Book lookUp(String isbn);
}
