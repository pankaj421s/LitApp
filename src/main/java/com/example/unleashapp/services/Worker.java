package com.example.unleashapp.services;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Worker implements Runnable {
	private List<String> outputScraper;
	private CountDownLatch countDownLatch;

	public Worker(List<String> outputScraper, CountDownLatch countDownLatch) {
		super();
		this.outputScraper = outputScraper;
		this.countDownLatch = countDownLatch;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}
