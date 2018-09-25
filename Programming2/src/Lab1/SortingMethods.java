package Lab1;

import java.util.Scanner;

public class SortingMethods {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);

		// Variables
		int[] intArray = new int[10];
		System.out.println("Please Select a Sorting Method: \n1. Bubble Sort \n2. Insertion Sort \n3. SelectionSort");
		int sortingMethod = read.nextInt();

		// Read in Integers
		for (int i = 0; i <= 9; i++) {
			System.out.println("Enter an Integer");
			intArray[i] = read.nextInt();
		}

		// Bubble Sort
		if (sortingMethod == 1) {
			boolean sorted = false;
			while (!sorted) {
				sorted = true;
				// Run through the array
				for (int i = 0; i < intArray.length - 1; i++) {
					int arrayPos1 = intArray[i], arrayPos2 = intArray[i + 1];
					if (intArray[i] > intArray[i + 1]) {
						sorted = false;
						intArray[i] = arrayPos2;
						intArray[i + 1] = arrayPos1;
					}
				}
			}
		}
		

		// Insertion Sort
		else if (sortingMethod == 2) {
			for (int outer = 0; outer < intArray.length - 1; outer++) {
				int tempOuter = outer, leftSide;

				// Left Side of Comparison / Right Side of Comparison 
				while (intArray[tempOuter] > intArray[tempOuter + 1]) {
					//Store int on left side of comparison
					leftSide = intArray[tempOuter];
					intArray[tempOuter] = intArray[tempOuter + 1];
					intArray[tempOuter + 1] = leftSide;
					tempOuter--;
					
					// Check for Out of Bounds
					if(tempOuter <=-1) break;
				}
			}

		}
		printArray(intArray);

	}

	// List out numbers
	public static void printArray(int[] intArray) {
		for (int i = 0; i <= 9; i++) {
			System.out.println("Order: " + intArray[i]);
		}
	}
}
