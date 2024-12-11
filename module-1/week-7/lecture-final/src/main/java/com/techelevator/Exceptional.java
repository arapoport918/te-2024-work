package com.techelevator;

import java.util.Scanner;

public class Exceptional {
    public static void main(String[] args) {

        Scanner darkly = new Scanner(System.in);

        System.out.println("Stand back, about to math...");

        boolean weHaveGoodInput = false;

        while (!weHaveGoodInput) {
            System.out.print("Enter numerator >>> ");
            String numeratorAsString = darkly.nextLine();

            System.out.print("Enter denominator >>> ");
            String denominatorAsString = darkly.nextLine();

            try {
                int numerator = Integer.parseInt(numeratorAsString);      // MIGHT throw a NumberFormatException
                int denominator = Integer.parseInt(denominatorAsString);  // MIGHT throw a NumberFormatException

                int result = numerator / denominator;                     // MIGHT throw an ArithmeticException

                System.out.println(numerator + " / " + denominator + " = " + result);
                weHaveGoodInput = true;
            } catch (NumberFormatException nfe) {
                System.out.println("Type in real numbers, please");
            } catch (ArithmeticException ae) {
                System.out.println("Stop trying to break math");
            } catch (Exception e) {
                System.out.println("I don't know what you did, but it was SOMETHING");
            }
        }


        System.out.println("Done!");

    }
}
