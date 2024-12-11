package com.techelevator;

public class HomeworkAssignment {

    //Instance Variables
    private int earnedMarks;
    private int possibleMarks;
    private String submitterName;

    //Getters
    public int getEarnedMarks() {
        return this.earnedMarks;
    }

    public int getPossibleMarks() {
        return this.possibleMarks;
    }

    public String getSubmitterName() {
        return this.submitterName;
    }

    public String getLetterGrade() {

        double earnedGrade = earnedMarks;
        double possibleGrade = possibleMarks;
        double grade = earnedGrade / possibleGrade;

        final double A = 0.90;
        final double B = 0.80;
        final double C = 0.70;
        final double D = 0.60;

        if (grade >= A) {
            return "A";
        } else if (grade < A && grade >= B) {
            return "B";
        } else if (grade < B && grade >= C) {
            return "C";
        } else if (grade < C && grade >= D) {
            return "D";
        } else {
            return "F";
        }
    }

    //Setter
    public void setEarnedMarks(int earnedMarks) {
        this.earnedMarks = earnedMarks;
    }

    //Method
    public HomeworkAssignment(int possibleMarks, String submitterName) {
        this.possibleMarks = possibleMarks;
        this.submitterName = submitterName;
    }

}
