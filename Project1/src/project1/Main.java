package project1;
// main program that tests my MyString class with all of it's functions
public class Main {
    public static void main(String[] args) {
    	
        MyString str1 = new MyString("Good morning!");
        MyString str2 = new MyString("Good afternoon!");
        MyString str3 = new MyString("Good morning!");
        System.out.println("MyString Objects: ");
        System.out.println("String 1: " + str1);
        System.out.println("String 2: " + str2);
        System.out.println("String 3: " + str3);
        System.out.println("");
        
        System.out.println("Test for the length() method: ");
        System.out.println("String 1 length: " + str1.length());
        System.out.println("String 2 length: " + str2.length());
        System.out.println("String 3 length: " + str3.length());
        System.out.println("");

        System.out.println("Test for the toString() method: ");
        System.out.println("String 1: " + str1.toString());
        System.out.println("String 2: " + str2.toString());
        System.out.println("String 3: " + str3.toString());
        System.out.println("");

        System.out.println("Test for the concat() method: ");
        MyString concatenated = str1.concat(str2);
        System.out.println("Concatenated: " + concatenated.toString());
        System.out.println("");

        System.out.println("Test for the equals() method: ");
        System.out.println("String 1 equals String 2: " + str1.equals(str2));
        System.out.println("String 1 equals String 3: " + str1.equals(str3));
        System.out.println("");

        System.out.println("Test for the compareTo() method: ");
        System.out.println("String 1 compareTo String 2: " + str1.compareTo(str2));
        System.out.println("String 1 compareTo String 3: " + str1.compareTo(str3));
        System.out.println("String 2 compareTo String 3: " + str2.compareTo(str3));
        System.out.println("");

        System.out.println("Test for the get() method: ");
        System.out.println("Character at index 2 in String 1: " + str1.get(2));
        System.out.println("Character at index 6 in String 2: " + str2.get(6));
        System.out.println("Character at index 9 in String 3: " + str3.get(9));
        System.out.println("");

        System.out.println("Test for the toUpper() and toLower() methods: ");
        System.out.println("String 1 toUpper: " + str1.toUpper().toString());
        System.out.println("String 1 toLower: " + str1.toLower().toString());
        System.out.println("String 2 toUpper: " + str2.toUpper().toString());
        System.out.println("String 2 toLower: " + str2.toLower().toString());
        System.out.println("String 3 toUpper: " + str3.toUpper().toString());
        System.out.println("String 3 toLower: " + str3.toLower().toString());
        System.out.println("");

        System.out.println("Test for the substring() method: ");
        System.out.println("Substring of String 1 from index 1: " + str1.substring(1).toString());
        System.out.println("Substring of String 1 from index 1 to 3: " + str1.substring(1, 3).toString());
        System.out.println("Substring of String 2 from index 1: " + str2.substring(1).toString());
        System.out.println("Substring of String 2 from index 3 to 6: " + str2.substring(3, 6).toString());
        System.out.println("Substring of String 3 from index 1: " + str3.substring(1).toString());
        System.out.println("Substring of String 3 from index 6 to 9: " + str3.substring(6, 9).toString());
        System.out.println("");

        System.out.println("Test for the indexOf() and lastIndexOf() methods: ");
        MyString searchString = new MyString("i");
        System.out.println("Index of 'i' in String 1: " + str1.indexOf(searchString));
        System.out.println("Last index of 'i' in String 1: " + str1.lastIndexOf(searchString));
    }
}
