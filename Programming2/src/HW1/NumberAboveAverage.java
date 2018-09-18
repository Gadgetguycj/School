package HW1;

import java.util.Scanner;

public class NumberAboveAverage {

	public static void main(String[] args) {
		// Chase Lauer
		Scanner input = new Scanner(System.in);	
		int temps[] = new int[10];
		int average, sum=0;

		//Loop through temperatures
		for(int x=0,y=10; x<=9; x++, y++) {
			//Prompt User Input
			System.out.println("Please input a temperature, "+y+" more needed");
			temps[x] = input.nextInt();

			//Compute Sum
			sum = sum + temps[x];

		}
		
		//Compute Average
		average = sum / 10;
		
		//Loop through temperatures
		for(int x=0; x<=9; x++) {
			//Prompt User Input
			if(temps[x] > average)
				System.out.println("Day "+(x+1));

		}


	}

}
