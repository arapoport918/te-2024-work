package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class Lucky13Tests {

    @Test
    public void int_of_arrays_containing_1s_and_3s_returns_false() {

        int[] input = new int[]{1, 3, 1, 3};
        Lucky13 sut = new Lucky13();

        boolean output = sut.getLucky(input);

        Assert.assertFalse(output);
    }

    @Test
    public void int_of_arrays_containing_no_1s_and_3s_returns_true() {

        int[] input = new int[]{2, 4, 2, 4};
        Lucky13 sut = new Lucky13();

        boolean output = sut.getLucky(input);

        Assert.assertTrue(output);
    }

    @Test
    public void int_of_arrays_containing_nothing_returns_true() {

        int[] input = new int[]{};
        Lucky13 sut = new Lucky13();

        boolean output = sut.getLucky(input);

        Assert.assertTrue(output);
    }

    @Test
    public void int_of_arrays_of_null_returns_true() {

        int[] input = null;
        Lucky13 sut = new Lucky13();

        boolean output = sut.getLucky(input);

        Assert.assertTrue(output);
    }

    @Test
    public void int_of_arrays_of_nums_containing_1_returns_false() {

        int[] input = new int[]{2, 4, 6, 8, 0, 4, 5, 1};
        Lucky13 sut = new Lucky13();

        boolean output = sut.getLucky(input);

        Assert.assertFalse(output);
    }

    @Test
    public void int_of_arrays_of_nums_containing_3_returns_false() {

        int[] input = new int[]{2, 4, 6, 8, 0, 4, 5, 3};
        Lucky13 sut = new Lucky13();

        boolean output = sut.getLucky(input);

        Assert.assertFalse(output);
    }

    @Test
    public void int_of_arrays_of_nums_containing_10_returns_true() {

        int[] input = new int[]{2, 4, 6, 8, 0, 4, 5, 10};
        Lucky13 sut = new Lucky13();

        boolean output = sut.getLucky(input);

        Assert.assertTrue(output);
    }

    @Test
    public void int_of_arrays_of_nums_containing_30_returns_true() {

        int[] input = new int[]{2, 4, 6, 8, 0, 4, 5, 30};
        Lucky13 sut = new Lucky13();

        boolean output = sut.getLucky(input);

        Assert.assertTrue(output);
    }

    @Test
    public void int_of_arrays_of_nums_containing_13_returns_true() {

        int[] input = new int[]{2, 4, 6, 8, 0, 4, 5, 13};
        Lucky13 sut = new Lucky13();

        boolean output = sut.getLucky(input);

        Assert.assertTrue(output);
    }
}
