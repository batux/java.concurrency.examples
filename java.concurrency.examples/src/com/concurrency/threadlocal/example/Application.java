package com.concurrency.threadlocal.example;

public class Application {

	public static void main(String[] args) {

		SimpleCounter simpleCounter = new SimpleCounter();
		
		CounterUpdater updater1 = new CounterUpdater(simpleCounter, "thread1");
		CounterUpdater updater2 = new CounterUpdater(simpleCounter, "thread2");
		CounterUpdater updater3 = new CounterUpdater(simpleCounter, "thread3");
		
		Thread thread1 = new Thread(updater1);
		Thread thread2 = new Thread(updater2);
		Thread thread3 = new Thread(updater3);
		
		thread1.start();
		thread2.start();
		thread3.start();
		
	}

}
