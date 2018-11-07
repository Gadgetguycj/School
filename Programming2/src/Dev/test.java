package Dev;

public class test {

	public static void main(String[] args) {
		String plainText = "zzzzzzzzz";
		int shift=1;
		String sequence = "-abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
		char[] plainTextArray = plainText.toLowerCase().toCharArray();
		char[] textArray = sequence.toCharArray();
		System.out.println("Length: "+plainTextArray.length);
		
		
		
		for(int x=0; x<plainTextArray.length; x++) {
			//User Input	Code Sequence 
			plainTextArray[x] = textArray[(plainTextArray[x])-96 + shift];
		}
		String output = new String (plainTextArray);
		System.out.println(output);
	}

}
