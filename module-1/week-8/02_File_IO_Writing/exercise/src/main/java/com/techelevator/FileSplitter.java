package com.techelevator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileSplitter {

    // Use this scanner for all user input. Don't create additional Scanners with System.in
    private final Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        FileSplitter fileSplitter = new FileSplitter();
        fileSplitter.run();
    }

    public void run() {
        /* Your code goes here */

        System.out.println("Where is the input file (please include the path to the file)?");
        String fileName = userInput.nextLine();
        String fileNameExtension = fileName.substring(fileName.indexOf("."));
        String name = fileName.substring(0, fileName.indexOf("."));

        System.out.println("How many lines of text (max) should there be in the split files?");
        String maxLines = userInput.nextLine();

		int fileNumber = 1;

        System.out.println("**GENERATING OUTPUT**");
        System.out.println();

		try (PrintWriter dataOutput = new PrintWriter(name + "-" + fileNumber + fileNameExtension); Scanner dataInput = new Scanner(fileName)) {
            int maxNumberOfLines = Integer.parseInt(maxLines);
            int currentLine = 1;
            while (dataInput.hasNextLine()) {
                while (currentLine < maxNumberOfLines) {
                    dataOutput.println();
                    currentLine++;
                }
                fileNumber++;
                currentLine = 1;
                System.out.println(name + "-" + fileNumber + fileNameExtension);
            }
        } catch (FileNotFoundException e) {
            System.out.println("ERROR -- " + e.getMessage());
        }

    }

}
