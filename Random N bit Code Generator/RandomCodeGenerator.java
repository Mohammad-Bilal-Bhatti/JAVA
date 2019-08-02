import java.util.Random;
public class RandomCodeGenerator{

	// Capital A - Z
	public static final int BIG_MIN = 65;
	public static final int BIG_MAX = 90;	

	// Small a - z
	public static final int SMALL_MIN = 97;	
	public static final int SMALL_MAX = 122;

	/*
	*	Generate n bit code
	*
	*/	
	public static String generateCode(int bit){
		Random randomNumberGenerator = new Random();
		String code = "";
		boolean flip = true;
		for(int i=1 ; i <= bit ; i++){
			int charNumber;
			if(flip)
				charNumber = randomNumberGenerator.nextInt((BIG_MAX - BIG_MIN) + 1) + BIG_MIN;
			else
				charNumber = randomNumberGenerator.nextInt((SMALL_MAX - SMALL_MIN) + 1) + SMALL_MIN;
			flip = randomNumberGenerator.nextBoolean();
			code += (char)charNumber +"";
		}
		return code;
	}

	public static void main(String[] args){

		// Generating Random Stirngs.
		System.out.println("4 bit CODE: "+generateCode(4));

		System.out.println("8 bit CODE: "+generateCode(8));

		System.out.println("16 bit CODE: "+generateCode(16));

		System.out.println("32 bit CODE: "+generateCode(32));

	}

}