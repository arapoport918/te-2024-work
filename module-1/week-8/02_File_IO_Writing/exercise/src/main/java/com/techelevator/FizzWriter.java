package com.techelevator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FizzWriter {

    // Use this scanner for all user input. Don't create additional Scanners with System.in
    private final Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        FizzWriter fizzWriter = new FizzWriter();
        fizzWriter.run();
    }

    public void run() {
        /* Your code goes here */

        System.out.println("What is the destination file?");
        String newFileName = userInput.nextLine();

        try (PrintWriter output = new PrintWriter(new FileOutputStream(newFileName, false))) {
            int counter = 1;
            final int MAXIMUM_VALUE = 300;
            final int FIZZ = 3;
            final int BUZZ = 5;

            while (counter <= MAXIMUM_VALUE) {
                if (counter % FIZZ == 0 && counter % BUZZ == 0) {
                    output.println("FizzBuzz");
                } else if (counter % FIZZ == 0) {
                    output.println("Fizz");
                } else if (counter % BUZZ == 0) {
                    output.println("Buzz");
                } else {
                    output.println(counter);
                }
                counter++;
            }

        } catch (IOException e) {
            System.out.println("ERROR -- " + e.getMessage());
        }


    }

}
