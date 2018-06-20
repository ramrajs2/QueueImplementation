package com.ramraj.queue.helper;

import com.ramraj.queue.IQueue;
import com.ramraj.queue.exception.FullQueueException;
import com.ramraj.queue.impl.QueueImpl;

/**
 * Helper class to provide test data
 *
 * @author Ramraj
 */
public final class UnitTestHelper
{
    private static IQueue<Integer> fullQueue;
    private static final IQueue<Integer> emptyQueue = new QueueImpl<>(5);

    public static IQueue<Integer> getFullQueue()
    {
        if(fullQueue == null) {
            fullQueue = new QueueImpl<>(4);
            try
            {
                fullQueue.put(1);
                fullQueue.put(2);
                fullQueue.put(3);
                fullQueue.put(4);
            }
            catch (FullQueueException e)
            {
                e.printStackTrace();
            }
        }
        return fullQueue;
    }

    public static IQueue<Integer> getEmptyQueue()
    {
        return emptyQueue;
    }
}
