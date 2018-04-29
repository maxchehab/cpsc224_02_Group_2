package com.yahtzee.components;

public class Card {
	public final static int CARD_SIZE = 13;
	public final static int HAND_SIZE = 8;
	public final static int DIE_SIZE = 8;

	public int[] scores = new int[CARD_SIZE];
	public boolean[] usable = new boolean[CARD_SIZE];

	public Card() {
		for (int k = 0; k < CARD_SIZE; k++) {
			scores[k] = 0;
			usable[k] = true;
		}
	}

	public void clearCard() {
		for (int k = 0; k < CARD_SIZE; k++) {
			scores[k] = 0;
			usable[k] = true;
		}
	}

	public void setAScore(int scoreIndex, int score) {
		scores[scoreIndex] = score;
		usable[scoreIndex] = false;
	}
}
