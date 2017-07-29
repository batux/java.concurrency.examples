package com.concurrency.collections.sync.blocking.queue.example;

import java.util.UUID;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{

	private final BlockingQueue<String> blockingQueue;
	
	public Producer(BlockingQueue<String> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}
	
	@Override
	public void run() {
		
		while(true) {
			
			try {
				
				System.out.println("Producer-" + Thread.currentThread().getName() +  " - Before Put Operation");
				
				String dataItem = UUID.randomUUID().toString();
			
				this.blockingQueue.put(dataItem);
			
				System.out.println("Producer-" + Thread.currentThread().getName() + " - After Put Operation ( Value: " + dataItem + ")");
				
				Thread.sleep(500);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}

}
