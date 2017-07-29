package com.concurrency.collections.sync.blocking.queue.example;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{

	private final BlockingQueue<String> blockingQueue;
	
	public Consumer(BlockingQueue<String> blockingQueue) {
		
		this.blockingQueue = blockingQueue;
	}
	
	@Override
	public void run() {
		
		while(true) {
			
			try {
			
				System.out.println("Consumer-" + Thread.currentThread().getName() + " - Before Take Operation");
				
				String dataItem = this.blockingQueue.take();
				
				System.out.println("Consumer-" + Thread.currentThread().getName() + " - After Take Operation (Value: " + dataItem + ")");
				
				Thread.sleep(1000);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}

}
