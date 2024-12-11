package com.techelevator;

import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {
		final int ZERO = 0;
		final int ONE = 1;

		Scanner keyboard = new Scanner(System.in);
		System.out.print("Please enter in a series of decimal values (separated by spaces): ");

		String values = keyboard.nextLine();
		String[] splitValues = values.split(" ");
		int[] valuesAsInts = new int[splitValues.length];

		//take array of Strings and convert to ints
		for (int i = 0; i < splitValues.length; i++) {
			valuesAsInts[i] = Integer.parseInt(splitValues[i]);
		}

		String binary = "";

		for (int i = 0; i < valuesAsInts.length; i++) {
			//set initial 0 or 1 for starting value
			int num = valuesAsInts[i]; //add here to make it loop through values
			if (valuesAsInts[i] % 2 == ZERO) {
				binary = String.valueOf(ZERO); //intelliJ suggestion --> converts value of diff datatype to String
			} else {
				binary = String.valueOf(ONE);
			}
			//divide until you get 1 or 0
			while (num > 1) {
				num = num /2;
				if (num % 2 == ZERO) {
					binary = ZERO + binary;
				} else if (num % 2 == ONE) {
					binary = ONE + binary;
				}
			} //string is done and created
			System.out.println(valuesAsInts[i] + " in binary is " + binary);
		}

	}

}

