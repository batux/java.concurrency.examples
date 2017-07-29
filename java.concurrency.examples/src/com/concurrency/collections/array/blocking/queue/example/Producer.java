package com.concurrency.collections.array.blocking.queue.example;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

	private final BlockingQueue<Message> blockingQueue;

	public Producer(BlockingQueue<Message> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}
	
	@Override
	public void run() {
		
		for(int i=0; i < 30; i++) {
			
			try {

				Message message = new Message(String.valueOf(i));
				this.blockingQueue.put(message);
				
				Thread.sleep(i);
				
				System.out.println("Producer: " + message.getValue() + " Queue Size: " + this.blockingQueue.size());
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
		try {
			Message message = new Message("exit");
			this.blockingQueue.put(message);
			System.out.println("Producer sent 'exit' message!");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
