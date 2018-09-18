package Semester1;

public class CoinToss {

	/**Chase Lauer
	 * 4/1/2018
	 * clauer@nyit.edu
	 * Coin Toss
	 * Random flp of a coin
	 */ 
	public static void main(String[] args) {
		double random;
		String toss;
		double headsTotal=0, tailsTotal=0;
		for(int i=0; i<8; i++){
			random = Math.random();
			if(random>=.5){ // If heads
				System.out.println("Heads!");
				headsTotal++;
			} 
			else { //If tails
				System.out.println("Tails!");
				tailsTotal++;
			}
		
		}
		System.out.println("Total Heads: "+(int)headsTotal);
		System.out.println("Total Heads Percentage: "+(headsTotal/8)*100+"%");
		System.out.println("Total Tails: "+(int)tailsTotal);
		System.out.println("Total Tails Percentage: "+(tailsTotal/8)*100+"%");

		
	}
}