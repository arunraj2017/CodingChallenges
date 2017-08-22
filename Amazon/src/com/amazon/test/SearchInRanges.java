package com.amazon.test;

import java.util.ArrayList;
import java.util.List;

public class SearchInRanges {

	private static List<String> permutations = new ArrayList<String>();

	public static void main(String[] args) {

		String haystack = "abdcghbaabhgij";
		String needle = "gh";

		System.out.println(getAnagramIndices(haystack, needle));
	}

	public static List<Integer> getAnagramIndices(String haystack, String needle) {

		findAllPermutations(needle);
		List<Integer> list = new ArrayList<Integer>();
		if (!permutations.isEmpty()) {

			for (int i = 0; i < permutations.size(); i++) {

				String temp = permutations.get(i);

				for (int index = 0; index < haystack.length(); index++) {
					if (haystack.substring(index).length() >= temp.length()) {
						String str = haystack.substring(index, index + temp.length());
						if (str.equals(temp)) {
							list.add(index);
						}
					}
				}
			}
		}
		return list;

	}

	private static void findAllPermutations(String needle) {

		permute(needle, 0, needle.length() - 1);

	}

	private static void permute(String str, int l, int r) {

		if (l == r) {
			permutations.add(str);
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
