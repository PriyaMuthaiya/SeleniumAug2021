package week3.day2.assignments;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class DuplicateArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "PayPal India";
		str = str.toLowerCase();
		str = str.replace(" ", "");
		System.out.println(str);
		// 1.Convert it into a character array
		char[] charArray = str.toCharArray();
		// 2.Declare a Set as charSet for Character
		Set<Character> charSet = new HashSet<Character>();

		Set<Character> dups = new HashSet<Character>();
		for (int i = 0; i < charArray.length; i++) {
			charSet.add(charArray[i]);
			for (int j = i; j < charArray.length; j++) {
				boolean contains = charSet.contains(charArray[j]);
				if (contains == true) {
					dups.add(charArray[i]);
				}
			}
			System.out.println(dups);
		}

		for (Character character : charSet) {
			boolean empty = charSet.isEmpty();
			if (empty == false) {
				System.out.print(character);
			}
		}

		// 3.Declare a Set as dupCharSet for duplicate Character

		// 4.Iterate character array and add it into charSet

		/*
		 * 5.If the character is already in the charSet then, add it to the dupCharSet
		 * 
		 * 6.Check the dupCharSet elements and remove those in the charSet
		 * 
		 * 7.Iterate using charSet
		 * 
		 * 8.Check the iterator variable isn't equals to an empty space
		 * 
		 * 9.print it
		 */

	}

}
