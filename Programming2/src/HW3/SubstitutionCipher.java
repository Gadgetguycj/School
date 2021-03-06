package HW3;

public class SubstitutionCipher implements MessageEncoder{
	private int shift;
	
	public SubstitutionCipher(int shift) {
		this.shift = shift;
	}

	@Override
	public String encode(String plainText) {
		int shift=this.shift;
		String sequence = "-abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
		char[] plainTextArray = plainText.toLowerCase().toCharArray();
		char[] textArray = sequence.toCharArray();
		
		for(int x=0; x<plainTextArray.length; x++) {
			plainTextArray[x] = textArray[(plainTextArray[x])-96 + shift];
		}
		return new String (plainTextArray);
	}

}
