package com.yahtzee.components;

public class ScoreCalculator {

	public int[] scores = new int[Card.CARD_SIZE];
	public ScoringDice[] hand = new ScoringDice[Card.HAND_SIZE];

	/**
	 * 
	 * @param empty is an array of booleans that demonstrates the usability of the index
	 */
	public ScoreCalculator(ScoringDice[] round) {

		for (int k = 0; k < Card.HAND_SIZE; k++) {
			hand[k] = round[k];
		}

		this.calculate();
	}

	/*
	   * calculate determines the score of the card based on an array of dice
	   * 
	   * @param Dice[] representing the dice array, int row representing the chosen row
	   *        int handides representing the amount of sides per dice
	   * @returns void
	   * @throw null
	   */
	public void calculate() {

		scores[0] = leaderSum(ScoringDice.Country.USA);
		scores[1] = leaderSum(ScoringDice.Country.SOVIET_UNION);
		scores[2] = leaderSum(ScoringDice.Country.UK);
		scores[3] = leaderSum(ScoringDice.Country.CHINA);
		scores[4] = leaderSum(ScoringDice.Country.FRANCE);
		scores[5] = ceaseFire();
		scores[6] = treaty();
		scores[7] = bigThree();
		scores[8] = aroundWorld();
		scores[9] = unitedNations();
		scores[10] = pact();
		scores[11] = pearlHarbor();
		scores[12] = dDay();

	}

	/*
	 * provides the sum of values for the specified country less the axis dice
	 */
	private int leaderSum(ScoringDice.Country leader) {
		int total = 0;
		for (ScoringDice die : hand) {
			if (die.getCountryName() == leader || die.getSide() == ScoringDice.Allegiance.AXIS) {
				total += die.getValue();
			}
		}
		return total;
	}

	private int ceaseFire() {
		int ally = 0;
		for (ScoringDice die : hand) {
			if (die.getSide() == ScoringDice.Allegiance.ALLIES) {
				ally++;
			}
		}

		if (ally <= 1)
			return 30;
		else
			return 0;
	}

	private int treaty() {
		int germany = 0;
		int sunion = 0;
		int other = 0;
		for (ScoringDice die : hand) {
			if (die.getCountryName() == ScoringDice.Country.GERMANY) {
				germany++;
			} else if (die.getCountryName() == ScoringDice.Country.SOVIET_UNION) {
				sunion++;
			} else {
				other++;
			}
		}
		if (germany > 0 && sunion > 0 && other < 1)
			return 30;
		else
			return 0;
	}

	private int bigThree() {
		int usa = 0;
		int uk = 0;
		int sunion = 0;
		int other = 0;
		for (ScoringDice die : hand) {
			if (die.getCountryName() == ScoringDice.Country.USA) {
				usa++;
			} else if (die.getCountryName() == ScoringDice.Country.UK) {
				uk++;
			} else if (die.getCountryName() == ScoringDice.Country.SOVIET_UNION) {
				sunion++;
			} else {
				other++;
			}
		}
		if (usa > 0 && uk > 0 && sunion > 0 && other < 1)
			return 50;
		else
			return 0;
	}

	private int aroundWorld() {
		int usa = 0;
		int uk = 0;
		int sunion = 0;
		int italy = 0;
		int china = 0;
		int japan = 0;
		int france = 0;
		int germany = 0;

		for (ScoringDice die : hand) {
			if (die.getCountryName() == ScoringDice.Country.USA) {
				usa++;
			} else if (die.getCountryName() == ScoringDice.Country.UK) {
				uk++;
			} else if (die.getCountryName() == ScoringDice.Country.SOVIET_UNION) {
				sunion++;
			} else if (die.getCountryName() == ScoringDice.Country.ITALY) {
				italy++;
			} else if (die.getCountryName() == ScoringDice.Country.CHINA) {
				china++;
			} else if (die.getCountryName() == ScoringDice.Country.JAPAN) {
				japan++;
			} else if (die.getCountryName() == ScoringDice.Country.FRANCE) {
				france++;
			} else {
				germany++;
			}
		}
		if (usa > 0 && uk > 0 && sunion > 0 && italy > 0 && china > 0 && japan > 0 && france > 0 && germany > 0)
			return 60;
		else
			return 0;
	}

	private int unitedNations() {
		for (ScoringDice die : hand) {
			if (die.getSide() == ScoringDice.Allegiance.AXIS)
				return 0;
		}
		return 70;

	}

	private int pact() {
		for (ScoringDice die : hand) {
			if (die.getSide() == ScoringDice.Allegiance.ALLIES)
				return 0;
		}
		return 70;
	}

	private int pearlHarbor() {
		ScoringDice.Country counting = hand[0].getCountryName();
		for (int k = 1; k < Card.HAND_SIZE; k++) {
			if (counting != hand[k].getCountryName()) {
				return 0;
			} else {
				counting = hand[k].getCountryName();
			}
		}
		return 100;

	}

	private int dDay() {
		int sum = 0;
		for (ScoringDice die : hand) {
			if (die.getSide() == ScoringDice.Allegiance.ALLIES)
				sum += die.getValue();
		}
		return sum;
	}

}
