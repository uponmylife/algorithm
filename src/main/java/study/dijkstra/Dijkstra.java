package study.dijkstra;

import lombok.Getter;

import java.util.*;

public class Dijkstra {
	public Result findShortestPath(Graph graph, String source) {
		Map<String, Integer> distances = new HashMap<>();
		Map<String, String> prevNodes = new HashMap<>();
		Comparator<String> distanceComparator = (n1, n2) -> Integer.compare(distances.get(n1), distances.get(n2));

		Set<String> nodes = graph.getAllNodes();
		nodes.forEach(n -> distances.put(n, Integer.MAX_VALUE));
		distances.put(source, 0);

		while (!(nodes.size() == 0)) {
			String minNode = nodes.stream().min(distanceComparator).get();
			nodes.remove(minNode);

			graph.getNeighborNodes(minNode).forEach(nn -> {
				int distance = distances.get(minNode) + graph.getEdge(minNode, nn).getWeight();
				if (distance < distances.get(nn)) {
					distances.put(nn, distance);
					prevNodes.put(nn, minNode);
				}
			});
		}

		return new Result(distances, prevNodes);
	}

	@Getter
	public static class Result {
		private Map<String, Integer> distances;
		private Map<String, String> prevNodes;

		public Result(Map<String, Integer> distances, Map<String, String> prevNodes) {
			this.distances = distances;
			this.prevNodes = prevNodes;
		}

		public List<String> getPath(String target) {
			List<String> path = new ArrayList<>();
			String node = target;
			while (prevNodes.containsKey(node)) {
				path.add(0, node);
				node = prevNodes.get(node);
			}
			return path;
		}
	}
}
