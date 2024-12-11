package com.techelevator;

import java.util.Locale;
import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {
		double temperatureCelsius;
		double temperatureFahrenheit;
		final double CONV_FACTOR = 1.8;
		final int CONV_ADDITION = 32;

		//initialize scanner for user input
		Scanner keyboard = new Scanner(System.in);

		System.out.print("Please enter the temperature: ");

		//get user input and convert to int
		String temperature = keyboard.nextLine();
		int temp = Integer.parseInt(temperature);

		System.out.print("Is the temperature in (C)elsius or (F)ahrenheit? ");
		String tempUnit = keyboard.nextLine();
		String tempUnitAdj = tempUnit.toUpperCase(); //safeguard against user entering lowercase

		String celsius = "C";
		String fahrenheit = "F";

		if (tempUnitAdj.equals(celsius)) {
			temperatureFahrenheit = temp * CONV_FACTOR + CONV_ADDITION;
			int tempF = (int)temperatureFahrenheit;
			System.out.println(temp + "C is " + tempF +"F");
		} else if (tempUnitAdj.equals(fahrenheit)) {
			temperatureCelsius = (temp - CONV_ADDITION) / CONV_FACTOR;
			int tempC = (int)temperatureCelsius;
			System.out.println(temp + "F is " + tempC + "C");
		}

	}

}
