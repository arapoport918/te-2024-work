package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class AssessmentPart1 {

	/*
	The purpose of this method is to calculate the floating-point value of a fraction. Divide `numerator`
	by `denominator` and return the result as a double.

		 Q01_calculateFraction(6, 3) -> 2.0
		 Q01_calculateFraction(5, 2) -> 2.5
	*/
	public double Q01_calculateFraction(int numerator, int denominator) {
		double n = numerator;
		double d = denominator;
		return n / d;
	}

	/*
	The purpose of this method is to determine if the sum of two integers results in an even or odd value.
	Sum the values `a` and `b`, and then return true if the result is an even number, false if it is odd.

		 Q02_isSumEven(14, 8) -> true
		 Q02_isSumEven(13, 16) -> false
	*/
	public boolean Q02_isSumEven(int a, int b) {
		return ((a + b) % 2 == 0);
	}

	/*
	The purpose of this method is to determine the appropriate price of a movie theatre ticket.
	General admission tickets cost $12. Children's tickets cost $7.
	Persons age 12 and under are considered children.
	Return the appropriate ticket price, given the movie-goer's `age`.

		 Q03_moviePrice(8) -> 7
		 Q03_moviePrice(21) -> 12
	*/
	public int Q03_moviePrice(int age) {
		final int GA_TICKETS = 12;
		final int CHILDRENS_TICKETS = 7;
		final int CHILD_TICKET_AGE_LIMIT = 12;
		int price = 0;

		if (age <= CHILD_TICKET_AGE_LIMIT) {
			price = CHILDRENS_TICKETS;
		} else {
			price = GA_TICKETS;
		}

		return price;
	}

	/*
	The purpose of this method is to determine the appropriate price of a movie theatre ticket.
	Prices at the theatre are:
	 	Non-Matinee prices: General admission tickets cost $12. Children's tickets cost $7.
	 	Matinee prices: General admission tickets cost $8. Children's tickets cost $5.
	Persons age 12 and under are considered children.
	A movie is considered a matinee if its start time is before 5:00pm, and it is a weekday. Weekend showings,
	and any showings at or after 5:00pm are at non-matinee prices.

	Return the appropriate ticket price, given the movie-goer's `age`, whether it's a before-5pm showing (`isBefore5pm`),
	and whether it's a weekend showing (`isWeekend`).

		 Q04_moviePriceMatinee(8, false, true) -> 7
		 Q04_moviePriceMatinee(21, true, false) -> 8
	*/
	public int Q04_moviePriceMatinee(int age, boolean isBefore5pm, boolean isWeekend) {
		final int GA_TICKETS_NON_MATINEE = 12;
		final int CHILD_TICKETS_NON_MATINEE = 7;
		final int GA_TICKETS_MATINEE = 8;
		final int CHILD_TICKETS_MATINEE = 5;
		final int CHILD_TICKET_AGE_LIMIT = 12;

		int price = 0;
		//weekday true and before5pm --> matinee
		//anything else --> non-matinee

		if (isBefore5pm && !isWeekend) {
			if (age <= CHILD_TICKET_AGE_LIMIT) {
				price = CHILD_TICKETS_MATINEE;
			} else {
				price = GA_TICKETS_MATINEE;
			}
		}

		if(isWeekend || !isBefore5pm) {
			if (age <= CHILD_TICKET_AGE_LIMIT) {
				price = CHILD_TICKETS_NON_MATINEE;
			} else {
				price = GA_TICKETS_NON_MATINEE;
			}
		}

		return price;
	}

	/*
	The purpose of this method is to determine the sum of the odd numbers between two numbers (inclusive).
	Starting at 'lowestNumber', sum up all the odd numbers up to and including `highestNumber` (if it's odd).
	If `highestNumber` is less than `lowestNumber`, the result should be zero.

		 Q05_sumOfOddNumbersBetween(101, 103) -> 204
		 Q05_sumOfOddNumbersBetween(100, 104) -> 204
		 Q05_sumOfOddNumbersBetween(-12, -1) -> -36
	*/
	public int Q05_sumOfOddNumbersBetween(int lowestNumber, int highestNumber) {
		int sum = 0;

		if (lowestNumber > highestNumber) {
			sum = 0;
		} else {
			for (int i = lowestNumber; i <= highestNumber; i++) {
				if (i % 2 != 0) {
					sum += i;
				}
			}
		}

		return sum;
	}

	/*
	The purpose of this method is to return the substring of a given length, that's at the start of a given string.
	Return a String of length `numCharacters`, which is at the beginning of String `originalString`.
	Notes:
		`originalString` can be any length, zero (empty string) or more. If the length of `originalString` is less than `numCharacters`, return the entire `originalString`.
		`numCharacters` can be any number greater than or equal to zero. If `numCharacters` is 0, an empty string ("") should be returned.

		 Q06_firstNCharacters("Elephant", 3) -> "Ele"
		 Q06_firstNCharacters("No", 3) -> "No"
		 Q06_firstNCharacters("Submarine", 0) -> ""
	*/
	public String Q06_firstNCharacters(String originalString, int numCharacters) {

		if (originalString.length() <= numCharacters) {
			return originalString;
		}

		return originalString.substring(0,numCharacters);
	}

	/*
	Fix the bug!
	The purpose of this method is to find all the spaces " " inside `stringValue`, and replace those spaces with the
	string in `replaceSpaceWith`.
	Tests are failing, and you have been asked to fix the bug in this method. For example, when this method is called
	with Q07_spaceReplacer("George Washington", "_"), the expected result is "George_Washington", but the actual value returned
	is "George Washington".
	Determine the problem and fix it.

		 Q07_spaceReplacer("George Washington", "_") -> "George_Washington"
		 Q07_spaceReplacer("Stop Wait Listen ", "! ") -> "Stop! Wait! Listen! "
	*/
	public String Q07_spaceReplacer(String stringValue, String replaceSpaceWith) {
		String replaced = stringValue.replace(" ", replaceSpaceWith);
		return replaced;
	}


	/*
	Fix the bug!
	The purpose of this method is to calculate the Fahrenheit temperature value from a known Celsius temperature.
	To calculate `degreesFahrenheit`, multiply nine-fifths (9/5) times `degreesCelsius`, and to that result, add 32.
	Tests are failing, and you have been asked to fix the bug in this method. For example, when this method is called
	with Q08_convertToFahrenheit(10.0), the expected result is 50.0, but the actual value returned is 42.0.
	Determine the problem and fix it.

		 Q08_convertToFahrenheit(0.0) -> 32.0
		 Q08_convertToFahrenheit(10.0) -> 50.0
		 Q08_convertToFahrenheit(100.0) -> 212.0
	*/
	public double Q08_convertToFahrenheit(double degreesCelsius) {
		double degreesFahrenheit = ((9.0 / 5.0) * degreesCelsius) + 32.0;
		return degreesFahrenheit;
	}

	/*
	Fix the bug!
	The purpose of this method is to calculate the Celsius temperature value from a known Fahrenheit temperature.
	To calculate `degreesCelsius`, subtract 32 from `degreesFahrenheit`, and then multiply the result by five-ninths (5/9).
	Tests are failing, and you have been asked to fix the bug in this method. For example, when this method is called
	with Q09_convertToCelsius(32.0), the expected result is 0.0, but the actual value returned is 14.222222222222221.
	Determine the problem and fix it.

		 Q09_convertToCelsius(32.0) -> 0.0
		 Q09_convertToCelsius(50.0) -> 10.0
		 Q09_convertToCelsius(212.0) -> 100.0
	*/
	public double Q09_convertToCelsius(double degreesFahrenheit) {
		double degreesCelsius = (degreesFahrenheit - 32.0) * (5.0 / 9.0);
		return degreesCelsius;
	}

	/*
	The purpose of this method is to, given an input array of ints, return an array which has the first and last
	elements of the input array swapped (exchanged).

	Return an array whose first element is the last element of `arrayOfInts`, and whose last element is the first
	element of `arrayOfInts`. You may create a new array, populate it and return it, or you may change
	`arrayOfInts` in-place, and return it.

		 Q10_swapFirstAndLastElements([1,2,3]) -> [3,2,1]
		 Q10_swapFirstAndLastElements([1,2]) -> [2,1]
	*/
	public int[] Q10_swapFirstAndLastElements(int[] arrayOfInts) {
		int[] swap = new int[arrayOfInts.length];

		swap[0] = arrayOfInts[arrayOfInts.length - 1];
		swap[swap.length - 1] = arrayOfInts[0];

		for (int i = 1; i < arrayOfInts.length - 1; i++) {
			swap[i] = arrayOfInts[i];
		}

		return swap;
	}

	/*
	The purpose of this method is to create a map that represents a catering order (meal: quantity), given an array of
	meal orders.
	You are responsible for placing the catering order for a party. All the guests have placed an order, and those orders
	are in the String array `mealOrders`.
	Return a Map<String, Integer> where the String `key` is the name of a meal, and the Integer `value` is the number of times
	that meal name is found in `mealOrders`.
	NOTE: Since the Map is an unordered collection, the order in which the entries are added or displayed is not important to the result.

		 Q11_mealCount(["Beef", "Chicken", "Fish", "Tofu", "Tofu", "Fish"]) -> {"Beef": 1, "Chicken": 1, "Fish": 2, "Tofu": 2}
	*/
	public Map<String, Integer> Q11_mealCount(String[] mealOrders) {

		Map<String, Integer> meals = new HashMap<>();

		for (String food : mealOrders) {
			if (meals.containsKey(food)) {
				meals.put(food, meals.get(food) + 1);
			} else {
				meals.put(food, 1);
			}
		}

		return meals;
	}

}
