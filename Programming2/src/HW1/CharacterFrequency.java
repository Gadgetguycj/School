package HW1;

import java.util.Scanner;

public class CharacterFrequency {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int[] phoneNumber = new int[10];

		// Read in Phone Number
		System.out.println("Please Enter a Phone Number: ");
		String number = reader.nextLine();

		// Count Digit Occurrences
		for (int x = 0; x < number.length(); x++) {
			phoneNumber[Integer.parseInt(number.substring(x, x+1))]++;
		}
		
		//Contents of Array
		System.out.println("Array Contents: ");
		for (int x = 0; x < number.length(); x++) {
			System.out.println("Number: "+phoneNumber[x]);
		}

		//Print Digit Occurrences
		for (int x = 0; x < 10; x++) {
			if(phoneNumber[x]>0) {
				System.out.println("Number "+x+" occurs "+phoneNumber[x]+" times.");
			}
		}

	}

}
