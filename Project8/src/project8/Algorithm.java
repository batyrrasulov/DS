package project8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Algorithm {
    // number of vertices in the graph
	private final int vertices;
    // adjacency list to represent the graph
	private final List<List<Edge>> adjacencyList;
    // representation of an edge in the graph
    static class Edge {
    	int destination;
    	int weight;
        String name;
        // constructor to initialize an edge with a name, destination vertex, and weight
        protected Edge(String name, int destination, int weight) {
        	this.destination = destination;
        	this.weight = weight;
            this.name = name;
        }
        // string representation of the edge
        public String toString() {
        	return name + ": To: " + destination + " : Weight: " + weight;
        	}
        }
    // constructor to initialize the algorithm with a given number of vertices
    protected Algorithm(int vertices) {
    	this.vertices = vertices;
        adjacencyList = new ArrayList<>(vertices);
        // initialize the adjacency list with empty lists for each vertex
        for (int cnt = 0; cnt < vertices; cnt ++) {
        	List<Edge> edges = new ArrayList<>();
        	adjacencyList.add(edges);
        	}
        }
    // add an edge to the graph
    public void addEdge(String name, int source, int destination, int weight) {
    	adjacencyList.get(source).add(new Edge(name, destination, weight));
    	}
    // find the shortest path from the source to all other vertices
    public int[] shortestPath(int source) {
    	int[] dist = new int[vertices];
    	Arrays.fill(dist, Integer.MAX_VALUE);
    	dist[source] = 0;
    	PriorityQueue<Edge> priorityQueue = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        priorityQueue.offer(new Edge("",source,0));
        // Dijkstra's algorithm
        while(!priorityQueue.isEmpty()) {
        	Edge current = priorityQueue.poll();
            for(Edge neighbor : adjacencyList.get(current.destination)) {
            	int newDist = dist[current.destination] + neighbor.weight;
            	if(newDist < dist[neighbor.destination]) {
            		dist[neighbor.destination] = newDist;
            		priorityQueue.offer(new Edge("",neighbor.destination, newDist));
            		}
            	}
            }
        return dist;
        }
    // get the adjacency list of the graph
    public List<List<Edge>> getAdList() {
    	return adjacencyList;
    	}
    // get the neighbors of a specific vertex
    public String getNeighbors(int source) {
    	String string = "";
    	for(int x = 0; x < adjacencyList.get(source).size(); x ++) {
    		string = string + "\n" + adjacencyList.get(source).get(x).toString()+ ",";
    		}
    	return string;
    	}
    // string representation of the graph
    public String toString() {
    	String string = "";
    	for (int cnt = 0; cnt < adjacencyList.size(); cnt ++) {
    		string = string + "\n\nSource: " + cnt + " Edges: [";
            for(int x = 0; x < adjacencyList.get(cnt).size(); x ++) {
            	string = string + "\n" + adjacencyList.get(cnt).get(x).toString()+ ",";
            	}
            string = string + "]\n";
            }
    	return string;
    	}
    }
