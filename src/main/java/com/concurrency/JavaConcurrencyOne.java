package com.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JavaConcurrencyOne {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(3);
		for (int i = 1; i <=3; i++) {
			Runnable dbCache = new CacheDB("CacheDB" + i);
			executor.execute(dbCache);
		}
		executor.shutdown();
		while (!executor.isTerminated()) {
		}
		System.out.println("Finished all threads");
	}

}

class CacheDB implements Runnable {

	private String command;

	public CacheDB(String s) {
		this.command = s;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " Start. Command = " + command);
		processDBCommand();
		System.out.println(Thread.currentThread().getName() + " End.");
	}

	private void processDBCommand() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return this.command;
	}
}