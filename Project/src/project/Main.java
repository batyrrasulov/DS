package project;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayManager arrayManager = new ArrayManager();
        UserDisplay userDisplay = new UserDisplay();
        // read words from an input text file and populate the string array
        arrayManager.readWordsFromFile();
        // create a copy of the unsorted array
        String[] unsortedArray = Arrays.copyOf(arrayManager.getWordArray(), arrayManager.getSize());
        // use the insertion sort algorithm to sort the data
        arrayManager.insertionSort();
        // display the array before sorting it
        userDisplay.displayArray("Unsorted Array: ", unsortedArray, arrayManager.getSize());
        // display the array after sorting it
        userDisplay.displayArray("Sorted Array: ", arrayManager.getWordArray(), arrayManager.getSize());
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter a word to search for, or 0 to exit:");
            String target = scanner.nextLine();
            // an entry of 0 indicates the user is finished searching for strings
            if (target.equals("0")) {
                System.out.print("Ciao!");
                break;
            }
            // use a binary search algorithm to find the target string
            int result = arrayManager.binarySearch(target);
            if (result != -1) {
                // if the target string is found, print its index
                userDisplay.displayMessage("Found at index: " + result);
            } else {
                // if the target string is not found, indicate that it's not in the array
                userDisplay.displayMessage("Word not found in the list");
            }
        }
        scanner.close();
    }  
}
