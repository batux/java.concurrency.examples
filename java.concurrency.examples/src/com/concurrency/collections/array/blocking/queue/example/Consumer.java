package com.concurrency.collections.array.blocking.queue.example;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

	private final BlockingQueue<Message> blockingQueue;
	
	public Consumer(BlockingQueue<Message> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}
	
	@Override
	public void run() {
		
		try {
			
			Message message;
			
			while( !"exit".equals((message = this.blockingQueue.take()).getValue()) ) {
				
				System.out.println("Consumer: " + message.getValue() + " Queue Size: " + this.blockingQueue.size());
				
				Thread.sleep(50);
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	
	
}
