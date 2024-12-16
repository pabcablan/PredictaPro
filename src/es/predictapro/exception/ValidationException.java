package es.predictapro.exception;


/**
 * ValidationException is a custom runtime exception.
 * <p>
 * This exception is thrown when data validation fails. It provides a
 * standardized way to signal validation errors in the application.
 * </p>
 */
public class ValidationException extends RuntimeException {


    /**
     * Constructor for ValidationException.
     *
     * @param message A detailed message describing the validation error.
     */
    public ValidationException(String message) {
        super(message);
    }
}
