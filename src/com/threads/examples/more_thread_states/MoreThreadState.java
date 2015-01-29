package com.threads.examples.more_thread_states;

public class MoreThreadState {

	
	class SleepyThread extends Thread{
		@Override
		public void run() {
			synchronized(SleepyThread.class) {
				try {
					Thread.sleep(1000);
				}catch(InterruptedException ie) {
				// its okay to ignore this exception since we're not interrupting exceptions in this code
					ie.printStackTrace();
				}
			}
		}
	}
	
	// The class creates two threads to show how to these threads will enter into
	// TIMED_WAITING and BLOCKED states
	public static void main(String[] args) {
		MoreThreadState mt = new MoreThreadState();
		Thread t1 = mt.new SleepyThread();
		Thread t2 = mt.new SleepyThread();
		
		t1.start();
		t2.start();
		System.out.println(t1.getName() + ": I'm in state " + t1.getState());
		System.out.println(t2.getName() + ": I'm in state " + t2.getState());
	}
	
}
