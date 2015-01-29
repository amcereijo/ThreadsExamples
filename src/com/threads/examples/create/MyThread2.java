package com.threads.examples.create;

class MyThread2 extends Thread {
	public void run() {
		System.out.println("In run method; thread name is: "
				+ getName());
	}

	public static void main(String args[]) throws Exception {
		Thread myThread = new MyThread2();
		myThread.start();//run(); 
		System.out.println("In main method; thread name is : "
				+ Thread.currentThread().getName());
	}
}
