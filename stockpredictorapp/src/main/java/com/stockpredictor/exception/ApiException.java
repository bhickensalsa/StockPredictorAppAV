package com.stockpredictor.exception;

/**
 * {@code ApiException} is a custom unchecked exception used to indicate
 * failures during API communication or data processing.
 *
 * <p>This exception is typically thrown when a response from an external
 * API (e.g., Alpha Vantage) is invalid, unsuccessful, or cannot be parsed correctly.
 */
public class ApiException extends RuntimeException {

    /**
     * Constructs a new {@code ApiException} with the specified detail message.
     *
     * @param message the detail message explaining the reason for the exception
     */
    public ApiException(String message) {
        super(message);
    }

    /**
     * Constructs a new {@code ApiException} with the specified detail message and cause.
     *
     * @param message the detail message explaining the reason for the exception
     * @param cause the underlying cause of the exception (e.g., {@link java.io.IOException})
     */
    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }
}
