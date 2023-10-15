package project0;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	// declare the array with a capacity for 10,000 strings
	private static final int ARRAY_CAPACITY = 10000;
    // create an array to store words to be sorted
	private static String[] wordArray = new String[ARRAY_CAPACITY];
	// initialise the current size of the array
	private static int size = 0;
	
	public static void main(String[] args) {
		// read words from an input text file 'text.txt' and populate the string array
		readWordsFromFile();
		// create a copy of the unsorted array
		String[] unsortedArray = Arrays.copyOf(wordArray, size);
        // use the insertion sort algorithm to sort the data
		insertionSort(wordArray, size);
		// display the array before sorting it
		displayArray("Unsorted Array: ", unsortedArray, size);
		// display the array after sorting it
		displayArray("Sorted Array: ", wordArray, size);
		
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Enter a word to search for, or 0 to exit:");
			String target = scanner.nextLine();
			// an entry of 0 indicates the user is finished searching for strings
			if (target.equals("0")) {
				// exit the loop if the user enters 0
				System.out.print("Ciao!");
				break;
			}
            // use a binary search algorithm to find the target string
			int result = binarySearch(wordArray, size, target);
			if (result != -1) {
                // if the target string is found, print its index
				System.out.println("Found at index: " + result);
			} else {
                // if the target string is not found, indicate that it's not in the array
				System.out.println("Word not found in the list");
			}
		}
		scanner.close();
	}
	// read words from a file and store them in an array, up to a certain capacity
	private static void readWordsFromFile() {
		try (BufferedReader br = new BufferedReader(new FileReader("/Applications/Eclipse.app/Contents/MacOS/workspaceCST-201/Project0/src/project0/text.txt"))) {
			String line;
	        // read each line from the file until there are no more lines
			while ((line = br.readLine()) != null) {
	            // split the line into words using whitespace as a delimiter
				String[] words = line.split("\\s+");
				for (String word : words) {
					if (size < ARRAY_CAPACITY) {
	                    // add words to the array if there is space
						wordArray[size++] = word;
					} else {
	                    // print a message if the array capacity is exceeded
						System.out.println("Array capacity exceeded. Ignoring additional words");
					}
				}
			}
		} catch (IOException e) {
	        // handle an IOException if the file is not readable
			System.err.println("Error reading the file: " + e.getMessage());
		}
	}
	// implement the insertion sort algorithm to sort an array of strings that takes an array 'arr' and its size 'n' as parameters
	private static void insertionSort(String[] arr, int n) {
	    // start iterating from the second element to the end of the array
		for (int i = 1; i < n; i++) {
	        // store the current element in a temporary variable
			String temp = arr[i];
	        // initialize 'j' to the previous index of 'i'
			int j = i - 1;
			// while 'j' is greater than or equal to 0, and the element at 'j' is greater than 'temp', shift elements to the right to make space for 'temp'
			while (j >= 0 && arr[j].compareTo(temp) > 0) {
				arr[j + 1] = arr[j];
				// move 'j' one position to the left
				j = j - 1;
			}
	        // insert the temporary string 'temp' into the correct position in the sorted portion of the array
			arr[j + 1] = temp;
		}
	}
	// implement binary search to find a target string in a sorted array of strings
	private static int binarySearch(String[] arr, int n, String target) {
		// initialise the left and right boundaries
		int left = 0; 
		int right = n - 1;
	    // continue the search as long as the left boundary is less than or equal to the right boundary
		while (left <= right) {
	        // calculate the middle index of the current search range
			int mid = left + (right - left) / 2;
	        // compare the target string with the middle element of the array
			int compareResult = target.compareTo(arr[mid]);
			if (compareResult == 0) {
	            // if the target string is equal to the middle element, it has been found
				return mid;
			} else if (compareResult < 0) {
	            // if the target string is less than the middle element, adjust the right boundary
				right = mid - 1;
			} else {
	            // if the target string is greater than the middle element, adjust the left boundary
				left = mid + 1;
			}
		}
	    // if the loop completes without finding the target string, return -1 to indicate it was not found
		return -1;
	}
	// display the elements of a string array along with a provided message
	private static void displayArray(String message, String[] arr, int n) {
		System.out.println(message);
	    // loop through the array and print each element followed by a space
		for (int i = 0; i < n; i++) {
			System.out.println(arr[i] + " ");
		}
	}
}
