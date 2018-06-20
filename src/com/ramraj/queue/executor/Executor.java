package com.ramraj.queue.executor;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.ramraj.queue.IQueue;
import com.ramraj.queue.exception.FullQueueException;
import com.ramraj.queue.exception.QueueResizeFailureException;
import com.ramraj.queue.impl.QueueImpl;

/**
 * @author Ramraj
 */
public class Executor
{

    private static IQueue<Integer> myqueue = new QueueImpl<>(5);
    private static ExecutorService executor = Executors.newFixedThreadPool(10);

    public static void main(String s[])
    {
        for (int i = 0; i < 10; i++)
        {
            executor.submit(new MyCallable());
        }
        executor.shutdown();
    }

    private static class MyCallable implements Callable
    {

        int randomVal = new Random().nextInt(100);

        @Override
        public Object call() throws Exception
        {
            String threadName = Thread.currentThread().getName();
            try
            {
                System.out.println(threadName + " puts value " + (randomVal + 1));
                myqueue.put(randomVal++);
                Thread.sleep(1000);
                System.out.println(threadName + " puts value " + (randomVal + 1));
                myqueue.put(randomVal++);
                if (randomVal == 10)
                {
                    myqueue.resize(20);
                }
            }
            catch (FullQueueException e)
            {
                e.printStackTrace();
            }
            catch (QueueResizeFailureException e)
            {
                e.printStackTrace();
            }
            System.out.println(threadName + " gets value " + myqueue.get());
            return null;
        }
    }
}
