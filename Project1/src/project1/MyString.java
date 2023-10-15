package project1;

public class MyString {
	// a char array referencee for the array of characters that make up the string
    private char[] chars;
    // an integer curr_length representing the number of characters in the string
    private int curr_length;
    // a constructor that initializes the array to null and the curr_length to 0
    public MyString() {
        chars = null;
        curr_length = 0;
    }
    // a constructor that takes a String parameter and initializes the char array to the characters in the String
    // use O(n) since we iterate through the input string just one time
    public MyString(String str) {
        curr_length = str.length();
        // should be appropriately initialized
        chars = new char[curr_length];
        for (int i = 0; i < curr_length; i++) {
            chars[i] = str.charAt(i);
        }
    }
    // a copy constructor that takes a MyString object and initializes a new MyString object so that it is a copy of the argument string
    // use O(n) again since we iterate through the input string just one time
    public MyString(MyString other) {
        curr_length = other.curr_length;
        chars = new char[curr_length];
        // copy the characters to the newly created array ensurnig that the content of 'other' is duplicated in the new MyString
        System.arraycopy(other.chars, 0, chars, 0, curr_length);
    }
    // a length() method that returns the number of characters in the string
    // use O(1) since we are just returning a value in this case
    public int length() {
        return curr_length;
    }
    // a private method, ensureCapacity(), that handles allocation of additional memory for the string
    // use O(n) since we are just resizing the number of characters to be copied
    private void ensureCapacity(int minCapacity) {
    	// check if the  array is currently null (no memory allocated)
        if (chars == null) {
            // if array is null, allocate a new character array with a minimum capacity
            chars = new char[Math.max(16, minCapacity)];
            // check if the current capacity of the array is less than a minimum capacity
        } else if (chars.length < minCapacity) {
        	 // if the current capacity is insufficient, create a new character array with a larger capacity which is calculated as the maximum of doubling the current capacity
            char[] newChars = new char[Math.max(chars.length * 2, minCapacity)];
            // the data from the old array is preserved in the new, larger array
            System.arraycopy(chars, 0, newChars, 0, curr_length);
            // Update the reference to point to the newly created and larger character array
            chars = newChars;
        }
    }
    // a toString() method that returns a String representation of the MyString object
    // use O(n) since we only process each character one time
    @Override
    public String toString() {
        return new String(chars, 0, curr_length);
    }
    // a concat(MyString) method that takes a MyString parameter and returns a MyString object that is a concatenation of the calling object and the parameter
    // use O(n) since it iterates through each character in both strings up to the length of the shorter string
    public MyString concat(MyString other) {
        MyString result = new MyString();
        result.ensureCapacity(curr_length + other.curr_length);
        // copy the characters from the current array to the beginning of a new array.
        System.arraycopy(chars, 0, result.chars, 0, curr_length);
        // append the characters from the current array to the end of a new array.
        System.arraycopy(other.chars, 0, result.chars, 0, curr_length);
        // update the array to reflect the total length of the concatenated strings
        result.curr_length = curr_length + other.curr_length;
        return result;
    }
    // a .equals(MyString) method that takes a MyString parameter and returns true if this MyString and the parameter are the same
    // use O(n) since it iterates through each character in both strings up to the length of the shorter string
    public boolean equals(MyString other) {
    	// check if the array is null or if the lengths are different, and if either condition is true (the two MyString objects cannot be equal) so return false
        if (other == null || curr_length != other.curr_length) {
            return false;
        }
        // iterate through the characters of both MyString objects to compare them
        for (int i = 0; i < curr_length; i++) {
            if (chars[i] != other.chars[i]) {
                return false;
            }
        }
        // if the loop completes without finding any mismatched characters (it means the two MyString objects are equal) so return true
        return true;
    }
    // a .compareTo(MyString) method that takes a MyString parameter and returns as follows
    // 0 if the parameter and this MyString are the same
    // a negative integer if this MyString is alphabetically before the parameter
    // a positive integer if this MyString is alphabetically after the parameter
    // use O(n) since it iterates through each character in both strings up to the length of the shorter string
    public int compareTo(MyString other) {
        int minLength = Math.min(curr_length, other.curr_length);
        for (int i = 0; i < minLength; i++) {
            int diff = chars[i] - other.chars[i];
            if (diff != 0) {
                return diff;
            }
        }
        return curr_length - other.curr_length;
    }
    // .get(int) method that takes an integer and returns the character at that index location (the integer must be in range)
    // use O(1) since it directly accesses the characters by the index
    public char get(int i) {
        if (i < 0 || i >= curr_length) {
            throw new IndexOutOfBoundsException("Index is out of range");
        }
        return chars[i];
    }
    // .toUpper() that returns a MyString that is in all upper case
    // use O(n) since we only process each character one time
    public MyString toUpper() {
        MyString result = new MyString(this);
        for (int i = 0; i < curr_length; i++) {
            result.chars[i] = Character.toUpperCase(chars[i]);
        }
        return result;
    }
    // .toLower() that returns a MyString that is in all lower case
    // use O(n) since we only process each character one time
    public MyString toLower() {
        MyString result = new MyString(this);
        for (int i = 0; i < curr_length; i++) {
            result.chars[i] = Character.toLowerCase(chars[i]);
        }
        return result;
    }
    // .substring(int) that takes an integer and returns the substring starting at that index
    // use O(1) since it depends on the length of the substring being copied
    public MyString substring(int startIndex) {
        return substring(startIndex, curr_length);
    }
    // .substring(int n, int m) method that returns a MyString substring where n is the starting index and m is one past the ending index
    // use O(1) since it depends on the length of the substring being copied
    public MyString substring(int startIndex, int endIndex) {
        if (startIndex < 0 || endIndex > curr_length || startIndex > endIndex) {
            throw new IndexOutOfBoundsException("Invalid substring range");
        }
        MyString result = new MyString();
        result.ensureCapacity(endIndex - startIndex);
        System.arraycopy(chars, startIndex, result.chars, 0, endIndex - startIndex);
        result.curr_length = endIndex - startIndex;
        return result;
    }
    // .indexOf(MyString) that takes a MyString parameter and return the starting index of the searching first occurrence of the MyString in the calling object
    // use O(n^2) since as it grows it is squaring the input size
    public int indexOf(MyString substring) {
        for (int i = 0; i <= curr_length - substring.curr_length; i++) {
            boolean found = true;
            for (int j = 0; j < substring.curr_length; j++) {
                if (chars[i + j] != substring.chars[j]) {
                    found = false;
                    break;
                }
            }
            if (found) {
                return i;
            }
        }
        // if the parameter is not found in the calling object, the method should return -1
        return -1;
    }
    // .lastIndexOf(MyString) that takes a MyString parameter and return the starting index of the searching last occurrence of the MyString in the calling object
    // use O(n^2) since as it grows it is squaring the input size
    public int lastIndexOf(MyString substring) {
        for (int i = curr_length - substring.curr_length; i >= 0; i--) {
            boolean found = true;
            for (int j = 0; j < substring.curr_length; j++) {
                if (chars[i + j] != substring.chars[j]) {
                    found = false;
                    break;
                }
            }
            if (found) {
                return i;
            }
        }
        // if the parameter is not found in the calling object, the method should return -1
        return -1;
    }
}
