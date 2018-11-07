package HW3;

public class BulkDiscount extends DiscountPolicy{
	private double minimum, percent;

	public BulkDiscount(double minimum, double percent) {
		this.minimum = minimum;
		this.percent = percent;
		computeDiscount();

	}
	public double computeDiscount() {
		double discount=0.0;
		if(this.minimum>minimum) {	
			this.percent = discount;
		}
		return discount;
	}

}
