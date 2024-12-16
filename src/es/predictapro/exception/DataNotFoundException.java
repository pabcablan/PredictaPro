package es.predictapro.exception;

/**
 * DataNotFoundException is a custom runtime exception.
 * <p>
 * This exception is thrown when the required data is not found in the system.
 * It extends {@link RuntimeException}, allowing it to be used without mandatory try-catch blocks.
 * </p>
 */
public class DataNotFoundException extends RuntimeException {

    /**
     * Constructor for DataNotFoundException.
     *
     * @param message A detailed message describing the exception cause.
     */
    public DataNotFoundException(String message) {
        super(message);
    }
}
