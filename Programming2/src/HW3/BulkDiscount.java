package HW3;

public class BulkDiscount extends DiscountPolicy{
	private double minimum, percent;

	public BulkDiscount(double minimum, double percent) {
		this.minimum = minimum;
		this.percent = percent;
		this.computeDiscount(minimum, percent);

	}
	public double computeDiscount() {

	}

}
