package com.ramraj.queue;

import com.ramraj.queue.exception.EmptyQueueException;
import com.ramraj.queue.exception.FullQueueException;

/**
 * Generic interface to define the features of my queues
 * 
 * @author Ramraj
 *
 * @param <T> - Defines the type of object that this queue 
 * 				is going to handle
 */
public interface IQueue<T> {
	/**
	 * Returns the item on the head of the queue and
	 * removes it from the queue
	 * 
	 * @return item on the head
	 * @throws EmptyQueueException if queue is empty
	 */
	public T get() throws EmptyQueueException;
	
	/**
	 * Add the item to the queue's tail
	 * 
	 * @param item
	 * @return
	 */
	public boolean put(T item) throws FullQueueException;
	
	/**
	 * Returns the items on the head but doesn't remove it
	 * from the queue
	 * 
	 * @return null if the queue is empty
	 * 		   item pointed by head, if the queue is not empty
	 */
	public T peek();
	
	/**
	 * @return true  if the queue is empty
	 * 		   false if the queue is not empty
	 */
	public boolean isEmpty();
	
	/**
	 * @return true  if the queue is full
	 * 		   false if the queue is not full
	 */
	public boolean isFull();
	
	/**
	 * Prints the items in the queue
	 */
	public void print();
	
	/**
	 * Resizes the array with given value
	 * 
	 * @param size New size for the array
	 * @return
	 */
	public boolean resize(int size);
}
