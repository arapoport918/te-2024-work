package com.techelevator;

import org.junit.Test;
import org.junit.Assert;

public class HelloWorldTests {

    @Test
    public void twoPlusTwoEqualsFour() {
        // Step 1. Arrange
        // Step 2. Act
        // Step 3. Assert

        Assert.assertEquals("Java", "JavaScript");
    }

    @Test
    public void sevenDividedByTwoIsThree() {
        // Arrange
        int numerator = 7;
        int denominator = 2;

        // Act
        int result = 7 / 2;

        // Assert
        Assert.assertEquals(3, result);
    }

    @Test
    public void sevenDividedByTwoIsThreeAndOneHalf() {
        double result = 0.1 + 0.2;

        System.out.println(result);

        Assert.assertEquals(0.3, result, 0.01);
    }

}
