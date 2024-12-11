package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		final int FIBONACCI_ZERO = 0;
		final int FIBONACCI_ONE = 1;

		Scanner keyboard = new Scanner(System.in);
		System.out.print("Please enter a number: ");
		String startingNumber = keyboard.nextLine();

		int numero = Integer.parseInt(startingNumber);
		int numeroZero = 0;
		int numeroUno = 1;


		int fibonacci;
		String fibonacciFinale = FIBONACCI_ZERO + ", " + FIBONACCI_ONE;

		for (int i = 2; i < numero; i++) {

			//if input is 1, 0 or negative number --> return 0, 1
			if (numero < 1) {
				fibonacciFinale = FIBONACCI_ZERO + ", " + FIBONACCI_ONE;
			}

			//calculate fibonacci seq
			fibonacci = numeroZero + numeroUno;
			fibonacciFinale = fibonacciFinale + ", " + fibonacci;
			numeroZero = numeroUno;
			numeroUno = fibonacci;

			//break loop when number is reached
			if (numeroZero + numeroUno > numero){
				break;
			}

		}

		//case for when input is 1
		if (numero == 1) {
			fibonacciFinale = FIBONACCI_ZERO + ", " + FIBONACCI_ONE + ", " + FIBONACCI_ONE;
		}

		System.out.print(fibonacciFinale);

	}

}
