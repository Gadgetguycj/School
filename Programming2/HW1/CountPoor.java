package Java2;

public class CountPoor {

	public static void main(String[] args) {
		//Chase Lauer
		Family family1 = new Family(40000.00, 4);
		Family family2 = new Family(4000.00, 10);
		System.out.println("Is Family 1 poor? "+family1.isPoor(20.00, 30.00));
		System.out.println("Is Family 2 poor? "+family2.isPoor(20000.00, 30000.00));
		System.out.println("Family 1 Info: "+family1.toString());
		}
		

}
