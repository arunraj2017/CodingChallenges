package com.amazon.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class GCD_Function {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line1 = br.readLine();
		int N = Integer.parseInt(line1);
		int a[] = new int[N];

		String line2 = br.readLine();
		if (line2 != null) {
			String temparray[] = line2.split(" ");
			for (int i = 0; i < N; i++) {
				a[i] = Integer.parseInt(temparray[i]);
			}

		}

		String line3 = br.readLine();
		int c = Integer.parseInt(line3);
		String b[] = new String[c];
		for (int i = 0; i < c; i++) {
			b[i] = br.readLine();
		}

		if (br != null) {
			br.close();
		}

		List<BigInteger> result = performTask(a, b);
		if(!result.isEmpty()){
			for (BigInteger integer : result) {
				System.out.println(integer);
			}
		}

	}

	private static List performTask(int[] a, String[] b) {

		List<BigInteger> dList = new ArrayList<>();
		for (String str : b) {
			String strArr[] = str.split(" ");
			String function = strArr[0];
			int x = Integer.parseInt(strArr[1]);
			int y = Integer.parseInt(strArr[2]);

			if (function.equalsIgnoreCase("C")) {
				long sum = 0;
				
				for (int i = x - 1; i <= y - 1; i++) {
					if (i < a.length) {
						long temp = calculate(a[i]);
						sum = sum + findMod(temp).longValue();
					}
				}
				dList.add(findMod(sum));

			} else if (function.equalsIgnoreCase("U")) {
				if ((x - 1) < a.length) {
					a[x - 1] = y;
				}

			}
		}
		return dList;
	}

	private static int getGcd(int a, int b) {
		BigInteger b1 = BigInteger.valueOf(a);
		BigInteger b2 = BigInteger.valueOf(b);
		BigInteger result = b1.gcd(b2);
		return result.intValue();
	}

	private static int calculate(int x) {
		int sum = 0;
		for (int i = 1; i <= x; i++) {
			sum = sum + getGcd(i, x);
		}
		return sum;
	}

	private static BigInteger findMod(long a) {
		//return Math.floorMod(a, 100000007);
		return BigInteger.valueOf(a).mod(BigInteger.valueOf((long) (Math.pow(10, 9)+7)));
	}
}
