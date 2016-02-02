package ie.dit.student.wilson.james;



import java.math.*;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.random.MersenneTwister;
/**
 * Lab 5 due 08/12/15
 * @author James WIlson
 *
 */
public class GenNumbers {

	final static SecureRandom random = new SecureRandom();
	static int bitlength = 32;
	
	public static BigInteger[] generateMersenneTwisterList(int numbersToGenerate) {
		List<BigInteger> list = new ArrayList<>();
		int i = 0;
		while (i < numbersToGenerate){
			BigInteger number = BigInteger.valueOf(singleMersenneTwisterNumber());
			if(number.isProbablePrime(1) && (number.intValue() > 0) ){
				list.add(number);
				i++;
			}
		}
		
		BigInteger[] arrayList = list.toArray(new BigInteger[list.size()]);
		return arrayList;
	}
	// generating a number using mersenne twister
	public static int singleMersenneTwisterNumber() {
		MersenneTwister mt = new MersenneTwister();
		BigInteger randomNumber = BigInteger.valueOf(mt.nextInt());
		boolean numberNotPrime = true;
	
		while (numberNotPrime) {
			randomNumber = BigInteger.valueOf(mt.nextInt());
			if (randomNumber.intValue() > 0 && randomNumber.bitLength() == 31) {
				numberNotPrime = false;
			}
		}
		return randomNumber.intValue();
	}

	public static ArrayList<Integer> generateRandomFromComiler() {
		ArrayList<Integer> randomList = new ArrayList<Integer>();
		BigInteger randomPrime = new BigInteger(bitlength, random);
		int i = 0;
		while (i < 10) {
			randomPrime = new BigInteger(bitlength, random);
			if (randomPrime.isProbablePrime(1) && (randomPrime.intValue() > 0) && randomPrime.bitLength() == 31) {
				randomList.add(randomPrime.intValue());
				i++;
			}
		}
		return randomList;
	}
	
	
	public static int generateSingleRandomFromComiler() {
		BigInteger randomPrime = new BigInteger(bitlength, random);
		boolean numberNotPrime = true;
		while (numberNotPrime) {
			randomPrime = new BigInteger(bitlength, random);
			if (randomPrime.intValue() > 0 && randomPrime.bitLength() == 31) {
				numberNotPrime = false;
			}
		}
		return randomPrime.intValue();
	}
	
	// next prime number
	public static int nextPrimeNumber(int prime){
		BigInteger randomPrime = BigInteger.valueOf(prime);
		randomPrime = randomPrime.nextProbablePrime();
		return randomPrime.intValue();
	}
	
	// checking to see if the number generated
	public static String isPrime(int prime){
		BigInteger randomPrime = BigInteger.valueOf(prime);
		String result = "False";
		
		if(randomPrime.isProbablePrime(1)){
			result = "True";
		}
		return result;
	}

}
