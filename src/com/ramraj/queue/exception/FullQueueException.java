package com.ramraj.queue.exception;

/**
 * Exception thrown when code tries to insert into a full queue
 *
 * @author Ramraj
 */
public class FullQueueException extends Throwable
{

    /**
     * Construct {@link FullQueueException} without any parameters.
     */
    public FullQueueException()
    {
        super();
    }

    /**
     * Construct {@link FullQueueException} with a message.
     *
     * @param message for constructing the exception.
     */
    public FullQueueException(String message)
    {
        super(message);
    }

    /**
     * Construct {@link FullQueueException} with a throwable.
     *
     * @param cause for constructing the exception.
     */
    public FullQueueException(Throwable cause)
    {
        super(cause);
    }

    /**
     * Construct {@link FullQueueException} with a message and throwable.
     *
     * @param message for constructing the exception.
     * @param cause   for constructing the exception.
     */
    public FullQueueException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
