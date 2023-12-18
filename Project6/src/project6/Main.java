package project6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		BinarySearchTree bst = new BinarySearchTree();
		// load words from file into the Binary Search Tree
		File file = new File("/Users/batyrrasulov/eclipse-workspace-CST-201/Project6/Text");
		Scanner scanner = new Scanner(file);
		// insert each word in the BST
		while (scanner.hasNext()) {
			bst.insert(scanner.next());
			}
		scanner.close();
		// display the words in the BST 
		System.out.println("Contents of the tree (in-order traversal):");
		bst.inorder();
		Scanner userInput = new Scanner(System.in);
		// allow user to search words for in the BST
		System.out.println("\nEnter string to search, enter -1 to quit.");
		while (true) {
			System.out.print("Enter string: ");
			String word = userInput.next();
			if (word.equalsIgnoreCase("-1")) break;
			SearchResult result = bst.search(word);
			System.out.println("Inspected " + result.inspected + " elements");
			System.out.println("'" + word + "' " + (result.found ? "located" : "not in tree"));
			}
		// allow user to remove words from the BST
		System.out.println("\nEnter string to remove, enter -1 to quit.");
		while (true) {
			System.out.print("Enter word: ");
			String word = userInput.next();
			if (word.equalsIgnoreCase("-1")) break;
			bst.delete(word);
			// after each removal -> print the contents of the BST
			System.out.println("\nContents of the tree after deletion:");
			bst.inorder();
			}
		userInput.close();
		}
	}
