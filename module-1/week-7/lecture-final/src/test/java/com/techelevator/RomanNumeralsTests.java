package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class RomanNumeralsTests {


    @Test
    public void one_returns_i() {
        // 1. Arrange
        int input = 1;
        RomanNumerals sut = new RomanNumerals();

        // 2. Act
        String output = sut.romify(input);

        // 3. Assert
        Assert.assertEquals("I", output);
    }

    @Test
    public void five_returns_v() {
        // 1. Arrange
        int input = 5;
        RomanNumerals sut = new RomanNumerals();

        // 2. Act
        String output = sut.romify(input);

        // 3. Assert
        Assert.assertEquals("V", output);
    }


}
