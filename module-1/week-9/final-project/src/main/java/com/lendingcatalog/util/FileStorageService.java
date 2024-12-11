package com.lendingcatalog.util;

import com.lendingcatalog.util.exception.FileStorageException;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileStorageService {

    // Requirement: File I/O
    public static void writeContentsToFile(String contents, String filename, boolean appendFile) throws FileStorageException {

        try (PrintWriter dataOutput = new PrintWriter(new FileOutputStream(new File(filename)), appendFile)) {

            dataOutput.print(contents);

        } catch (IOException e) {
            throw new FileStorageException(e.getMessage());
        }

    }

    public static List<String> readContentsOfFile(String filename) throws FileStorageException {
        List<String> contents = new ArrayList<>();

        try {
            Scanner dataInput = new Scanner(new File(filename));
            while (dataInput.hasNextLine()) {
                String currentLine = dataInput.nextLine();
                contents.add(currentLine);
            }
        } catch (FileNotFoundException e) {
            throw new FileStorageException("Cannot locate file: " + filename, e);
        }

        return contents;

    }
}
