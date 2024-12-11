package com.techelevator;

public class QuizQuestion {

    private static final int QUESTION_INDEX = 0;
    private static final int CHOICE_A = 1;
    private static final int CHOICE_B = 2;
    private static final int CHOICE_C = 3;
    private static final int CHOICE_D = 4;
    private String question;
    private String choiceA;
    private String choiceB;
    private String choiceC;
    private String choiceD;

    public QuizQuestion(String question, String choiceA, String choiceB, String choiceC, String choiceD) {
        this.question = question;
        this.choiceA = choiceA;
        this.choiceB = choiceB;
        this.choiceC = choiceC;
        this.choiceD = choiceD;
    }

    public QuizQuestion(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public String getChoiceA() {
        return choiceA;
    }

    public String getChoiceB() {
        return choiceB;
    }

    public String getChoiceC() {
        return choiceC;
    }

    public String getChoiceD() {
        return choiceD;
    }

    public String findCorrectAnswer(String currentLine) {
        String correctAnswer = "";

        String[] listOfQsAndAs = currentLine.split("\\|");
        String question = listOfQsAndAs[QUESTION_INDEX];

        for (int i = 1; i < listOfQsAndAs.length; i++) {
            if (listOfQsAndAs[i].contains("*")) {
                correctAnswer = String.valueOf(i);
            }
        }

        return correctAnswer;
    }

    public void displayQuestion(String qsAndAs) {
        String[] pullQuestion = qsAndAs.split("\\|");
        String question = pullQuestion[QUESTION_INDEX];

        for (int i = 1; i < pullQuestion.length; i++) {
            if (pullQuestion[i].endsWith("*")) {
                pullQuestion[i] = pullQuestion[i].substring(0, pullQuestion[i].length() - 1);
            }
        }
        System.out.println(question);
        System.out.println("1. " + pullQuestion[CHOICE_A]);
        System.out.println("2. " + pullQuestion[CHOICE_B]);
        System.out.println("3. " + pullQuestion[CHOICE_C]);
        System.out.println("4. " + pullQuestion[CHOICE_D]);
    }

}
