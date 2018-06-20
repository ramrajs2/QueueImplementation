package com.ramraj.queue.exception;

/**
 * Exception thrown when code tries to retrieve from an empty queue
 *
 * @author Ramraj
 */
public class EmptyQueueException extends RuntimeException {

    /**
     * Construct {@link EmptyQueueException} without any parameters.
     */
    public EmptyQueueException()
    {
        super();
    }

    /**
     * Construct {@link EmptyQueueException} with a message.
     *
     * @param message for constructing the exception.
     */
    public EmptyQueueException(String message)
    {
        super(message);
    }

    /**
     * Construct {@link EmptyQueueException} with a throwable.
     *
     * @param cause for constructing the exception.
     */
    public EmptyQueueException(Throwable cause)
    {
        super(cause);
    }

    /**
     * Construct {@link EmptyQueueException} with a message and throwable.
     *
     * @param message for constructing the exception.
     * @param cause   for constructing the exception.
     */
    public EmptyQueueException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
