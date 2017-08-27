package com.audible.challenge.second;

import java.util.Scanner;

public class Sol2Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}
		int k = in.nextInt();

		if (in != null) {
			in.close();
		}
		
		System.out.println(Solution2.numberOfPairs(a, k));
	}

}
