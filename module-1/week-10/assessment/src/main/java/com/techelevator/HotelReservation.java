package com.techelevator;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class HotelReservation {
    /*
    Fill in the class details here...
     */

    //Instance Variables
    private String name;
    private int numberOfNights;
    private int nightlyRate;

    //Constructor
    public HotelReservation(String name, int numberOfNights, int nightlyRate) {
        this.name = name;
        this.numberOfNights = numberOfNights;
        this.nightlyRate = nightlyRate;
    }

    //Methods
    public int getActualTotal(boolean requiresCleaning, boolean usedMinibar) {
        final int CLEANING_FEE = 25;
        final int MINIBAR_FEE = 15; //if used double cleaning

        int total = getEstimatedTotal();
        int cleaningFee = 0;

        if (requiresCleaning && usedMinibar) {
            cleaningFee = CLEANING_FEE * 2;
            total += cleaningFee + MINIBAR_FEE;
        } else if (!requiresCleaning && usedMinibar) {
            total += MINIBAR_FEE;
        } else if (requiresCleaning) {
            total += CLEANING_FEE;
        }

        return total;
    }

    @Override
    public String toString() {
        return name + ":" + getEstimatedTotal();
    }

    //Getters + Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public int getNightlyRate() {
        return nightlyRate;
    }

    public void setNightlyRate(int nightlyRate) {
        this.nightlyRate = nightlyRate;
    }

    //Derived Variable
    public int getEstimatedTotal() {
        return numberOfNights * nightlyRate;
    }
}
