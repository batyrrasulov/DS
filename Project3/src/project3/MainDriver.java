package project3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainDriver
{
	public static void main(String[] args)
			throws FileNotFoundException
	{
        var lst1 = new DLinkedList<String>();
        var lst2 = new DLinkedList<String>();

        var fin = new Scanner(new File("/Applications/Eclipse.app/Contents/MacOS/workspaceCST-201/Project3/src/Text1.in"));
        String str;

        while (fin.hasNext())
        {
            str = fin.next();
            str = cleanUp(str);
            lst1.insertOrderUnique(str);
        }
        
        fin.close();

        fin = new Scanner(new File("/Applications/Eclipse.app/Contents/MacOS/workspaceCST-201/Project3/src/Text2.in"));
        while (fin.hasNext())
        {
            str = fin.next();
            str = cleanUp(str);
            lst2.insertOrderUnique(str);
        }

        System.out.println("List 1:  " + lst1);
        System.out.println("List 2:  " + lst2);

        var combined = lst1.merge(lst2);

        System.out.println("\nAFTER MERGE");
        System.out.println("List 1:  " + lst1);
        System.out.println("List 2:  " + lst2);
        System.out.println("\n" + combined);
	}
	/**
	 * ASSIGNED
	 * @param str
	 * @return str in all lower case with LEADING and TRAILING non-alpha
	 * chars removed
	 */
	public static String cleanUp(String str) {
		// remove the leading and trailing whitespace characters
        str = str.trim(); 
        // convert the string to lowercase
        str = str.toLowerCase();
        // remove the non-alphabetic characters from the beginning of the string
        while(str.charAt(0) < 'a' || str.charAt(0) > 'z') {
        	str = str.substring(1);
        }
        // remove the non-alphabetic characters from the end of the string
        while(str.charAt(str.length() -1) < 'a' || str.charAt(str.length() - 1) > 'z') {
        	str = str.substring(0, str.length() - 1);
        }
        // return the cleaned up string
    	return str;
	}
}
