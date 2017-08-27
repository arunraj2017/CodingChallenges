package com.audible.challenge.second;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {

	/*
	 * Complete the function below.
	 */

	static int numberOfPairs(int[] a, long k) {
		int count = 0;
		if (a.length > 0) {
			for (int i = 0; i < a.length; i++) {
				int temp = a[i];
				for (int j = i + 1; j < a.length; j++) {
					System.out.println("ngth:" + i +" " + j);
					if (temp + a[j] == k) {
						
						count++;
					}
				}
			}

		}

		return count;
	}

}
