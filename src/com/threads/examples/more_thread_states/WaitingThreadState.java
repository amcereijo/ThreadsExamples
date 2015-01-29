package com.threads.examples.more_thread_states;

public class WaitingThreadState {

	// This class has run method which waits forever since there is no other
	// thread to notify it
	static class InfiniteWaitThread extends Thread {
		static boolean okayToRun = false;

		public synchronized void run() {
			while (!okayToRun) {
				try {
					// note the call to wait without any timeout value
					// so it waits forever for some thread to notify it
					wait();
				} catch (InterruptedException ie) {
					// its okay to ignore this exception since we're not interrupting exceptions in this code
					ie.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String []s) {
		Thread t = new InfiniteWaitThread();
		t.start();
		System.out.println(t.getName() + ": I'm in state " + t.getState());
	}

}
