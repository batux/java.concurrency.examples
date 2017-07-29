package com.concurrency.threadlocal.example;

public class CounterUpdater implements Runnable {

	private String threadName;
	
	private volatile SimpleCounter simpleCounter;
	
	public CounterUpdater(SimpleCounter simpleCounter, String threadName) {
		this.threadName = threadName;
		this.simpleCounter = simpleCounter;
	}
	
	@Override
	public void run() {
		
		for(int i=0; i < 30; i++) {
			this.simpleCounter.increment();
			System.out.println(this.threadName + " changed to " + this.simpleCounter.getCurrentValue());
		}
		
	}

}
