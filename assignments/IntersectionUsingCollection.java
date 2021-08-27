package week3.day2.assignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionUsingCollection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// * a) Declare An array for {3,2,11,4,6,7};
		// * b) Declare another array for {1,2,8,4,9,7};

		int[] arr = { 3, 2, 11, 4, 6, 7 };
		int arr1[] = { 1, 2, 8, 4, 9, 7 };

		List<Integer> aslist1 = new ArrayList<Integer>();
		List<Integer> aslist2 = new ArrayList<Integer>();

		for (Integer integer : arr) {
			aslist1.add(integer);

		}

		for (Integer integer : arr1) {
			aslist2.add(integer);

		}
		aslist1.retainAll(aslist2);

		System.out.println("Intersection between both arrays " + aslist1);

	}

}
