package project6;

public class BinarySearchTree {
	// root of the Binary Search Tree
	Node root;
	// insert a word into the BST
	public void insert(String word) {
		this.root = insertRec(this.root, word);
	}
	// recursive method to insert a word
	private Node insertRec(Node root, String word) {
		// if the current node is null -> place the word here
		if (root == null) {
			return new Node(word);
			}
		// go left or right depending on the comparison result
		if (word.compareTo(root.word) < 0)
			root.left = insertRec(root.left, word);
		else if (word.compareTo(root.word) > 0)
			root.right = insertRec(root.right, word);
		return root;
		}
	// search for a word in the BST
	public SearchResult search(String word) {
		Count count = new Count();
		Node result = searchRec(root, word, count);
		return new SearchResult(result != null, count.value);
		}
	// recursive method to search for a word and count the inspected nodes
	private Node searchRec(Node root, String word, Count count) {
		count.increment();
		if (root == null || root.word.equals(word))
			return root;
		if (word.compareTo(root.word) < 0)
			return searchRec(root.left, word, count);
		else
			return searchRec(root.right, word, count);
		}
	// delete a word from the BST
	public void delete(String word) {
		root = deleteRec(root, word);
		}
	// recursive method to delete a word
	private Node deleteRec(Node root, String word) {
		if (root == null) return root;
		// recurse down the tree based on comparison result
		if (word.compareTo(root.word) < 0)
			root.left = deleteRec(root.left, word);
		else if (word.compareTo(root.word) > 0)
			root.right = deleteRec(root.right, word);
		else {
			// node with only one child or no child
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;
			// if node with two children -> get the in-order successor "smallest in the right subtree"
			root.word = minValue(root.right);
			root.right = deleteRec(root.right, root.word);
			}
		return root;
		}
	// method to find the smallest value in the BST
	private String minValue(Node root) {
		String minValue = root.word;
		while (root.left != null) {
			minValue = root.left.word;
			root = root.left;
			}
		return minValue;
		}
	// print the BST using an in-order traversal
	public void inorder() {
		inorderRec(root);
		System.out.println();
		}
	// recursive method to print BST using an in-order traversal
	private void inorderRec(Node root) {
		if (root != null) {
			inorderRec(root.left);
			System.out.print(root.word + " ");
			inorderRec(root.right);
			}
		}
	}
