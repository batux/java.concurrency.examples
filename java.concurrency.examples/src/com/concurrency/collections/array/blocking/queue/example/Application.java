package com.concurrency.collections.array.blocking.queue.example;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Application {

	public static void main(String[] args) {

		final BlockingQueue<Message> blockingQueue = new ArrayBlockingQueue<>(10);
		
		Producer producer = new Producer(blockingQueue);
		Consumer consumer = new Consumer(blockingQueue);
		
		Thread producerThread = new Thread(producer);
		Thread consumerThread = new Thread(consumer);
		
		producerThread.start();
		System.out.println("Proucer Thread was started!");
		
		consumerThread.start();
		System.out.println("Consumer Thread was started!");
	}

}
