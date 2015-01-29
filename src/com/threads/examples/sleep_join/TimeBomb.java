package com.threads.examples.sleep_join;

public class TimeBomb extends Thread {
	String[] timeStr = { "Zero", "One", "Two", "Three", "Four", "Five", "Six",
			"Seven", "Eight", "Nine" };

	public void run() {
		for (int i = 9; i >= 0; i--) {
			try {
				System.out.println(timeStr[i]);
				Thread.sleep(1000);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}

	public static void main(String[] s) {
		TimeBomb timer = new TimeBomb();
		System.out.println("Starting 10 second count down. . . ");
		timer.start();
		try {
			timer.join(5000);
			System.out.println("it's going to explote!!!");
			timer.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Boom!!!");
	}
}
