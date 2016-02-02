package ie.dit.student.wilson.james;



import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class CompareBitResults {
	GenNumbers random = new GenNumbers();
	static int ones = 0;
	static int zeros = 0;

	public static void main(String[] args) {
		GenNumbers.singleMersenneTwisterNumber();
		BigInteger test = null;
		for (int i = 0; i < 100; i++) {
			test = BigInteger.valueOf(GenNumbers.generateSingleRandomFromComiler());
			
			HashMap<Character, Integer> chars = (HashMap<Character, Integer>) ratio2(test);
			zeros = zeros + chars.get('0');
			ones = ones + chars.get('1');
			
			
		}
		
		double total = ones + zeros;
		//System.out.println("Totals: " + total);
		double onePercents = (ones/total) * 100;
		double zeroPercents = (zeros/total) * 100;
		System.out.println("% 0's: " + zeroPercents + "%| 1's: " + onePercents + "%");

	}

	public static Map<Character, Integer> ratio2(BigInteger test) {
		String binary = test.toString(2);
		char arraysample[] = binary.toCharArray();
		HashMap<Character, Integer> numChars = new HashMap<Character, Integer>();

		for (int i = 0; i < binary.length(); i++) {
			if (!numChars.containsKey(arraysample[i])) {
				numChars.put(arraysample[i], 1);
			} else {
				numChars.put(arraysample[i], numChars.get(arraysample[i]) + 1);
			}
		}
		return numChars;
	}
}
