package com.impress.simpress.code.first;

public class CandidateCode {

	public static int correctResult(int input1, int[] input2) {
		int s1 = getPermutations(input2);
		System.out.println(s1);
		int s2 = findMax(input2);
		System.out.println(s2);
		if(s1 == s2){
			System.out.println(s1);
		}else{
			System.out.println(-1);
		}
		return s1;
	}

	private static int findMax(int[] data) {
		int count = 0;
		for (int i = 1; i <= data.length; i++){
			count = count + isNegetive(Math.max(0, i - data[i-1]));
		}

			return count;
	}

	private static int isNegetive(int max) {
		int retval = 0;
		if(max > 0){
			retval = max;
		}
		return retval;
	}

	private static int getPermutations(int[] data) {
		int count = 0;

		for (int i = 0; i < data.length; i++) {
			for (int j = i + 1; j < data.length; j++) {
				System.out.println(data[i] + " > " + data[j]);
				if (data[i] > data[j]) {
					count++;
				}
			}
		}
		return count;

	}

}
