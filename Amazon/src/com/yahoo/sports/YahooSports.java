package com.yahoo.sports;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class YahooSports {

	public static void main(String[] args) throws IOException {
		List<String> list = new ArrayList<String>();
		Scanner reader = new Scanner(System.in);
		String text = null;
			text = reader.nextLine();
		list.add(text);

		System.out.println(list.size());
		
		
		
		Pattern p = Pattern.compile("\\[(.*?)\\]");
		Matcher m = p.matcher(text);
		while (m.find()) {
			System.out.print(m.group(1));
			if (!m.hitEnd()) {
				System.out.print(",");
			}
		}
	}

}
