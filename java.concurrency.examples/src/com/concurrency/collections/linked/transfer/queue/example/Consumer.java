package com.concurrency.collections.linked.transfer.queue.example;

import java.util.concurrent.TransferQueue;

public class Consumer implements Runnable{

	private final TransferQueue<Integer> linkedTransferQueue;
	
	
	public Consumer(TransferQueue<Integer> linkedTransferQueue) {
		
		this.linkedTransferQueue = linkedTransferQueue;
	}
	
	@Override
	public void run() {
		
		while(true) {
			
			try {
				
				int number = this.linkedTransferQueue.take();
			
				System.out.println("Consumer-" + Thread.currentThread().getName() + " took " + number + " from queue");
				
				Thread.sleep(1923);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}

}
