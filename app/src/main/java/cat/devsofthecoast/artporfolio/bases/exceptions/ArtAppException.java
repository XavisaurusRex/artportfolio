package cat.devsofthecoast.artporfolio.bases.exceptions;
public class ArtAppException extends Exception {
    public ArtAppException() {
    }

    public ArtAppException(String message) {
        super(message);
    }

    public ArtAppException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArtAppException(Throwable cause) {
        super(cause);
    }

    public ArtAppException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
