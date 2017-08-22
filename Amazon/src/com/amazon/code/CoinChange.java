package com.amazon.code;

import java.util.Scanner;

public class CoinChange {

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		String output;
		int ip1 = Integer.parseInt(in.nextLine().trim());
		int ip2_size = 0;
		ip2_size = Integer.parseInt(in.nextLine().trim());
		int[] ip2 = new int[ip2_size];
		int ip2_item;
		for (int ip2_i = 0; ip2_i < ip2_size; ip2_i++) {
			ip2_item = Integer.parseInt(in.nextLine().trim());
			ip2[ip2_i] = ip2_item;
		}
		output = CoinChange(ip1, ip2);
		System.out.println(String.valueOf(output));
	}

	private static String CoinChange(int ip1, int[] ip2) {
		int count = 0;
		for (int i = 0; i < ip2.length; i++) {
			count = count + findCount(ip2, i, ip2.length, ip1);
		}
		return null;
	}

	private static int findCount(int[] arr, int st, int ed, int tg) {
		int count = 0;
		int stVal = arr[st];
		int total = 0;
		if (tg < arr[st]) {
			return 0;
		}
		if (st % arr[st] == 0) {
			count = count + 1;
		}
		if (arr[st] == 1) {
			count = count + 1;
		}
		if (st == arr.length) {
			return count;
		}
		for (int i = st + 1; i < ed; i++) {
			if (arr[i] > tg) {
				continue;
			}
			
			int temp = stVal + arr[i];
			
			if()
		}

		return 0;
	}

}
