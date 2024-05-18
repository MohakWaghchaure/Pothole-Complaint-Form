package app.exceptions;

/**
 * Exception thrown when a given complaintID is not found in the database.
 */
public class ComplaintNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 3702054678344088626L;

    /**
     * Exception with no message or cause.
     */
    public ComplaintNotFoundException() {
        super();
    }

    /**
     * Exception with a message, but no cause.
     * @param message A descriptive message for this exception.
     */
    public ComplaintNotFoundException(String message) {
        super(message);
    }

    /**
     * Exception with no message, but with a cause.
     * @param cause The original throwable resulting in this exception.
     */
    public ComplaintNotFoundException(Throwable cause) {
        super(cause);
    }

    /**
     * Exception with message and cause.
     * @param message A descriptive message for this exception.
     * @param cause The original throwable resulting in this exception.
     */
    public ComplaintNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
