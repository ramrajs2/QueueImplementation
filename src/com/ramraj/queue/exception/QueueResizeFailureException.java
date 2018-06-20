package com.ramraj.queue.exception;

/**
 * Exception thrown when queue resizing fails
 *
 * @author Ramraj
 */
public class QueueResizeFailureException extends Throwable
{


    /**
     * Construct {@link QueueResizeFailureException} without any parameters.
     */
    public QueueResizeFailureException()
    {
        super();
    }

    /**
     * Construct {@link QueueResizeFailureException} with a message.
     *
     * @param message for constructing the exception.
     */
    public QueueResizeFailureException(String message)
    {
        super(message);
    }

    /**
     * Construct {@link QueueResizeFailureException} with a throwable.
     *
     * @param cause for constructing the exception.
     */
    public QueueResizeFailureException(Throwable cause)
    {
        super(cause);
    }

    /**
     * Construct {@link QueueResizeFailureException} with a message and throwable.
     *
     * @param message for constructing the exception.
     * @param cause   for constructing the exception.
     */
    public QueueResizeFailureException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
