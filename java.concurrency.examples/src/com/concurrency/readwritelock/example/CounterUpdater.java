package com.concurrency.readwritelock.example;

public class CounterUpdater implements Runnable {

	private volatile SimpleCounter simpleCounter;
	
	
	public CounterUpdater(SimpleCounter simpleCounter) {
		
		this.simpleCounter = simpleCounter;
	}
	
	@Override
	public void run() {
		
		for(int i=0; i < 30; i++) {
			
			this.simpleCounter.incrementCounterWithThreadSafety(Thread.currentThread().getName());
			
			try {
				Thread.sleep(25);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
