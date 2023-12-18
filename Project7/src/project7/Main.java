package project7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	// initialize a hash table
        HashTable hashTable = new HashTable(100);
        // read the text file and insert words into the hash table
        try {
            Scanner scanner = new Scanner(new File("/Users/batyrrasulov/eclipse-workspace-CST-201/Project7/text"));
            while (scanner.hasNext()) {
                String word = scanner.next();
                // store the word as both key and value
                hashTable.insert(word, word);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found.");
            System.exit(1);
        }
        // display the contents of the hash table
        hashTable.display();
        // allow users to search for words
        try (
		Scanner inputScanner = new Scanner(System.in)) {
			System.out.println("Enter a word to search (or 'quit' to exit):");
			String searchWord = inputScanner.next();
			while (!searchWord.equals("quit")) {
		        // search for the entered word in the hash table
				String result = hashTable.search(searchWord);
		        // initialize a counter for the number of elements inspected
				int elementsInspected = 1;
		        // get the array from the hash table
				Node[] array = hashTable.getArray(); 
		        // calculate the index using the hash function
				int index = hashTable.hash(searchWord);
		        // get the first node in the linked list at the calculated index
				Node currentNode = array[index];
		        // traverse the linked list to find the searched word
				while (currentNode != null && !currentNode.key.equals(searchWord)) {
				    currentNode = currentNode.next;
				    elementsInspected++;
				}
			    if (result != null) {
			        System.out.println("Inspected " + elementsInspected + " elements");
			        System.out.println("'" + searchWord + "' located");
			    } else {
			        System.out.println("'" + searchWord + "' not found");
			    }
			    System.out.println("Enter a word to search (or 'quit' to exit):");
			    searchWord = inputScanner.next();
			}
		}
    }
}
