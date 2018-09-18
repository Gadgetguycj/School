package HW1;

public class LedgerMain {

	public static void main(String[] args) {
		// Chase Lauer
		Ledger ledger1 = new Ledger(10);
		ledger1.addSale(100.00);
		ledger1.addSale(200.00);
		ledger1.addSale(300.01);
		
		System.out.println("Number of Sales: "+ledger1.getNumberOfSales());
		System.out.println("Total Sale Value: "+ledger1.getTotalSales());
		System.out.println("Average Sale: "+ledger1.getAverageSale());
		System.out.println("Number of Sales that Exceeded $104.00: "+ledger1.getCountAbove(104.00));

	}

}
