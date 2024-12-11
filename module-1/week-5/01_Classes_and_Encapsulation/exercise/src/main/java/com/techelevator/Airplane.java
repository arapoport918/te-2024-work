package com.techelevator;

public class Airplane {

    //Instance Variables
    private String planeNumber;
    private int totalFirstClassSeats;
    private int bookedFirstClassSeats;
    private int totalCoachSeats;
    private int bookedCoachSeats;

    //Getters
    public String getPlaneNumber() {
        return this.planeNumber;
    }

    public int getTotalFirstClassSeats() {
        return this.totalFirstClassSeats;
    }

    public int getBookedFirstClassSeats() {
        return this.bookedFirstClassSeats;
    }

    public int getAvailableFirstClassSeats() {
        return this.totalFirstClassSeats - bookedFirstClassSeats;
    }

    public int getTotalCoachSeats() {
        return this.totalCoachSeats;
    }

    public int getBookedCoachSeats() {
        return this.bookedCoachSeats;
    }

    public int getAvailableCoachSeats() {
        return this.totalCoachSeats - bookedCoachSeats;
    }

    //Constructor
    public Airplane(String planeNumber, int totalFirstClassSeats, int totalCoachSeats) {
        this.planeNumber = planeNumber;
        this.totalFirstClassSeats = totalFirstClassSeats;
        this.totalCoachSeats = totalCoachSeats;
    }

    //Method
    public boolean reserveSeats(boolean forFirstClass, int totalNumberOfSeats) {
       if (forFirstClass && totalNumberOfSeats <= getAvailableFirstClassSeats()) {
           bookedFirstClassSeats += totalNumberOfSeats;
           return true;
       } else if (!forFirstClass && totalNumberOfSeats <= getAvailableCoachSeats()) {
           bookedCoachSeats += totalNumberOfSeats;
           return true;
       } else {
           return false;
       }
    }

}


