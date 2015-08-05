package study.dijkstra;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class DijkstraTest {
	@Test
	public void testFindShortestPath1() throws Exception {
		Graph graph = new Graph();
		graph.addEdge("a", "b", 1);
		graph.addEdge("b", "c", 2);
		graph.addEdge("c", "a", 4);
		test(graph, "a", "c", 3, "b", "c");
	}

	@Test
	public void testFindShortestPath2() throws Exception {
		Graph graph = new Graph();
		graph.addEdge("a", "b", 2);
		graph.addEdge("b", "c", 2);
		graph.addEdge("c", "a", 3);
		test(graph, "a", "c", 3, "c");
	}

	@Test
	public void testFindShortestPath3() throws Exception {
		Graph graph = new Graph();
		graph.addEdge("1", "2", 7);
		graph.addEdge("1", "3", 9);
		graph.addEdge("1", "6", 14);
		graph.addEdge("2", "3", 10);
		graph.addEdge("2", "4", 15);
		graph.addEdge("3", "4", 11);
		graph.addEdge("3", "6", 2);
		graph.addEdge("4", "5", 6);
		graph.addEdge("5", "6", 9);
		test(graph, "1", "6", 11, "3", "6");
		test(graph, "1", "4", 20, "3", "4");
		test(graph, "1", "5", 20, "3", "6", "5");
	}

	private void test(Graph graph, String source, String target, int distance, String... path) {
		Dijkstra.Result result = new Dijkstra().findShortestPath(graph, source);
		assertEquals(distance, (int) result.getDistances().get(target));
		assertEquals(Arrays.asList(path), result.getPath(target));
	}
}