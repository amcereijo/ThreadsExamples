package com.threads.examples.create;

class MyThread3 implements Runnable {
	public void run() {
		System.out.println("In run method; thread name is: "
				+ Thread.currentThread().getName());
	}

	public static void main(String args[]) throws Exception {
		Thread myThread = new Thread(new MyThread3());
		myThread.start();//run(); 
		System.out.println("In main method; thread name is : "
				+ Thread.currentThread().getName());
	}
}