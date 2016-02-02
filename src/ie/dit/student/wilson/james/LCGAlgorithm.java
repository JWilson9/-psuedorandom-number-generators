package ie.dit.student.wilson.james;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;

public class LCGAlgorithm {
	final static SecureRandom random = new SecureRandom();
	static int bitlen = 32;

	public static BigInteger[] lcgList(int amount){
		BigInteger m = new BigInteger("4294967296");// 2^32
		BigInteger a = randomNumber();
		BigInteger b = randomNumber();
		BigInteger x = randomNumber();
		ArrayList<BigInteger> list = new ArrayList<BigInteger>();
		
		int i =0;
		while(i < amount){
			 x = (a.multiply(x).add(b)).mod(m); 
			 if((x.isProbablePrime(1) && x.intValue() > 0 && x.bitLength() == 31)){
				 list.add(x);
				 i++;
			 }
		 }
		
		BigInteger[] arrayList = list.toArray(new BigInteger[list.size()]);
		return arrayList;
	}
	
	public static int lcgSingleNumber(){
		BigInteger m = new BigInteger("4294967296");// 2^32
		BigInteger a = randomNumber();
		BigInteger b = randomNumber();
		BigInteger x = randomNumber();
		ArrayList<Integer> randomList = new ArrayList<Integer>();
		
		boolean numberNotPrime = true;
		while(numberNotPrime){
			 x = (a.multiply(x).add(b)).mod(m); // LCG formula
			 if((x.intValue() > 0 && x.bitLength() == 31)){
				 randomList.add(x.intValue());
				 numberNotPrime = false;
			 }
		 }
		
		return x.intValue();
	}
	
	public static BigInteger randomNumber(){
		BigInteger randomNumber = new BigInteger(bitlen, random);
		boolean numberGenerated = true;
		
		while(numberGenerated){
			randomNumber = new BigInteger(bitlen, random);
			if (randomNumber.isProbablePrime(1) && (randomNumber.intValue() > 0 && randomNumber.bitLength() == 31)){
				numberGenerated = false;
			}
		}
		
		return randomNumber;
	}
}


