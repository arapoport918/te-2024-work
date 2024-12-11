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

    private String name;
    private boolean open = false;
    private int numberOfCompactSlots = DEFAULT_NUMBER_OF_COMPACT_SLOTS;
    private int numberOfMidsizeSlots = DEFAULT_NUMBER_OF_MIDSIZE_SLOTS;
    private int numberOfFullsizeSlots = DEFAULT_NUMBER_OF_FULLSIZE_SLOTS;
    private List<Car> parkedCars = new ArrayList<>();


    //Constructors
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

    //Methods
    public int getLotSize() {
        return numberOfCompactSlots + numberOfMidsizeSlots + numberOfFullsizeSlots;
    }

    public int numberOfAvailableSlots(String carType) {

        if(carType.equals("compact")) {
            return this.numberOfCompactSlots;
        } else if(carType.equals("midsize")) {
            return this.numberOfMidsizeSlots;
        } else {
            return this.numberOfFullsizeSlots;
        }
    }

    public boolean park(Car car) throws ParkingLotException{

        if (!isOpen()) {
            throw new ParkingLotException("Parking Lot is Closed.");
        }

        if (car.getType().equals("compact") && this.numberOfCompactSlots > 0) {
            numberOfCompactSlots--;
            parkedCars.add(car);
            return true;
        } else if (car.getType().equals("midsize") && this.numberOfMidsizeSlots > 0) {
            numberOfMidsizeSlots--;
            parkedCars.add(car);
            return true;
        } else if (car.getType().equals("fullsize") && this.numberOfFullsizeSlots > 0) {
            numberOfFullsizeSlots--;
            parkedCars.add(car);
            return true;
        }
        return false;
    }

    public Car exit(String license) {
        int parkedCarIndex = 0;
        boolean isParked = false;

        for (int i = 0; i < parkedCars.size(); i++) {
            String test = parkedCars.get(i).getLicense();
            if (license.equals(test)) {
                parkedCarIndex = i;
                isParked = true;
                break;
            }
        }

        if (isParked) {
            Car exitCar = parkedCars.get(parkedCarIndex);
            String carType = parkedCars.get(parkedCarIndex).getType();

            if (carType.equals("compact")) {
                numberOfCompactSlots++;
                parkedCars.remove(parkedCarIndex);
            } else if (carType.equals("midsize")) {
                numberOfMidsizeSlots++;
                parkedCars.remove(parkedCarIndex);
            } else {
                numberOfFullsizeSlots++;
                parkedCars.remove(parkedCarIndex);
            }

            return exitCar;
        }
        return null;
    }

    //Setters
    public void setOpen(boolean open) {
        this.open = open;
    }

    //Getters
    public String getName() {
        return name;
    }

    public boolean isOpen() {
        return open;
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
