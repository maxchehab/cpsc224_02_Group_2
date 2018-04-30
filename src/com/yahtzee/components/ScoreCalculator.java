/**
 * creates an array of scores for a set of ScoringDice
 * 
 * @author afellger
 */
package com.yahtzee.components;

public class ScoreCalculator {

	public int[] scores = new int[Card.CARD_SIZE];
	public ScoringDice[] hand = new ScoringDice[Card.HAND_SIZE];
	
	public static int upperTotal;
	public static int enolaGay;
	public static int lowerTotal;
	public static int grandTotal;

	/**
	 * creates a ScoreCalculator, populates scores.
	 * @param ScoringDice[] round: a set of Card.HAND_SIZE ScoringDice
	 */
	public ScoreCalculator(ScoringDice[] round) {

		for (int k = 0; k < Card.HAND_SIZE; k++) {
			hand[k] = round[k];
		}

		this.calculate();
	}

	/**
	 * calls scoring functions on the appropriate indices so that the scores for each category will be stored
	 * in scores.
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

	/**
	 * provides a score for an upper scorecard category
	 * @param ScoringDice.Country leader: country from which the category's score will be based
	 * @return total score for a given leader less AXIS dice values.
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

	/**
	 * scores the "Cease Fire" category by determining if there are four allies and four axis members
	 * @return 30 as score if the requirements are met, and 0 otherwise.
	 */
	private int ceaseFire() {
		int ally = 0;
		for (ScoringDice die : hand) {
			if (die.getSide() == ScoringDice.Allegiance.ALLIES) {
				ally++;
			}
		}

		if (ally == 4)
			return 30;
		else
			return 0;
	}

	/**
	 * scores the "Treaty of Friendship" category by determining if there are three or more of both
	 * German dice and Soviet Union dice.
	 * @return 30 as score if the requirements are met, and 0 otherwise.
	 */
	private int treaty() {
		int germany = 0;
		int sunion = 0;
		for (ScoringDice die : hand) {
			if (die.getCountryName() == ScoringDice.Country.GERMANY) {
				germany++;
			} else if (die.getCountryName() == ScoringDice.Country.SOVIET_UNION) {
				sunion++;
			}
		}
		if (germany >= 3 && sunion >= 3)
			return 30;
		else
			return 0;
	}
	
	/**
	 * scores the "Big Three" category by determining if there are at least two USA dice, two Soviet Union dice,
	 * and two UK dice.
	 * @return 50 as score if the requirements are met, and 0 otherwise.
	 */
	private int bigThree() {
		int usa = 0;
		int uk = 0;
		int sunion = 0;
		for (ScoringDice die : hand) {
			if (die.getCountryName() == ScoringDice.Country.USA) {
				usa++;
			} else if (die.getCountryName() == ScoringDice.Country.UK) {
				uk++;
			} else if (die.getCountryName() == ScoringDice.Country.SOVIET_UNION) {
				sunion++;
			}
		}
		if (usa >= 2 && uk >= 2 && sunion >= 2)
			return 50;
		else
			return 0;
	}

	/**
	 * scores the "Around the World" category by determining if there is one of each country's die
	 * @return 60 as score if the requirements are met, and 0 otherwise.
	 */
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

	/**
	 * scores the "United Nations" category by determining if there are only ALLIES in the hand.
	 * @return 70 as score if the requirements are met, and 0 otherwise.
	 */
	private int unitedNations() {
		for (ScoringDice die : hand) {
			if (die.getSide() == ScoringDice.Allegiance.AXIS)
				return 0;
		}
		return 70;

	}

	/**
	 * scores the "Tripartite Pact" category by determining if there are only AXIS members in the hand.
	 * @return 70 as score if the requirements are met, and 0 otherwise.
	 */
	private int pact() {
		for (ScoringDice die : hand) {
			if (die.getSide() == ScoringDice.Allegiance.ALLIES)
				return 0;
		}
		return 70;
	}

	/**
	 * scores the "Pearl Harbor" category by determining if the hand consists of only one Country's dice.
	 * @return 100 as score if the requirements are met, and 0 otherwise.
	 */
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

	/**
	 * scores the "D-Day" category by summing up all ALLY dice and ignoring AXIS dice.
	 * @return sum of all ALLY dice values.
	 */
	private int dDay() {
		int sum = 0;
		for (ScoringDice die : hand) {
			if (die.getSide() == ScoringDice.Allegiance.ALLIES)
				sum += die.getValue();
		}
		return sum;
	}
}
