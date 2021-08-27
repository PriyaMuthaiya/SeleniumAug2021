package week3.day2.assignments;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class RemoveDuplicateArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 14, 12, 13, 11, 15, 14, 18, 16, 17, 19, 18, 17, 20 };

		Arrays.sort(arr);
	
		
		 // using set
		  Set<Integer> arrSet=new TreeSet<Integer>(); 
		  for (Integer arrNum :arr) 
		  { 
			  arrSet.add(arrNum);
		  
		  
		  } System.out.println("Unique values in an array is"+arrSet);
		 

	}

}
