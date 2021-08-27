package week3.day2.assignments;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// * a) Use the declared String text as input
		String text = "We learn java basics as part of java sessions in java week1";
		// * b) Initialize an integer variable as count

		int count = 0;
		// * c) Split the String into array and iterate over it
		String[] allWords = text.split(" ");
		Arrays.sort(allWords);
		Set<String> unique = new HashSet<String>();
		for (int i = 0; i < allWords.length; i++) {
			for (int j = i + 1; j < allWords.length; j++) {
				if (text.contains(allWords[i])) {
					count++;
					if (count > 1) {
						allWords[i].toString().replace(allWords[i], "");
						unique.add(allWords[i]);
					}

				}

			}

		}
		// * d) Initialize another loop to check whether the word is there in the array

		// * e) if it is available then increase and count by 1.
		// * f) if the count > 1 then replace the word as ""
		System.out.println(unique);

	}

}
