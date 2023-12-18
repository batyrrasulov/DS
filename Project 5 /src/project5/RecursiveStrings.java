package project5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RecursiveStrings {
	// variable to store the number of strings to be processed
    private int numStrings;
    // an array for storing the input strings
    private String[] strings;
    // constructor for reading an input from a file
    public RecursiveStrings(String filePath) {
        try {
            // initialize a file reader & buffered reader to read the file
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            // extract and parse the number of strings from the first line
            numStrings = Integer.parseInt(bufferedReader.readLine());
            strings = new String[numStrings];
            // iterate to get each string from the subsequent lines
            for (int i = 0; i < numStrings; i++) {
                strings[i] = bufferedReader.readLine();
            }
            // close the buffered reader and file reader
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
        	// handle exceptional situations such as file not found
            e.printStackTrace();
        }
    }
    // getter method to retrieve the array of input strings
    String[] getFileContent() {
        return strings;
    }
    // method to determine if a given string is a valid slip
    public boolean isSlip(String str, boolean slipStarted, boolean canStartSlip) {
        // the base case for identifying a slip is when it encounters 'G'
        if (!str.isEmpty()) {
            if (str.charAt(0) == 'G' && canStartSlip && slipStarted) {
            	// a valid slip has been found
                return true;
            }
        }
        // when 'E' or 'D' is found => substring the current string & recursively call isSlip
        if (!str.isEmpty()) {
            if ((str.charAt(0) == 'E' || str.charAt(0) == 'D') && canStartSlip) {
                return isSlip(str.substring(1), true, false);
            }
        }
        // if 'F' is observed & slip has already started => continue checking the remaining string
        if (!str.isEmpty()) {
            if (str.charAt(0) == 'F' && slipStarted) {
                return isSlip(str.substring(1), true, true);
            }
        }
        // no valid slips have been found
        return false;
    }
    // method to determine if a given string is a valid slap
    public boolean isSlap(String str, boolean justStartedSlap, boolean afterSlipOrSlap, int slapCount) {
        // the base case for a slap is when the string is empty & slap count is zero or negative
        if ((str.equals("\n") || str.equals("")) && (slapCount == 0 || slapCount < 0)) {
        	// a valid slap has been found
            return true;
        }
        // a slap can only be initiated with 'A' & should not follow immediately after one
        if (!str.isEmpty()) {
            if (str.charAt(0) == 'A' && !justStartedSlap) {
            	// continue checking the rest of the string
                return isSlap(str.substring(1), true, false, slapCount);
            }
        }
        // an 'H' can only occur if a slap has already started
        if (!str.isEmpty()) {
            if (str.charAt(0) == 'H' && justStartedSlap) {
            	// continue checking the rest of the string
                return isSlap(str.substring(1), false, true, slapCount);
            }
        }
        // if a slap has already started it can also have a 'B' & recursively call isSlap
        if (!str.isEmpty()) {
            if (str.charAt(0) == 'B' && justStartedSlap) {
                if (isSlap(str.substring(1), false, false, -100)) {
                    return isSlap(str.substring(1), false, true, slapCount+1);
                } else {
                    return false;
                }
            }
        }
        // if a slap has already started it can have a slip
        if (!str.isEmpty()) {
            if ((str.charAt(0) == 'E' || str.charAt(0) == 'D') && justStartedSlap) {
                if (isSlip(str.substring(0), false, true)) {
                	// continue checking the rest of the string
                    return isSlap(str.substring(str.indexOf('G')+1), false, true, slapCount+1);
                } else {
                	// no valid slaps have been found due that one specific condition not being met
                    return false;
                }
            }
        }
        // a 'C' can only occur if it is after a slap or a slip
        if (!str.isEmpty()) {
            if (str.charAt(0) == 'C' && afterSlipOrSlap) {
                return isSlap(str.substring(1), false, true, slapCount-1);
            }
        }
        // no valid slaps have been found
        return false;
    }
    // method to determine if a given string is a valid slop
    public boolean isSlop(String str) {
    	// check if the string contains 'C'
        if (str.contains("C")) {
        	// check for a valid slap followed by a slip
            if (this.isSlap(str.substring(0, str.lastIndexOf('C')+1), false, false, 0)) {
                if (this.isSlip(str.substring(str.lastIndexOf('C')+1), false, true)) {
                	// valid slops have been found
                    return true;
                }
            }
        }
        // check if the string contains 'H'
        if (str.contains("H")) {
        	// check for a valid slap followed by a slip and (optionally) an 'end' sequence
            if (this.isSlap(str.substring(0, str.lastIndexOf('H')+1), false, false, 0)) {
                if (this.isSlip(str.substring(str.lastIndexOf('H')+1), false, true) && (str.substring(str.lastIndexOf('G')+1).isEmpty() || str.substring(str.lastIndexOf('G')+1).equals("\n"))) {
                	// valid slops have been found
                    return true;
                }
            }
        }
        // no valid slops have been found
        return false;
    }
}
