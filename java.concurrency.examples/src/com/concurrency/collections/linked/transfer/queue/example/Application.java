package com.concurrency.collections.linked.transfer.queue.example;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class Application {

	public static void main(String[] args) {

		TransferQueue<Integer> linkedTransferQueue = new LinkedTransferQueue<>();
		
		
		Consumer consumer1 = new Consumer(linkedTransferQueue);
		Consumer consumer2 = new Consumer(linkedTransferQueue);
		Consumer consumer3 = new Consumer(linkedTransferQueue);
		
		Thread consumerThread1 = new Thread(consumer1);
		Thread consumerThread2 = new Thread(consumer2);
		Thread consumerThread3 = new Thread(consumer3);
		
		consumerThread1.start();
		consumerThread2.start();
		consumerThread3.start();
		
		
		
		Producer producer1 = new Producer(linkedTransferQueue);
		Producer producer2 = new Producer(linkedTransferQueue);
		
		Thread producerThread1 = new Thread(producer1);
		Thread producerThread2 = new Thread(producer2);
		
		producerThread1.start();
		producerThread2.start();
	}

}
