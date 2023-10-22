package mail;

public class StolenPackageException extends RuntimeException {

    public StolenPackageException(String message) {
        super(message);

    }

    public StolenPackageException(String message, Throwable cause) {
        super(message, cause);
    }
}
