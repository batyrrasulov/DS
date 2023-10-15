package project;

public class UserDisplay {
	// display the elements of a string array along with a provided message
    public void displayArray(String message, String[] arr, int n) {
        System.out.println(message);
	    // loop through the array and print each element followed by a space
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i] + " ");
        }
    }
    public void displayMessage(String message) {
        System.out.println(message);
    }
}
