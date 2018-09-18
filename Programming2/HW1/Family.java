package Java2;

public class Family {

	// Variables
	private double income = 0, housingCost = 0, foodCost = 0;
	private int size = 0;

	// Constructor
	public Family(double income, int size) {
		this.income = income;
		this.size = size;
	}

	// Methods
	public boolean isPoor(double housingCost, double foodCost) {
		boolean poor = false;
		if ((housingCost + foodCost) * this.size > this.income / 2) { poor = true;}
		return poor;
	}
	
	//Prints out Info
	public String toString() {
		return "\nIncome: "+this.income+
				"\nSize: "+this.size;
		
	}
}