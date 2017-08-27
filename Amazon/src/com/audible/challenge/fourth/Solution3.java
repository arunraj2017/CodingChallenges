package com.audible.challenge.fourth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;

public class Solution3 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		String[] res;
		String _substr;
		try {
			_substr = in.nextLine();
		} catch (Exception e) {
			_substr = null;
		}

		res = getMovieTitles(_substr);
		for (int res_i = 0; res_i < res.length; res_i++) {
			System.out.println(String.valueOf(res[res_i]));
		}

		in.close();
	}

	static class Movie {
		String page;
		int per_page;
		int total;
		int total_pages;
		Data[] data;

		public String getPage() {
			return page;
		}

		public void setPage(String page) {
			this.page = page;
		}

		public int getPer_page() {
			return per_page;
		}

		public void setPer_page(int per_page) {
			this.per_page = per_page;
		}

		public int getTotal() {
			return total;
		}

		public void setTotal(int total) {
			this.total = total;
		}

		public int getTotal_pages() {
			return total_pages;
		}

		public void setTotal_pages(int total_pages) {
			this.total_pages = total_pages;
		}

		public Data[] getData() {
			return data;
		}

		public void setData(Data[] data) {
			this.data = data;
		}

	}

	static class Data {
		String Poster;
		String Title;
		String Type;
		String Year;
		String imdbID;

		public String getPoster() {
			return Poster;
		}

		public void setPoster(String poster) {
			Poster = poster;
		}

		public String getTitle() {
			return Title;
		}

		public void setTitle(String title) {
			Title = title;
		}

		public String getType() {
			return Type;
		}

		public void setType(String type) {
			Type = type;
		}

		public String getYear() {
			return Year;
		}

		public void setYear(String year) {
			Year = year;
		}

		public String getImdbID() {
			return imdbID;
		}

		public void setImdbID(String imdbID) {
			this.imdbID = imdbID;
		}

	}

	static String[] getMovieTitles(String substr) {
		List<String> mv = new ArrayList<>();
		Movie movie = getMovieData(substr, "1");
		mv = getMovies(movie.data, mv);

		for (int i = 2; i <= movie.total_pages; i++) {
			Movie moviee = getMovieData(substr, Integer.toString(i));
			mv = getMovies(moviee.data, mv);
		}

		return mv.toArray(new String[mv.size()]);
	}

	private static List<String> getMovies(Data[] data, List<String> mv) {
		for (int i = 0; i < data.length; i++) {
			mv.add(data[i].getTitle());
		}
		return mv;
	}

	private static Movie getMovieData(String name, String page) {
		Gson gson = new Gson();
		StringBuffer sb = new StringBuffer();
		try {
			URL url = new URL("https://jsonmock.hackerrank.com/api/movies/search/?Title=" + name + "&page=" + page);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Exception in calling service " + conn.getResponseCode());
			}
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output = null;
			while ((output = br.readLine()) != null) {
				sb.append(output);
			}

			conn.disconnect();

		} catch (Exception e) {
			e.printStackTrace();
		}

		Movie movie = gson.fromJson(sb.toString(), Movie.class);
		return movie;
	}
}
