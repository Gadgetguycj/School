package HW3;

public abstract class PayCalculator {
	private static double payRate;

	protected double computePay(int hours) {
		return hours * payRate;
	}
}
