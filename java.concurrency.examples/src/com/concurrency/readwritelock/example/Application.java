package com.concurrency.readwritelock.example;

public class Application {

	public static void main(String[] args) {

		final SimpleCounter simpleCounter = new SimpleCounter();
		
		CounterReader reader1 = new CounterReader(simpleCounter);
		CounterReader reader2 = new CounterReader(simpleCounter);
		CounterReader reader3 = new CounterReader(simpleCounter);
	
		Thread readerThread1 = new Thread(reader1);
		Thread readerThread2 = new Thread(reader2);
		Thread readerThread3 = new Thread(reader3);
		
		CounterUpdater writer1 = new CounterUpdater(simpleCounter);
		CounterUpdater writer2 = new CounterUpdater(simpleCounter);
		
		
		Thread writerThread1 = new Thread(writer1);
		Thread writerThread2 = new Thread(writer2);
		
		writerThread1.start();
		writerThread2.start();
		
		readerThread1.start();
		readerThread2.start();
		readerThread3.start();
		
	}

}
