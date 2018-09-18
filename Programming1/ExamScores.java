package Semester1;

import java.util.Scanner;

public class ExamScores {

	/**Chase Lauer
	 * 4/1/2018
	 * clauer@nyit.edu
	 * ExamScores
	 * Read in and find statistics on grades
	 */ 
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		//Grades
		int totalA=0, totalB=0, totalC=0, totalD=0, totalF=0, other=0;
		//Other ints
		int input=0, totalRuns=0, total=0;

		System.out.println("Welcome to Gradescore 1.0! Please enter a grade from 0 to 100");
		do{
			input = read.nextInt();
			if(input>-1){
				
				if(input >=90){
					totalA++;
				}
				else if(input >=80){
					totalB++;
				}
				else if(input >=70){
					totalC++;
				}
				else if(input >=60){
					totalD++;
				}
				else if(input >=50){
					totalF++;
				}
				else{
					other++;
				}
				totalRuns++;
				total=+input;
			}
			if(totalRuns>0)	
				System.out.println("Please enter another grade, or type -1 to exit.");
		}while(input>-1);
			System.out.println("Total number of grades: "+totalRuns);
			System.out.println("Total A's "+totalA);
			System.out.println("Total B's "+totalB);
			System.out.println("Total C's "+totalC);
			System.out.println("Total D's "+totalD);
			System.out.println("Total F's "+totalF);
			System.out.println("Other: "+other);

			
	}

}
