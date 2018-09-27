package Dev;

import java.util.Scanner;

public class Mountain {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		System.out.println("Enter size of the mountain: ");
		int size = read.nextInt(), maxWidth = size / 2;

		for (int width = 0; width <= maxWidth; width++) {
			System.out.println("\n");
			for (int i = 0; i <= width; i++) {
				System.out.print("|");
			}
		}

		for (int width = maxWidth; width >= 0; width--) {
			System.out.println("\n");
			for (int i = 0; i <= width; i++) {
				System.out.print("|");
			}
		}
	}

}
