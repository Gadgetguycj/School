package Dev;

import java.util.Scanner;

public class PassGen {

	public static void main(String[] args) {
		//Chase
		Scanner read = new Scanner(System.in);
		System.out.println("Enter Length of Password");
		int passLength = read.nextInt();
		
		System.out.println("Pronouncable? (Y/N)");
		String pronouncable = read.nextLine();
		
		
		
		for(int i=0; i<passLength; i++) {
			if(pronouncable.equals("Y")) {
				
			}
		}

	}

}
