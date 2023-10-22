package mail;

public class IllegalPackageException extends RuntimeException {

    public IllegalPackageException(String message) {
        super(message);

    }

    public IllegalPackageException(String message, Throwable cause) {
        super(message, cause);
    }
}
