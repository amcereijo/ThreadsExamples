package com.threads.examples.concurrent_access;

//This class exposes a publicly accessible counter
//to help demonstrate data race problem
//Syncrhonyze increment method
public class DataRaceSync {

	public static void main(String args[]) {
		UseCounter c = new UseCounter();
		Thread t1 = new Thread(c);
		Thread t2 = new Thread(c);
		Thread t3 = new Thread(c);
		t1.start();
		t2.start();
		t3.start();
	}

	public static class Counter {
		public static long count = 0;
		public static long count2 = 0;
	}

	// This class implements Runnable interface
	// Its run method increments the counter three times
	public static class UseCounter implements Runnable {
		public void increment() {
			// increments the counter and prints the value
			// of the counter shared between threads
			synchronized (this) {
				Counter.count++;
				System.out.println("In increment: "+ Counter.count + " ");
			}
		}

		public synchronized void incrementSync() {
			// increments the counter and prints the value
			// of the counter shared between threads
			Counter.count2++;
			System.out.println("In incrementSync: "+ Counter.count2 + " ");
		}

		public void run() {
			
			increment();
			incrementSync();
			SomeClassWithStatic.incrementSyn();
			SomeClassWithStatic.increment();
			increment();
			incrementSync();
			SomeClassWithStatic.incrementSyn();
			SomeClassWithStatic.increment();
			increment();
			incrementSync();
			SomeClassWithStatic.incrementSyn();
			SomeClassWithStatic.increment();
		}
	}



}
