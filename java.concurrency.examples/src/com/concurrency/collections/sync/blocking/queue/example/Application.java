package com.concurrency.collections.sync.blocking.queue.example;

import java.util.concurrent.SynchronousQueue;

public class Application {

	public static void main(String[] args) {

		final SynchronousQueue<String> synchronousQueue = new SynchronousQueue<>();
		
		
		Consumer consumer1 = new Consumer(synchronousQueue);
		Consumer consumer2 = new Consumer(synchronousQueue);
		Consumer consumer3 = new Consumer(synchronousQueue);
		Consumer consumer4 = new Consumer(synchronousQueue);

		
		
		Thread thread1 = new Thread(consumer1);
		Thread thread2 = new Thread(consumer2);
		Thread thread3 = new Thread(consumer3);
		Thread thread4 = new Thread(consumer4);
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		
		
		Producer producer = new Producer(synchronousQueue);
		
		Thread producerThread = new Thread(producer);
		
		producerThread.start();
		
	}

}
