package com.techelevator;

public class FruitTree {

    //Instance Variables
    private String typeOfFruit;
    private int piecesOfFruitLeft;

    //Getters
    public String getTypeOfFruit() {
        return this.typeOfFruit;
    }

    public int getPiecesOfFruitLeft() {
        return this.piecesOfFruitLeft;
    }

    //Constructor
    public FruitTree(String typeOfFruit, int startingPiecesOfFruit) {
        this.typeOfFruit = typeOfFruit;
        this.piecesOfFruitLeft = startingPiecesOfFruit;
    }

    //Method
    public boolean pickFruit(int numberOfPiecesToRemove) {
        if (piecesOfFruitLeft >= numberOfPiecesToRemove) {
            piecesOfFruitLeft -= numberOfPiecesToRemove;
            return true;
        } else {
            return false;
        }
    }
}
