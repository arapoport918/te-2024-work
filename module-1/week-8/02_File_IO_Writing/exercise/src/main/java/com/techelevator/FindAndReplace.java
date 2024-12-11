package com.techelevator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FindAndReplace {

    // Use this scanner for all user input. Don't create additional Scanners with System.in
    private final Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        FindAndReplace findAndReplace = new FindAndReplace();
        findAndReplace.run();
    }

    public void run() {
        /* Your code goes here */

        System.out.println("What is the search word?");
        String searchWord = userInput.nextLine();

        System.out.println("What is the replacement word?");
        String newWord = userInput.nextLine();

        System.out.println("What is the source file?");
        String fileName = userInput.nextLine();
        File dataFile = new File(fileName);

        System.out.println("What is the destination file?");
        String newFileName = userInput.nextLine();

        try (PrintWriter dataOutput = new PrintWriter(newFileName); Scanner fileReader = new Scanner(dataFile)) {

            while (fileReader.hasNextLine()) {
                String currentLine = fileReader.nextLine();

                if (currentLine.contains(searchWord)) {
                    dataOutput.println(currentLine.replace(searchWord, newWord));
                } else {
                    dataOutput.println(currentLine);
                }
            }

        } catch (IOException e) {
            System.out.println("ERROR -- " + e.getMessage());
        }



    }

}
