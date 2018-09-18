package Java2;

public class Ledger {
	private int salesMade = 0, maxSales = 0;
	private double[] sale;

	public Ledger(int maxSales) {
		this.sale = new double[10];
		this.salesMade = salesMade;
		this.maxSales = maxSales;
	}

	public void addSale(double d) {
		sale[salesMade] = d;
		salesMade++;
	}

	public int getNumberOfSales() {
		return salesMade;
	}

	public double getTotalSales() {
		double total = 0;
		for (int x = 0; x < salesMade; x++) {
			total += sale[x];
		}
		return total;
	}

	public double getAverageSale() {
		double total = 0;
		for (int x = 0; x < salesMade; x++) {
			total += sale[x];
		}
		return total / salesMade;
	}

	public int getCountAbove(double v) {
		int total = 0;
		for (int x = 0; x < salesMade; x++) {
			if (sale[x] > v) {
				total++;
			}
		}
		return total;
	}

}
