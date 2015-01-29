package com.threads.examples.wait_notify.dicegame;

import java.util.Random;

//the Dice class abstracts how the dice rolls and who plays it
public class Dice {

	// to remember whose turn it is to roll the dice
	private static String turn = null;
	// when we roll the dice, it should give a random result
	private static Random random = new Random();

	// prevent instantiating the class by making it private (we've only static members)
	private Dice() {
	}
	
	public synchronized static String getTurn() {
		return turn;
	}

	public synchronized static void setTurn(String player) {
		turn = player;
	}

	// which player starts the game
	public static void setWhoStarts(String name) {
		turn = name;
	}
	
	// random.nextInt(6) gives values from 0 to 5, so add 1 to result in roll()
	public static int roll() {
		return random.nextInt(6) + 1;
	}

}
