package project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ArrayManager {
	// declare the array with a capacity for 10,000 strings
    private static final int ARRAY_CAPACITY = 10000;
    // create an array to store words to be sorted
    private String[] wordArray = new String[ARRAY_CAPACITY];
	// initialise the current size of the array
    private int size = 0;
	// read words from a file and store them in an array, up to a certain capacity
    public void readWordsFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("/Applications/Eclipse.app/Contents/MacOS/workspaceCST-201/Project0/src/project0/text.txt"))) {
            String line;
	        // read each line from the file until there are no more lines
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");	          
	            // split the line into words using whitespace as a delimiter
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
    public void insertionSort() {
	    // start iterating from the second element to the end of the array
        for (int i = 1; i < size; i++) {
	        // store the current element in a temporary variable
            String temp = wordArray[i];
	        // initialize 'j' to the previous index of 'i'
            int j = i - 1;
			// while 'j' is greater than or equal to 0, and the element at 'j' is greater than 'temp', shift elements to the right to make space for 'temp'
            while (j >= 0 && wordArray[j].compareTo(temp) > 0) {
                wordArray[j + 1] = wordArray[j];
				// move 'j' one position to the left
                j = j - 1;
            }
	        // insert the temporary string 'temp' into the correct position in the sorted portion of the array
            wordArray[j + 1] = temp;
        }
    }
	// implement binary search to find a target string in a sorted array of strings
    public int binarySearch(String target) {
		// initialise the left and right boundaries
        int left = 0;
        int right = size - 1;
	    // continue the search as long as the left boundary is less than or equal to the right boundary
        while (left <= right) {
	        // calculate the middle index of the current search range
            int mid = left + (right - left) / 2;
	        // compare the target string with the middle element of the array
            int compareResult = target.compareTo(wordArray[mid]);
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
    // getters
    public String[] getWordArray() {
        return wordArray;
    }
    public int getSize() {
        return size;
    }
}
