package project8;

public class Graph {
    // number of vertices in the graph is 15
    public int vertices = 15;
    // algorithm object for processing the graph operations
    Algorithm alg = new Algorithm(vertices);
    // constructor to initialize the graph with predefined edges
    public Graph() {
        // adding edges to the graph with corresponding names, sources, destinations, and weights
    	alg.addEdge("Mohave",0,12,9);
        alg.addEdge("Mohave",0,11,14);
        alg.addEdge("Mohave",0,1,14);
        alg.addEdge("Coconino",1,0,14);
        alg.addEdge("Coconino",1,11,9);
        alg.addEdge("Coconino",1,10,17);
        alg.addEdge("Coconino",1,2,9);
        alg.addEdge("Navajo",2,1,9);
        alg.addEdge("Navajo",2,10,13);
        alg.addEdge("Navajo",2,9,20);
        alg.addEdge("Navajo",2,3,5);
        alg.addEdge("Apache",3,2,5);
        alg.addEdge("Apache",3,9,19);
        alg.addEdge("Apache",3,4,17);
        alg.addEdge("Greenlee",4,3,17);
        alg.addEdge("Greenlee",4,9,4);
        alg.addEdge("Greenlee",4,5,16);
        alg.addEdge("Cochise",5,4,16);
        alg.addEdge("Cochise",5,9,12);
        alg.addEdge("Cochise",5,7,9);
        alg.addEdge("Cochise",5,6,8);
        alg.addEdge("Santa Cruz",6,5,8);
        alg.addEdge("Santa Cruz",6,7,6);
        alg.addEdge("Pima",7,6,6);
        alg.addEdge("Pima",7,5,9);
        alg.addEdge("Pima",7,9,12);
        alg.addEdge("Pima",7,8,7);
        alg.addEdge("Pima",7,14,10);
        alg.addEdge("Pima",7,13,23);
        alg.addEdge("Pinal",8,7,7);
        alg.addEdge("Pinal",8,9,13);
        alg.addEdge("Pinal",8,10,5);
        alg.addEdge("Pinal",8,14,6);
        alg.addEdge("Graham",9,8,13);
        alg.addEdge("Graham",9,7,12);
        alg.addEdge("Graham",9,5,12);
        alg.addEdge("Graham",9,4,4);
        alg.addEdge("Graham",9,3,19);
        alg.addEdge("Graham",9,2,20);
        alg.addEdge("Graham",9,10,7);
        alg.addEdge("Gila",10,9,7);
        alg.addEdge("Gila",10,2,13);
        alg.addEdge("Gila",10,1,17);
        alg.addEdge("Gila",10,11,18);
        alg.addEdge("Gila",10,14,8);
        alg.addEdge("Gila",10,8,5);
        alg.addEdge("Yavapai",11,10,18);
        alg.addEdge("Yavapai",11,1,9);
        alg.addEdge("Yavapai",11,0,14);
        alg.addEdge("Yavapai",11,12,15);
        alg.addEdge("Yavapai",11,14,9);
        alg.addEdge("La Paz",12,11,15);
        alg.addEdge("La Paz",12,0,9);
        alg.addEdge("La Paz",12,13,11);
        alg.addEdge("La Paz",12,14,15);
        alg.addEdge("Yuma",13,12,11);
        alg.addEdge("Yuma",13,7,23);
        alg.addEdge("Yuma",13,14,18);
        alg.addEdge("Maricopa",14,13,18);
        alg.addEdge("Maricopa",14,7,10);
        alg.addEdge("Maricopa",14,8,6);
        alg.addEdge("Maricopa",14,10,8);
        alg.addEdge("Maricopa",14,11,9);
        alg.addEdge("Maricopa",14,12,15);
    }
    // get the number of vertices in the graph
    public int getVertices() {
        return vertices;
        }
    public String toString() {
    	return alg.toString();
    	}
    // get the distance between two vertices
    public int getDistance(int source, int destination) {
    	return alg.shortestPath(source)[destination];
    	}
    public String getNeighbors(int source) {
    	return alg.getNeighbors(source);
    	}
    }
