package com.concurrency.readwritelock.example;

public class CounterReader implements Runnable {

	private volatile SimpleCounter simpleCounter;
	
	
	public CounterReader(SimpleCounter simpleCounter) {
	
		this.simpleCounter = simpleCounter;
	}
	
	@Override
	public void run() {
		
		while(true){
			
			int value = this.simpleCounter.readCounterWithThreadSafety();
			System.out.println(Thread.currentThread().getName() + " reads " + value);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
