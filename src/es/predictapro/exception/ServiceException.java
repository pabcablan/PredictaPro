package es.predictapro.exception;

/**
 * ServiceException is a custom runtime exception.
 * <p>
 * This exception is used to handle errors that occur within service layers.
 * It provides a clear way to signal issues during business logic execution.
 * </p>
 */
public class ServiceException extends RuntimeException {

    /**
     * Constructor for ServiceException.
     *
     * @param message A detailed message describing the error encountered in the service layer.
     */
    public ServiceException(String message) {
        super(message);
    }
}
