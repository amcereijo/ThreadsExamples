package com.threads.examples.concurrent_access;


public class SomeClassWithStatic {
	private static int val = 1;
	//private static int val2 = 1 ;

	public static synchronized void incrementSyn() {
		System.out.println("In SomeClassWithStatic.incrementSyn: "+ SomeClassWithStatic.val++);
	}

	public static void increment() {
		synchronized (SomeClassWithStatic.class) {
			System.out.println("In SomeClassWithStatic.increment: "+ SomeClassWithStatic.val++);
		}
	}
}
