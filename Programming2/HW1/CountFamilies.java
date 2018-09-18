package Java2;

import java.util.Scanner;

public class CountFamilies {

	public static void main(String[] args) {
		// Chase Lauer
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the number of families: ");
		
		//Initialize Variables
		int k = input.nextInt();
		int poorFamilies=0;
		double[] familyIncome = new double[k];
		double maxIncome=0;
		
		//Read-in Income
		System.out.println("Please input an income: ");
		for (int i = 0; i < k; i++) {
			System.out.println("Family "+(i+1)+": ");
			familyIncome[i] = input.nextDouble();;
			if(familyIncome[i]>maxIncome) {maxIncome = familyIncome[i];}
		}
		//Print Max Income
		System.out.println("The maximum income was: $"+maxIncome);
		
		//Print out Poor Families	
		System.out.println("\nPoor Families: ");
		for(int x = 0; x<k; x++) {
			if(familyIncome[x]<maxIncome*.1) {
				System.out.println("Family "+(x+1)+" Income: "+familyIncome[x]);
				poorFamilies++;
			}
		}
		System.out.println(poorFamilies+" total poor families");
		
		
		
		
		
		
		
	}

}
