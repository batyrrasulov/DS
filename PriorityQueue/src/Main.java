
public class Main {
    public static void main(String[] args) {
        // Create a PriorityQueue of integers
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        // Insert elements with associated priorities
        priorityQueue.insert(5, 5);
        priorityQueue.insert(2, 2);
        priorityQueue.insert(8, 8);
        priorityQueue.insert(1, 1);
        priorityQueue.insert(10, 10);

        // Extract and print elements in ascending order of priority
        while (!priorityQueue.isEmpty()) {
            int min = priorityQueue.extractMin();
            System.out.println("Extracted: " + min);
        }
    }
}
