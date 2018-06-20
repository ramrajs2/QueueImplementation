package com.ramraj.queue.impl;

import com.ramraj.queue.IQueue;
import com.ramraj.queue.exception.EmptyQueueException;
import com.ramraj.queue.exception.FullQueueException;
import com.ramraj.queue.exception.QueueResizeFailureException;

/**
 * Implementation of {@link IQueue}
 *
 * @author Ramraj
 *
 * @param <T> Type of items stores in queue
 */
public class QueueImpl<T> implements IQueue<T>{

	private T[] items;
	private int itemCount;
	private int arraySize;
	private int head;
	private int tail;

	public QueueImpl(int initialSize) {
		items = (T[]) new Object[initialSize];
		arraySize = initialSize;
		itemCount = 0;
		head = -1;
		tail = -1;
	}

	@Override
	public T get() throws EmptyQueueException
	{
		if(isEmpty()) {
			throw new EmptyQueueException("Queue is Empty");
		}

		T item;
		synchronized (items)
		{
			item = items[head];
			itemCount--;
			if (itemCount == 0)
			{
				head = tail = -1;
			}
			else
			{
				head = (head + 1) % arraySize;
			}
		}
		return item;
	}

	@Override
	public boolean put(T item) throws FullQueueException
	{
		if(isFull()) {
			throw new FullQueueException("Queue is Full");
		}

		synchronized (items)
		{
			if(head == -1) {
				head++;
			}
			tail = (tail + 1) % arraySize;
			items[tail] = item;
			itemCount++;
		}
		return true;
	}

	@Override
	public boolean isEmpty() {
		return itemCount == 0;
	}

	@Override
	public boolean isFull() {
		return itemCount == arraySize;
	}

	@Override
	public void print() {
		if(itemCount == 0)
		{
			System.out.println("Queue is Empty!!");
			return;
		}
		System.out.println("Queue Items : ");
		for (int i = head; i <= tail; i = (i+1)%arraySize)
		{
			System.out.println(items[i]);
		}
	}

	@Override
	public T peek() {
		if(isEmpty())
			return null;
		T item;
		synchronized (items) {
			item = items[head];
		}
		return item;
	}

	@Override
	public boolean resize(int size) throws QueueResizeFailureException
	{
		if(size < itemCount) {
			throw new QueueResizeFailureException("New capacity is lesser than the current items capacity");
		}

		if(size == arraySize)
			return true;

		synchronized (items)
		{
			T[] newItemsArray = (T[]) new Object[size];
			try
			{
				if(isEmpty()) {
					items = newItemsArray;
					arraySize = size;
					return true;
				}

				int i = head;
				int newArrayindex = 0;
				while (i <= tail)
				{
					newItemsArray[newArrayindex++] = items[i];
					i = (i+1) % arraySize;
				}
				head = 0;
				tail = newArrayindex - 1;
				items = newItemsArray;
				arraySize = size;
			}
			catch (Exception e)
			{
				throw new QueueResizeFailureException("Not able to resize the array", e);
			}
		}
		return  true;
	}

}
