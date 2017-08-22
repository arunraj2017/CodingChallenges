package com.amazon.code;

public class FindAllPerms {

	public static void main(String[] args) {
		String k = "abc";

		permute(k, 0, k.length()-1);
	}

	private static void permute(String str, int l, int r) {

		if (l == r) {
			System.out.println(str);
		} else {

			for (int i = l; i <= r; i++) {
				str = swap(str, l, i);
				permute(str, l + 1, r);
				str = swap(str, l, i);
			}
		}

	}

	private static String swap(String str, int i, int l) {

		char[] arr = str.toCharArray();
		char temp = arr[i];
		arr[i] = arr[l];
		arr[l] = temp;
		return String.copyValueOf(arr);

	}

}

