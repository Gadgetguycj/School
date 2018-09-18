package Semester1;

import java.util.Scanner;

public class Integers {

	/**Chase Lauer
	 * 4/1/2018
	 * clauer@nyit.edu
	 * Integers
	 * Enter Integers and obtain statistics
	 */ 
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		System.out.println("Please input a list of non-negitive integers: ");
		int input, smallestInt=0, largestInt=-1, totalRuns=0, total=0;
		double average=0;
		do{
			input = read.nextInt();	
			if(input>-1){
				if(input>largestInt){
					largestInt = input;
				}
				if((input<smallestInt)||totalRuns==0){
					smallestInt = input;
				}

				total+=input; 
				totalRuns++;
			}
			
		}while(input>-1);
		if(totalRuns>0){
		average = total / (double)totalRuns;
		System.out.println("Smallest Number: "+smallestInt);
		System.out.println("Largest Number: "+largestInt);
		System.out.println("Average: "+average);
		}
		else{
			System.out.println("No usable numbers entered");
		}
		
			

	}

}
