package com.amazon.code;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MillyAndCholcolate {
    

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputs = br.readLine();
		int noBoxes = Integer.parseInt(inputs);
		String contents = br.readLine();
		String input3 = br.readLine();
		Long questions = Long.parseLong(input3);
		List<String> questionList = new ArrayList<>();

		for (long i = 0; i < questions; i++) {
			String inp = br.readLine();
			questionList.add(inp);
		}
		String[] contentArray = contents.split(" ");
		List<Integer> finalResList = getBoxContents(contentArray);
		for (String question : questionList) {
			int ques = Integer.parseInt(question);
			System.out.println(getBox(ques, finalResList));

		}

	}

	private static int getBox(int ques, List<Integer> finalResList) {
		int ret = 0;
		for (int i = 0; i < finalResList.size(); i++) {
			if (ques <= finalResList.get(i)) {
				return i + 1;
			}
		}

		return ret;
	}

	private static List<Integer> getBoxContents(String[] contentArray) {
		Long sum = getSum(contentArray);
		List<Integer> finalResList = new ArrayList<>();
		int boxCount = 0;
		for (int i = 0; i < sum;) {
			String box = contentArray[boxCount];
			boxCount++;
			int maxContent = Integer.parseInt(box);
			finalResList.add(i + maxContent);
			i = (int) (i + maxContent);

		}
		return finalResList;
	}

	private static Long getSum(String[] contentArray) {
		Long sum = 0L;
		for (String ct : contentArray) {
			sum = sum + Long.parseLong(ct);
		}
		return sum;
	}
}
