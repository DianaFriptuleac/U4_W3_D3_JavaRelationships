package Diana_Friptuleac.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(long id) {
        super("L'id " + id + " non è stato trovato");
    }

}
