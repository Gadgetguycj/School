package Lab1;

import java.util.Scanner;

public class SortingMethods {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);

		// Variables
		int[] intArray = new int[10];
		System.out.println("Please Select a Sorting Method: \n1. Bubble Sort \n2. Insertion Sort \n3. SelectionSort");
		int sortingMethod = read.nextInt();
		
		
		
		//Read in Integers
		for (int i = 0; i <= 9; i++) {
			System.out.println("Enter an Integer");
			intArray[i] = read.nextInt();
		}
		
		//Bubble Sort
		if(sortingMethod==1) {
			boolean sorted=false;
			while(!sorted) {
				//Run through the array
				for(int i=0; i<=intArray.length; i++) {
					
				}
			}
		}
		
	}
}
