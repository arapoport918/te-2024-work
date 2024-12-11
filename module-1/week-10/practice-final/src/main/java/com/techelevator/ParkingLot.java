package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    // DO NOT REMOVE the DEFAULT_NUMBER_OF_... constants!!!!!
    public static final int DEFAULT_NUMBER_OF_COMPACT_SLOTS = 3;
    public static final int DEFAULT_NUMBER_OF_MIDSIZE_SLOTS = 5;
    public static final int DEFAULT_NUMBER_OF_FULLSIZE_SLOTS = 2;

    /*
    Fill in the class details here...
     */

    private final Car[] compactSlots = new Car[DEFAULT_NUMBER_OF_COMPACT_SLOTS];
    private final Car[] midsizeSlots = new Car[DEFAULT_NUMBER_OF_MIDSIZE_SLOTS];
    private final Car[] fullsizeSlots = new Car[DEFAULT_NUMBER_OF_FULLSIZE_SLOTS];

    private String name;
    private boolean open;
    private int numberOfCompactSlots = DEFAULT_NUMBER_OF_COMPACT_SLOTS;
    private int numberOfMidsizeSlots = DEFAULT_NUMBER_OF_MIDSIZE_SLOTS;
    private int numberOfFullsizeSlots = DEFAULT_NUMBER_OF_FULLSIZE_SLOTS;

    public ParkingLot(String name) {
        this.name = name;
    }

    public ParkingLot(String name, boolean open) {
        this.name = name;
        this.open = open;
    }

    public ParkingLot(String name, boolean open, int numberOfCompactSlots, int numberOfMidsizeSlots, int numberOfFullsizeSlots) {
        this.name = name;
        this.open = open;
        this.numberOfCompactSlots = numberOfCompactSlots;
        this.numberOfMidsizeSlots = numberOfMidsizeSlots;
        this.numberOfFullsizeSlots = numberOfFullsizeSlots;
    }

    public int getLotSize() {
        return numberOfCompactSlots + numberOfMidsizeSlots + numberOfFullsizeSlots;
    }

    public int numberOfAvailableSlots(String carType) {
        if (carType.equals(Car.COMPACT)) {
            return numberOfCompactSlots;
        }

        if (carType.equals(Car.MIDSIZE)) {
            return numberOfMidsizeSlots;
        }

        if (carType.equals(Car.FULLSIZE)) {
            return numberOfFullsizeSlots;
        }

        return -1;
    }

    public boolean park(Car car) throws ParkingLotException {
        if (!isOpen()) {
            throw new ParkingLotException("Parking Lot is closed!");
        }

        if (car == null || car.getType() == null) {
            return false;
        }

        if (car.getType().equalsIgnoreCase(Car.COMPACT) && numberOfCompactSlots > 0) {
            compactSlots[DEFAULT_NUMBER_OF_COMPACT_SLOTS - numberOfCompactSlots--] = car;
            return true;
        }

        if (car.getType().equalsIgnoreCase(Car.MIDSIZE) && numberOfMidsizeSlots > 0) {
            midsizeSlots[DEFAULT_NUMBER_OF_MIDSIZE_SLOTS - numberOfMidsizeSlots--] = car;
            return true;
        }

        if (car.getType().equalsIgnoreCase(Car.FULLSIZE) && numberOfFullsizeSlots > 0) {
            fullsizeSlots[DEFAULT_NUMBER_OF_FULLSIZE_SLOTS - numberOfFullsizeSlots--] = car;
            return true;
        }

        return false;
    }

    public Car exit(String license) {
        for (int i = 0; i < compactSlots.length; i++) {
            Car car = compactSlots[i];

            if (car != null && car.getLicense().equalsIgnoreCase(license)) {
                compactSlots[i] = null;
                numberOfCompactSlots++;
                return car;
            }
        }

        for (int i = 0; i < midsizeSlots.length; i++) {
            Car car = midsizeSlots[i];

            if (car != null && car.getLicense().equalsIgnoreCase(license)) {
                midsizeSlots[i] = null;
                numberOfMidsizeSlots++;
                return car;
            }
        }

        for (int i = 0; i < fullsizeSlots.length; i++) {
            Car car = fullsizeSlots[i];

            if (car != null && car.getLicense().equalsIgnoreCase(license)) {
                fullsizeSlots[i] = null;
                numberOfFullsizeSlots++;
                return car;
            }
        }

        return null;
    }

    public String getName() {
        return name;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public int getNumberOfCompactSlots() {
        return numberOfCompactSlots;
    }

    public int getNumberOfMidsizeSlots() {
        return numberOfMidsizeSlots;
    }

    public int getNumberOfFullsizeSlots() {
        return numberOfFullsizeSlots;
    }
}
