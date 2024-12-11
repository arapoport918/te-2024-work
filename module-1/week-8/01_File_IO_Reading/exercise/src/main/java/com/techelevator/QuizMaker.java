package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QuizMaker {

    // Use this scanner for all user input. Don't create additional Scanners with System.in
    private final Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        QuizMaker quizMaker = new QuizMaker();
        quizMaker.run();
    }

    public void run() {
        /* Your code goes here */
        System.out.println("Enter the fully qualified name of the file to read in for quiz questions");
        String filePath = userInput.nextLine();

        File dataFile = new File(filePath);
        int correctAnswerCounter = 0;
		int numberOfQuestions = 0;

        try {
            Scanner dataInput = new Scanner(dataFile);

            while (dataInput.hasNextLine()) {
                String question = dataInput.nextLine();

                QuizQuestion quiz = new QuizQuestion(question);
				numberOfQuestions++;
                quiz.displayQuestion(question);

                System.out.print("Your Answer: ");
                String userAnswer = userInput.nextLine();

                if (userAnswer.equals(quiz.findCorrectAnswer(question))) {
                    System.out.println("RIGHT!");
                    System.out.println();
					correctAnswerCounter++;
                } else {
                    System.out.println("WRONG!");
                    System.out.println();
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

		System.out.println("You got " + correctAnswerCounter + " answer(s) correct out of the " + numberOfQuestions+ " questions asked.");

    }

}
