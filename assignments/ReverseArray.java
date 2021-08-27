package week3.day2.assignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ReverseArray {
	public static void main(String[] args) {
		// .Declare a String array and add the Strings values as
		// (Google,Microsoft,TestLeaf,Maverick)
		String[] str = { "Google", "Microsoft", "TestLeaf", "Maveric" };

		// 2.Get the length of the array
		int length = str.length;

		System.out.println("lenght of the array is :" + length);

		// 3. sort the array

		List<String> li = new ArrayList<String>(Arrays.asList(str));
		Collections.sort(li);
		System.out.println("before Reverse" + li);

		Collections.reverse(li);
		for (String each : li) {
		}
		System.out.println("after reverse" + li);

		// 4. Iterate it in the reverse order

		// 5. print the array

	}

}
