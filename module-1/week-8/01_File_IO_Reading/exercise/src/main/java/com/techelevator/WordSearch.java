package com.techelevator;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class WordSearch {

    // Use this scanner for all user input. Don't create additional Scanners with System.in
    private final Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        wordSearch.run();
    }

    public void run() {
        /* Your code goes here */
        System.out.println("What is the fully qualified name of the file that should be searched?");
        String fileName = userInput.nextLine();

        File dataFile = new File(fileName);

        System.out.println("What is the search word you are looking for?");
        String wordSearch = userInput.nextLine();
        String lowercaseWordSearch = wordSearch.toLowerCase();

		System.out.println("Should the search be case sensitive? (Y\\N)");
		String caseSensitive = userInput.nextLine();

        try {
            Scanner dataInput = new Scanner(dataFile);
            int lineCounter = 0;

            while (dataInput.hasNextLine()) {

                String currentLine = dataInput.nextLine();
                String lowercaseCurrentLine = currentLine.toLowerCase();
                lineCounter++;

                if (caseSensitive.equalsIgnoreCase("y") && currentLine.contains(wordSearch)) {
                    System.out.println(lineCounter + ": " + currentLine);

                } else if (caseSensitive.equalsIgnoreCase("n") && lowercaseCurrentLine.contains(lowercaseWordSearch)) {
                    System.out.println(lineCounter + ": " + currentLine);
                }

            }
        } catch (IOException e) {
            System.out.println("File does not exist, please enter a new file path.");
        }

    }

}
