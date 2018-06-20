package com.ramraj.queue.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Rule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import com.ramraj.queue.IQueue;
import com.ramraj.queue.exception.EmptyQueueException;
import com.ramraj.queue.exception.FullQueueException;
import com.ramraj.queue.helper.UnitTestHelper;

/**
 * Test class to test the queue implementation
 *
 * @author Ramraj
 */
class QueueImplTest
{
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    void testIfGetFailsOnEmptyQueue()
    {
        IQueue queue = UnitTestHelper.getEmptyQueue();
        exception.expect(EmptyQueueException.class);
        queue.get();
    }

    @Test
    void testIfPutFailsOnFullQueue() throws FullQueueException
    {
        IQueue queue = UnitTestHelper.getFullQueue();
        exception.expect(FullQueueException.class);
        queue.put(55);
    }

}