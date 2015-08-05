package study.dijkstra;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Graph {
	private List<Edge> edges = new ArrayList<>();

	public Graph addEdge(String node1, String node2, int weight) {
		edges.add(new Edge(node1, node2, weight));
		return this;
	}

	public Set<String> getAllNodes() {
		return edges.stream().map(Edge::getNodes).flatMap(Set::stream).collect(Collectors.toSet());
	}

	public Set<String> getNeighborNodes(String node) {
		return edges.stream()
				.filter(edge -> edge.contains(node))
				.map(edge -> edge.getPeerNode(node))
				.collect(Collectors.toSet());
	}

	public Edge getEdge(String node1, String node2) {
		for (Edge edge : edges) if (edge.equals(node1, node2)) return edge;
		throw new RuntimeException("edge not found. " + node1 + "~" + node2);
	}
}
