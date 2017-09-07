package com.audible.challenge.fifth;

import java.util.Scanner;
import java.util.Stack;

public class BinarySubstrings {

	public static void main(String[] args) {
		String input = null;
		Scanner reader = new Scanner(System.in);
		input = reader.next();
		if (reader != null) {
			reader.close();
		}
		System.out.println(solveData(input));
	}

	private static int solveData(String data) {
		if (data == null) {
			return 0;
		} else if (data.length() == 0) {
			return 0;
		}

		int ct = getCount(data);
		return ct + solveData(data.substring(1));

	}

	private static int getCount(String data) {

		Stack<Character> st = new Stack<>();
		boolean isNull = false;
		char[] cr = data.toCharArray();
		for (int i = 0; i < cr.length; i++) {
			if (st.size() == 0) {
				st.push(cr[i]);
			} else {
				if (st.peek().equals(cr[i])) {
					st.push(cr[i]);
				} else {
					st.pop();
				}
			}

			if (st.isEmpty()) {
				isNull = true;
				break;
			}

		}

		return isNull ? 1 : 0;
	}

}
