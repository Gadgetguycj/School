package HW5;

import java.util.Scanner;

public class Compute {

	public static void main(String[] args) {
		//Chase Lauer
		Scanner read = new Scanner(System.in);
		int x=0, y=0;
		
		try {
			System.out.println("Please input integer #1"); x = read.nextInt();
			System.out.println("Please input integer #2"); y = read.nextInt();
			
			
		} catch (Exception e){
			System.err.println("Error, please enter values again");

			
		}finally {
			System.out.println("Remainder: "+ (x%y));
		}

		

		
	}

}
