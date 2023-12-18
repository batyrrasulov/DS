package project5;

public class Main {
    public static void main(String[] args) {
    	// create an instance of the class initializing it with data from the input file
        RecursiveStrings rs = new RecursiveStrings("input.txt");
        // retrieve the array of input string from the instance
        String[] strings = rs.getFileContent();
        
        System.out.println("SLOPS OUTPUT");
        // iterate through the array of input strings
        for (int i = 0; i < strings.length; i++) {
        	// check if the current input string is a valid slop using the method
            if (rs.isSlop(strings[i])) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        System.out.println("END OF OUTPUT");
    }
}
