package com.concurrency.collections.array.blocking.queue.example;

public class Message {

	private final String value;
	
	public Message(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	
}
