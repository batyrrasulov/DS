package project8;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        int source = 0;
        int destination = 0;
        try (Scanner scan = new Scanner(System.in)) {
        	// display the graph
            System.out.println("Entire Graph: \n" + graph);
            // get user input for exploring the neighbors of a node
            System.out.println("Enter the node to see its neighbors (type -1 to stop):\nSource: ");
            source = scan.nextInt();
            while (source != -1) {
                // display the neighbors of the entered node
                System.out.println("Neighbors:" + graph.getNeighbors(source) + "\nSource: ");
                source = scan.nextInt();
            }
            // get user input for calculating the distance between two nodes
            System.out.print("Enter source and destination to get the distance (type -1 to stop)\nSource: ");
            source = scan.nextInt();
            System.out.print("Destination: ");
            destination = scan.nextInt();
            while (source != -1 && destination != -1) {
                // display the distance between the entered source and destination nodes
                System.out.println("Distance: " + graph.getDistance(source, destination));
                System.out.print("Source: ");
                source = scan.nextInt();
                System.out.print("Destination: ");
                destination = scan.nextInt();
            }
        }
        System.out.println("Ciao!");
    }
}
