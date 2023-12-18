package project8;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import java.util.List;
import org.junit.Test;

public class Tests {
	@Test
	public void testShortestPath() {
        // create an instance of 5 vertices
		Algorithm graph = new Algorithm(5);
        // add edges to create a graph with specific weights
		graph.addEdge("A", 0, 1, 1);
        graph.addEdge("B", 0, 2, 4);
        graph.addEdge("C", 1, 3, 2);
        graph.addEdge("D", 2, 3, 5);
        graph.addEdge("E", 3, 4, 1);
        // calculate the shortest paths from the source vertex of 0
        int[] shortestPaths = graph.shortestPath(0);
        // define the expected shortest paths
        int[] expectedPaths = {0, 1, 4, 3, 4};
        // assert that the calculated shortest paths match the expected paths
        assertArrayEquals(expectedPaths, shortestPaths);
        }
	@Test
	public void testGetAdList() {
        // create an instance of 3 vertices
		Algorithm graph = new Algorithm(3);
		graph.addEdge("A", 0, 1, 2);
        graph.addEdge("B", 1, 2, 3);
        // retrieve the adjacency list from the graph
        List<List<Algorithm.Edge>> adjacencyList = graph.getAdList();
        // assert the size and structure of the adjacency list
        assertEquals(3, adjacencyList.size());
        assertEquals(1, adjacencyList.get(0).size());
        assertEquals(1, adjacencyList.get(1).size());
        assertEquals(0, adjacencyList.get(2).size());
        }
	}
