package com.concurrency.readwritelock.example;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SimpleCounter {

	private volatile int counter;
	
	private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	
	
	public SimpleCounter() {
		this.counter = 0;
	}
	
	public void incrementCounterWithoutThreadSafety(String threadName) {

		this.counter++;
		System.out.println("Counter was updated to '" + this.counter + "' from " + threadName);
	}
	
	public int readCounterWithoutThreadSafety() {
		return this.counter;
	}
	
	
	public void incrementCounterWithThreadSafety(String threadName) {
		
		this.readWriteLock.writeLock().lock();
		
		try {
			this.counter++;
			System.out.println("Counter was updated to '" + this.counter + "' from " + threadName);
		}
		finally {
			this.readWriteLock.writeLock().unlock();
		}
		
	}
	
	
	public int readCounterWithThreadSafety() {
		
		this.readWriteLock.readLock().lock();
		
		try {
			return this.counter;
		}
		finally {
			this.readWriteLock.readLock().unlock();
		}
		
	}
	
	
}