package com.audible.challenge.third;

import java.util.Scanner;

public class DistanceCalculator {
	private static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Distance dist1 = new DistanceImplementation();
		Distance dist2 = new DistanceImplementation();

		int feet1 = scan.nextInt();
		float inches1 = scan.nextFloat();

		int feet2 = scan.nextInt();
		float inches2 = scan.nextFloat();

		dist1.setFeetAndInches(feet1, inches1);
		dist2.setFeetAndInches(feet2, inches2);

		System.out.println(dist1.getDistanceComparison(dist2));
	}

}
