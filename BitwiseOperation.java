/* Given an array of binary which is calculated by the following formula
 * sum = sum + A[i] * (-2)^i while i move from 0 to A.length - 1 (most significant bit is on the right side)
 * 1	-2		4		-8		16		-32
 * =========================================
 * 1	 0		0		1		1		 0			=> return 9 in decimal	
 * Calculate the decimal value of given array, and find the ceiling value of that (sum/2).
 * Then convert that ceiling value back to binary array using above formula in Integer type without unnecessary bit.
 */
import java.util.Arrays;

public class BitwiseOperation {
	public static int convertToModifiedBinary(int[] input) {
		final int arraySize = 8;
		int sum = 0;
		for (int i = 0; i < input.length; i++) {
			sum += input[i] * Math.pow(-2, i);
		}System.out.println("sum: " + sum);
		int ceil = (int)Math.ceil((double)sum/2);System.out.println("ceil: " + ceil);
		String binArray = Integer.toBinaryString(ceil & 0xff);//int has 4 bytes, so toBinaryString will return 
														  //a 32 bit String for negative number.
														  //In order to get only last 8 bits, we can use AND 0xff.
														  //0xFF is the hexadecimal number FF, equals to 1111 1111.
		/*	Or we can make a mask value like this:
		 	int mask = 0b11111111;
			String binA = Integer.toBinaryString(ceil & mask);
			would show the same result.
		 */
		System.out.println("ceil value in binary string: " + binArray);
		//create a new char array filled with 0
		char[] result = new char[arraySize];
		for (int i = 0; i < arraySize; i++) {
			result[i] = '0';
		}
		System.out.println("Pre modified array: ");System.out.println(result);
		//copy the value from binArray to char array by
		//checking each value of binArray from right to left then put it into result from left to right
		for (int i = 0,bit = ceil & 1; i < arraySize; i++,ceil >>= 1, bit = ceil & 1) {
			if (bit == 0) continue;
			if (i%2 == 0) {//even index in result[] correspond to odd index in binArray,
						   //which means they both represent positive values 1 4 16 64...
				if (result[i] == '0') result[i] += bit;
				else {
					result[i] = '0';
					if (i < arraySize -1) result[i+1] = '1';
					if (i < arraySize -2) result[i+2] = '1';
				}
			} else {//odd index in result[] will represent negative values -2 -8 -32 ...
				if (result[i] == '0') {//for exp, we want 2 then we need to use 4 -2
					result[i] = '1';
					if (i < arraySize -1) result[i+1] = '1';
				} else result[i] = '0';//for exp we want 2 but -2 already exists, we just turn the -2 bit off
			}
		}
		System.out.println("Post modified array: ");System.out.println(result);
		int stop;
		for (stop = arraySize - 1; stop >=0; stop--) {
			if (result[stop] == '1') {
				stop += 1;
				break;
			}
		}
		result = Arrays.copyOf(result, stop);
		
		int finalResult = Integer.parseInt(String.valueOf(result));
		return finalResult;
		
	}
	public static void main(String[] args) {
		int[] exp1 = {1,0,0,1,1,1};//-23 would return 101011 in int type binary array of -11 
		System.out.println("Modified array in shortest form: \n" + convertToModifiedBinary(exp1));
		System.out.println();
		int[] exp2 = {1,0,0,1,1};//9 would return 101 in int type binary array of 5 
		System.out.println("Modified array in shortest form: \n" + convertToModifiedBinary(exp2));
	}
}
