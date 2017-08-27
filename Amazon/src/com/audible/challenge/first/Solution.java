package com.audible.challenge.first;

import java.util.Stack;

public class Solution {

	static String[] braces(String[] values) {
		String[] output = new String[values.length];
		if (values != null && values.length > 0) {
			for (int i = 0; i < values.length; i++) {
				output[i] = isComplete(values[i]);
			}
		} else {
			return output;
		}

		return output;
	}

	private static String isComplete(String data) {
		String ret = null;
		if(data == null){
			return "NO";
		}
		Stack<Character> st = new Stack<Character>();
		char[] chr = data.toCharArray();

		for (int i = 0; i < chr.length; i++) {
			if (st.isEmpty() || st.size() == 0) {
				st.push(chr[i]);
			} else {
				char temp = st.peek();
				if (temp == getOpposite(chr[i])) {
					st.pop();
				} else {
					st.push(chr[i]);
				}
			}
		}

		if (st.size() == 0) {
			ret = "YES";
		} else {
			ret = "NO";
		}

		return ret;
	}

	private static char getOpposite(char c) {

		switch (c) {
		case '{':
			return '}';
		case '}':
			return '{';
		case '[':
			return ']';
		case ']':
			return '[';
		case '(':
			return ')';
		case ')':
			return '(';

		default:
			break;
		}
		return 0;
	}
}
