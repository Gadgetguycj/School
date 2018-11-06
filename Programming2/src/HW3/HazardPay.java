package HW3;

public class HazardPay extends RegularPay{
	

	public HazardPay(int payRate) {
		super(payRate);
		// TODO Auto-generated constructor stub
	}
	
	public double computePay(int hours) {
		return 1.5 * PayCalculator.computePay(hours);
	}


}
