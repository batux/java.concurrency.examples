package com.concurrency.threadlocal.example;

public class SimpleCounter {

	private ThreadLocal<Integer> counter = new ThreadLocal<Integer>() {
		@Override
		protected Integer initialValue() {
			return 0;
		}
	};
	
	public Integer getCurrentValue() {
		
		return this.counter.get();
		
	}
	
	public void increment() {
		
		counter.set(counter.get() + 1);
		
	}
	
	public void decrement() {
		
		counter.set(counter.get() - 1);
		
	}
}
