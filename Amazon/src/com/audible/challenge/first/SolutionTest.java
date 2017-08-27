package com.audible.challenge.first;

import java.util.Scanner;

public class SolutionTest {
	public static void main(String[] args) {

		Scanner reader = new Scanner(System.in);
		int n = reader.nextInt();
		String[] input = new String[n];

		for (int i = 0; i < n; i++) {
			input[i] = reader.next();
		}

		if (reader != null) {
			reader.close();
		}
		String []test = Solution.braces(input);
		for(int i = 0; i<test.length; i++){
			System.out.println(test[i]);
		}
	}
}
