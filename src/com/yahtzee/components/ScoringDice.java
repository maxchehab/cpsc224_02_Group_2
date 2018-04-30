package com.yahtzee.components;

public class ScoringDice {
	static final long serialVersionUID = 0;

	enum Country {
		UK, USA, SOVIET_UNION, FRANCE, CHINA, JAPAN, ITALY, GERMANY
	};

	enum Allegiance {
		ALLIES, AXIS
	};

	private int value;
	private Country name;
	private Allegiance side;

	/*
	* Dice sets a value to the dice's value
	*
	* @param int value representing value of the dice
	* @returns Dice
	* @throw null
	*/
	public ScoringDice(PathName path) {
		value = 0;
		name = null;
		side = null;
		populateProperties(path.name);
	}

	/*
	* getValue gets the value of the dice
	*
	* @param null
	* @returns int representing the dice's value
	* @throw null
	*/
	public int getValue() {
		return value;
	}

	/*
	* getName gets the name of the dice
	*
	* @param null
	* @returns Country representing the dice's name
	* @throw null
	*/
	public Country getCountryName() {
		return name;
	}

	/*
	* getSide gets the side of the dice
	*
	* @param null
	* @returns Allegiance representing the dice's side
	* @throw null
	*/
	public Allegiance getSide() {
		return side;
	}

	/*
	* populateProperties sets the side and value fields for a corresponding integer
	
	*/
	public void populateProperties(String countryName) {
		switch (countryName) {
		case "USA":
			name = Country.USA;
			side = Allegiance.ALLIES;
			value = 5;
			break;
		case "UK":
			name = Country.UK;
			side = Allegiance.ALLIES;
			value = 5;
			break;
		case "SOVIET UNION":
			name = Country.SOVIET_UNION;
			side = Allegiance.ALLIES;
			value = 5;
			break;
		case "CHINA":
			name = Country.CHINA;
			side = Allegiance.ALLIES;
			value = 5;
			break;
		case "JAPAN":
			name = Country.JAPAN;
			side = Allegiance.AXIS;
			value = -3;
			break;
		case "GERMANY":
			name = Country.GERMANY;
			side = Allegiance.AXIS;
			value = -3;
			break;
		case "ITALY":
			name = Country.ITALY;
			side = Allegiance.AXIS;
			value = -3;
			break;
		case "FRANCE":
			name = Country.FRANCE;
			side = Allegiance.ALLIES;
			value = 5;
			break;
		}
	}

	public String toString() {
		String Place = new String();
		String Val = Integer.toString(value);
		String Group = new String();

		switch (name) {
		case USA:
			Place = "USA";
			Group = "Allies";
			break;
		case UK:
			Place = "UK";
			Group = "Allies";
			break;
		case SOVIET_UNION:
			Place = "SOVIET_UNION";
			Group = "Allies";
			break;
		case CHINA:
			Place = "CHINA";
			Group = "Allies";
			break;
		case FRANCE:
			Place = "FRANCE";
			Group = "Allies";
			break;
		case ITALY:
			Place = "ITALY";
			Group = "Axis";
			break;
		case GERMANY:
			Place = "GERMANY";
			Group = "Axis";
			break;
		case JAPAN:
			Place = "JAPAN";
			Group = "Axis";
			break;
		}

		return ("Country: " + Place + "; Value: " + Val + "; Allegiance: " + Group + ";");
	}
}