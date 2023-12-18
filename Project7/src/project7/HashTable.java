package project7;

public class HashTable {
	// create an array of nodes
    private Node[] array;
    // declare an integer variable to store the size of the array
    private int size;
    // define a getter method to retrieve the array
    public Node[] getArray() {
        return array;
    }
    // constructor to initialize the hash table
    public HashTable(int size) {
        this.size = size;
        array = new Node[size];
    }
    // hash function to generate an index for a word
    int hash(String word) {
        return Math.abs(word.hashCode() % size);
    }
    // insert operation to add a word to the table
    public void insert(String key, String value) {
        int index = hash(key);
        // insert the key value pair into the table based on the calculated index
        if (array[index] == null) {
            array[index] = new Node(key, value);
        } else {
            Node currentNode = array[index];
            while (currentNode.next != null && !currentNode.key.equals(key)) {
                currentNode = currentNode.next;
            }
            if (currentNode.key.equals(key)) {
                // update the existing key
                currentNode.value = value;
            } else {
                currentNode.next = new Node(key, value);
            }
        }
    }
    // search operation to find a word
    public String search(String key) {
        int index = hash(key);
        // search for the key and return its value
        Node currentNode = array[index];
        while (currentNode != null) {
            if (currentNode.key.equals(key)) {
                return currentNode.value;
            }
            currentNode = currentNode.next;
        }
        // if key not found
        return null; 
    }
    // method to display the hash table content
    public void display() {
        // iterate through each index of the array
        for (int i = 0; i < size; i++) {
            // get the node at the current index
            Node currentNode = array[i];
            // traverse the linked list within the current bucket
            System.out.print("Bucket " + i + ": ");
            while (currentNode != null) {
                System.out.print("[" + currentNode.key + ": " + currentNode.value + "] -> ");
                currentNode = currentNode.next;
            }
            System.out.println("null");
        }
    }
}
