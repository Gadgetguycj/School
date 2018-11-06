package HW3;

public abstract class DiscountPolicy {
	
	public double computeDiscount(int count, double cost) {
		return count * cost;
	}

}
