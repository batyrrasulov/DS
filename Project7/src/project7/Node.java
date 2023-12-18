package project7;

public class Node {
	// store the key of the hash table
    String key; 
    // store the value corresponding to the key
    String value;
    // next node reference for chaining in hash collisions
    Node next;
    // constructor to initialize a node with a key, value, and a null reference to the next node
    Node(String key, String value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}
