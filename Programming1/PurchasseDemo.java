package Semester1;

public class PurchasseDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double orangeCost;
		double appleCost;
		double eggCost;
		double watermelonCost;
		double bagelCost;
		double grandTotal;
		
		Purchase Item1 = new Purchase();
		Purchase Item2 = new Purchase();
		Purchase Item3 = new Purchase();
		Purchase Item4 = new Purchase();
		Purchase Item5 = new Purchase();
		
		Item1.setName("Oranges");
		Item2.setName("Apples");
		Item3.setName("Eggs");
		Item4.setName("watermelons");
		Item5.setName("Bagels");
		
		Item1.setPrice(10, 2.99);
		Item2.setPrice(12, 1.69);
		Item3.setPrice(3, 1);
		Item4.setPrice(1, 4.39);
		Item5.setPrice(6, 3.50);
		
		Item1.setNumberBought(24);
		Item2.setNumberBought(24);
		Item3.setNumberBought(20);
		Item4.setNumberBought(2);
		Item5.setNumberBought(12);
		
		orangeCost = Item1.getTotalCost();
		eggCost = Item2.getTotalCost();
		appleCost = Item3.getTotalCost();
		watermelonCost = Item4.getTotalCost();
		bagelCost = Item5.getTotalCost();
		
		grandTotal = orangeCost + eggCost + appleCost + watermelonCost + bagelCost;
		
		System.out.println("The cost for the "+Item1.getName()+" was $"+orangeCost);
		System.out.println("The cost for the "+Item2.getName()+" was $"+eggCost);
		System.out.println("The cost for the "+Item3.getName()+" was $"+appleCost);
		System.out.println("The cost for the "+Item4.getName()+" was $"+watermelonCost);
		System.out.println("The cost for the "+Item5.getName()+" was $"+bagelCost);
		System.out.println("The grand total for your groceries is $"+grandTotal);
		
		
		
	}

}
