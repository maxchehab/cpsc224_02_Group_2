/**
 * Stores a user's scores for each "mission" category and whether or not a category has been scored.
 * 
 * @author afellger
 */
package com.yahtzee.components;

public class Card {
	public final static int CARD_SIZE = 13;
	public final static int HAND_SIZE = 8;
	public final static int DIE_SIZE = 8;

	public int [] score = new int[CARD_SIZE];
	public boolean [] usable = new boolean[CARD_SIZE];

	public Card() {
		for(int k = 0; k < CARD_SIZE; k++) {
			score[k] = 0;
			usable[k] = true;
		}
	}

	/**
	 * provides a string containing the score stored at a given index.
	 * @param int index a value from 0 to CARD_SIZE
	 * @return String containing the value held at index.
	 */
	public String getScore(int index) {
		String scoreString = "";
		scoreString += score[index];
		
		return scoreString;
	}
}
