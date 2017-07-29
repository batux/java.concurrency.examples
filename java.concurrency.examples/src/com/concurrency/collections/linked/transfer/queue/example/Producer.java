package com.concurrency.collections.linked.transfer.queue.example;

import java.util.Random;
import java.util.concurrent.TransferQueue;

public class Producer implements Runnable{

	private final Random randomIntegerGenerator;
	
	private final TransferQueue<Integer> linkedTransferQueue;
	
	
	public Producer(TransferQueue<Integer> linkedTransferQueue) {
		
		this.randomIntegerGenerator = new Random();
		this.linkedTransferQueue = linkedTransferQueue;
	}
	
	@Override
	public void run() {
		
		while(true) {
			
			try {

				int randomInteger = this.randomIntegerGenerator.nextInt(1000);
				
				System.out.println("Producer-" + Thread.currentThread().getName() + " puts " + randomInteger + " to the queue");
				
				this.linkedTransferQueue.transfer(randomInteger);
				
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
		
	}
	
}
