package com.techelevator;

import java.util.Locale;
import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {
		final double METRE_CONV = 0.3048;
		final double FEET_CONV = 3.2808399;
		double lengthMetre;
		double lengthFeet;

		Scanner keyboard = new Scanner(System.in);

		System.out.print("Please enter the length: ");
		String length = keyboard.nextLine();
		int len = Integer.parseInt(length); //convert string to int

		//safeguard against entering a negative number
		while (len < 0) {
			System.out.print("Please enter a valid length: ");
			len = Integer.parseInt(keyboard.nextLine());
		}


		System.out.print("Is the measurement in (m)etre, or (f)eet? ");
		String unit = keyboard.nextLine();
		String unitAdj = unit.toLowerCase(); //safeguard against user entering caps

		String metre = "m";
		String feet = "f";

		if (unitAdj.equals(metre)) {
			lengthFeet = len * FEET_CONV;
			int f = (int)lengthFeet;
			System.out.println(len + "m is " + f + "f");
		} else if (unitAdj.equals(feet)) {
			lengthMetre = len * METRE_CONV;
			int m = (int)lengthMetre;
			System.out.println(len + "f is " + m + "m");
		}
	}

}
