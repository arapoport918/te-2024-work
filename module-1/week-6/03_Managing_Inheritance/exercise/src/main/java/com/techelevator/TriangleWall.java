package com.techelevator;

public class TriangleWall extends Wall {

    private int base;
    private int height;
    public TriangleWall(String name, String color, int base, int height) {
        super(name, color);
        this.base = base;
        this.height = height;
    }

    @Override
    public int getArea() {
        int area = base * height;
        double triangleArea = (double) area / 2;
        int triangle = (int) triangleArea;
        return triangle;
    }

    @Override
    public String toString() {
        return this.getName() + " (" + base + "x" + height + ") triangle";
    }

    public int getBase() {
        return base;
    }

    public int getHeight() {
        return height;
    }
}
