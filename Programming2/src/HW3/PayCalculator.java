package HW3;

public abstract class PayCalculator {
	private static double payRate;

	public double computePay(int hours) {
		return hours * payRate;
	}
}
