package com.techelevator;

public class Elevator {

    //Instance Variables
    private int currentFloor = 1;
    private int numberOfFloors;
    private boolean doorOpen;

    //Getters
    public int getCurrentFloor() {
        return this.currentFloor;
    }

    public int getNumberOfFloors() {
        return this.numberOfFloors;
    }

    public boolean isDoorOpen() {
        return this.doorOpen;
    }

    //Constructors
    public Elevator(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    //Methods
    public void openDoor() {
        doorOpen = true;
    }

    public void closeDoor() {
        doorOpen = false;
    }

    public void goUp(int desiredFloor) {

        if (!doorOpen && desiredFloor > currentFloor) {
            int differenceInFloors = desiredFloor - currentFloor;
            currentFloor += differenceInFloors;
        } else {
            desiredFloor = currentFloor;
        }



        if (desiredFloor >= numberOfFloors) {
            currentFloor = numberOfFloors;
        }

    }

    public void goDown(int desiredFloor) {

        if (!doorOpen && desiredFloor < currentFloor) {
            int differenceInFloors = currentFloor - desiredFloor;
            currentFloor -= differenceInFloors;
        } else {
            desiredFloor = currentFloor;
        }

        if (desiredFloor <= 1) {
            currentFloor = 1;
        }
    }

}

