package com.amazon.code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


public class GraphQuestion {

	public static void main(String[] args) throws IOException {


		/*graph.addNode(1, 2, 2);
		graph.addNode(2, 3, 1);
		graph.addNode(2, 4, 4);
		graph.addNode(4, 5, 3);
		System.out.println(graph);

		System.out.println(graph.findLargestRoute(1, 5));*/
		List<Graph> gList = new ArrayList<>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line1 = br.readLine();
		
		int t = Integer.parseInt(line1);
		
		for(int tt = 1; tt<=t; tt++){
			String line2 = br.readLine();
			int v = Integer.parseInt(line2);
			Graph graph = new Graph();
			for(int i = 0; i<v-1; i++){
				createNode(graph, br.readLine());
			}
			gList.add(graph);
			
		}
		
		
		br.close();
		
		
		for (Graph graph2 : gList) {
			System.out.println(graph2.findLargestRoute());
			
		}
		

	}
	
	private static void createNode(Graph g, String ss ){
		String[] k = ss.split(" ");
		long s = Long.parseLong(k[0]);
		long d = Long.parseLong(k[1]);;
		long w = Long.parseLong(k[2]);;
		g.addNode(s, d, w);
		
	}

}

class Graph {
	private Set<Node> vertices;
	private Map<Long, LinkedList<Node>> adjMap;
	private Set<Long> visited;
	private TreeSet<Long> largest;
	private List<Long> finalSums;

	Graph() {
		this.vertices = new HashSet<>();
		this.adjMap = new HashMap<>();
		this.visited = new HashSet<>();
		this.largest = new TreeSet<>();
		this.finalSums = new ArrayList<>();
	}

	public void addNode(long source, long destination, long weight) {
		Node s = new Node(source, weight);
		Node d = new Node(destination, weight);
		vertices.add(s);
		vertices.add(d);

		// mapping source -> destination
		if (!adjMap.containsKey(source)) {
			LinkedList<Node> l1 = new LinkedList<>();
			l1.addFirst(d);
			adjMap.put(source, l1);
		} else {
			LinkedList<Node> l1 = adjMap.get(source);
			if (!l1.contains(d)) {
				l1.add(d);
			}
		}

		// mapping destination -- source
		if (!adjMap.containsKey(destination)) {
			LinkedList<Node> l1 = new LinkedList<>();
			l1.addFirst(s);
			adjMap.put(destination, l1);
		} else {
			LinkedList<Node> l1 = adjMap.get(source);
			if (!l1.contains(s)) {
				l1.add(s);
			}
		}

	}

	public long findLargestRoute() {

		for (long i = 1; i <= vertices.size(); i++) {
			for (long j = i + 1; j <= vertices.size(); j++) {
				findLargest(i, j);
				finalSums.add(this.largest.last());
				this.largest = new TreeSet<>();
				this.visited = new HashSet<>();

			}
		}

		long sum = 0;
		for (Long sums : finalSums) {
			sum = sum + sums;
		}
		return sum;
	}

	private void findLargest(long source, long destination) {

		/*
		 * if (source.data == destination.data) { this.largest.add(sum); }
		 */
		if (visited.contains(source)) {
			return;
		} else {
			visited.add(source);
		}

		LinkedList<Node> nodes = adjMap.get(source);

		if (isConnected(source, destination)) {
			for (Node node : nodes) {
				if (node.data == destination) {
					this.largest.add(node.weight);
					return;
				}
			}
		} else {
			for (Node node : nodes) {
				this.largest.add(node.weight);
				findLargest(node.data, destination);
			}

		}

	}

	private boolean isConnected(long s, long d) {

		boolean ret = false;
		LinkedList<Node> nodes = adjMap.get(s);
		for (Node node : nodes) {
			if (node.data == d)
				ret = true;
		}
		return ret;
	}

}

class Node {
	Long data;
	Long weight;

	Node(Long data, Long weight) {
		this.data = data;
		this.weight = weight;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 * 
	 * /* (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return " [--->" + data + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		return true;
	}

}
