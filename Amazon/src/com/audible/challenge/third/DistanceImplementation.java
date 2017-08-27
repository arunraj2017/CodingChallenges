package com.audible.challenge.third;

public  class DistanceImplementation extends Distance {

	private static final String FST = "First distance is greater.";
	private static final String SEC = "Second distance is greater.";
	private static final String EQL = "Both distances are equal.";

	@Override
	public void setFeetAndInches(int feet, float inches) {
		this.feet = feet;
		this.inches = inches;
	}

	@Override
	public int getFeet() {
		return this.feet;
	}

	@Override
	public float getInches() {
		return this.inches;
	}

	@Override
	String getDistanceComparison(Distance dist2) {

		String retVal = null;
		float first = convertToInches(this.getFeet(), this.getInches());
		float second = convertToInches(dist2.getFeet(), dist2.getInches());

		if (first > second) {
			retVal = FST;
		} else if (second > first) {
			retVal = SEC;
		} else {
			retVal = EQL;
		}
		return retVal;
	}

	private float convertToInches(int feet, float inches) {
		return feet * 12 + inches;
	}

}
