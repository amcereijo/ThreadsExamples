package com.threads.examples.options;

public class SimpleThread {

	public static void main(String[] args) {
		
		System.out.println("Minimum priority of a thread: " + Thread.MIN_PRIORITY);
		System.out.println("Normal priority of a thread: " + Thread.NORM_PRIORITY);
		System.out.println("Maximum priority of a thread: " + Thread.MAX_PRIORITY);
		
		
		Thread t = new Thread();
		System.out.println(t);
		
		t = new Thread();
		t.setName("SimpleThread");
		t.setPriority(9);
		System.out.println(t);
		
		MyRunnable myRunnable = new MyRunnable();
		Thread tMin = new Thread(myRunnable);
			tMin.setName("tMin");
			tMin.setPriority(Thread.MIN_PRIORITY);
		Thread tMiddle = new Thread(myRunnable);
			tMiddle.setName("tMiddle");
			tMiddle.setPriority(Thread.NORM_PRIORITY);
		Thread tMax = new Thread(myRunnable);
			tMax.setName("tMax");
			tMax.setPriority(Thread.MAX_PRIORITY);
		Thread tAny1 = new Thread(myRunnable);
			tAny1.setName("tAny1");
			tAny1.setPriority(3);
		Thread tAny2 = new Thread(myRunnable);
			tAny2.setName("tAny2");
			tAny2.setPriority(7);
			
		tMin.start();
		tAny1.start();
		tMiddle.start();
		tAny2.start();
		tMax.start();
	}
	
	public static class MyRunnable implements Runnable{
		@Override
		public void run() {
			final Thread tRunning = Thread.currentThread();
			System.out.println("Running thread:" + tRunning.getName() + "with priority " +tRunning.getPriority() );
		}
	}
}
