package study.dijkstra;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
public class Edge {
	private Set<String> nodes = new HashSet<>();
	private int weight;

	public Edge(String node1, String node2, int weight) {
		nodes.add(node1);
		nodes.add(node2);
		this.weight = weight;
	}

	public boolean contains(String node) {
		return nodes.contains(node);
	}

	public String getPeerNode(String node) {
		if (!contains(node)) return null;
		for (String n : nodes) if (!n.equals(node)) return n;
		throw new RuntimeException("peer node for " + node + " not found. ");
	}

	public boolean equals(String node1, String node2) {
		Set<String> s = new HashSet<>();
		s.add(node1);
		s.add(node2);
		return nodes.equals(s);
	}
}
