package com.ramraj.queue.impl;

import com.ramraj.queue.IQueue;
import com.ramraj.queue.exception.EmptyQueueException;

/**
 * Implementation of {@link IQueue}
 *
 * @author Ramraj
 *
 * @param <T> Type of items stores in queue
 */
public class QueueImpl<T> implements IQueue<T>{

	private T[] items;
	private int arraySize;
	private int head;
	private int tail;

	public QueueImpl(int initialSize) {
		items = (T[]) new Object[initialSize];
		arraySize = initialSize;
		head = -1;
		tail = -1;
	}

	@Override
	public T get() throws EmptyQueueException
	{
		if(isEmpty()) {
			throw new EmptyQueueException("Queue is Empty");
		}

		T item = items[head];
		if(head == tail) {
			head = tail = -1;
		}
		else {
			head = (head + 1) % arraySize;
		}
		return item;
	}

	@Override
	public boolean put(T item) {
		return false;
	}

	@Override
	public boolean isEmpty() {
		return head == -1;
	}

	@Override
	public boolean isFull() {
		return (tail+1)%arraySize == head;
	}

	@Override
	public void print() {
	}

	@Override
	public boolean peek() {
		return false;
	}

	@Override
	public boolean resize(int size) {
		return false;
	}

}
