package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class Less20Tests {

    @Test
    public void when_n_is_18_return_true() {

        int input = 18;
        Less20 sut = new Less20();

        boolean output = sut.isLessThanMultipleOf20(input);

        Assert.assertTrue(output);

    }

    @Test
    public void when_n_is_19_return_true() {

        int input = 19;
        Less20 sut = new Less20();

        boolean output = sut.isLessThanMultipleOf20(input);

        Assert.assertTrue(output);

    }

    @Test
    public void when_n_is_20_return_false() {

        int input = 20;
        Less20 sut = new Less20();

        boolean output = sut.isLessThanMultipleOf20(input);

        Assert.assertFalse(output);

    }

    @Test
    public void when_n_is_0_return_false() {

        int input = 0;
        Less20 sut = new Less20();

        boolean output = sut.isLessThanMultipleOf20(input);

        Assert.assertFalse(output);

    }

    @Test
    public void when_n_is_1_return_false() {

        int input = 1;
        Less20 sut = new Less20();

        boolean output = sut.isLessThanMultipleOf20(input);

        Assert.assertFalse(output);

    }

    @Test
    public void when_n_is_upper_limit_return_false() {

        int input = 2147483647;
        Less20 sut = new Less20();

        boolean output = sut.isLessThanMultipleOf20(input);

        Assert.assertFalse(output);

    }

    @Test
    public void when_n_is_1119_return_false() {

        int input = 2147483647;
        Less20 sut = new Less20();

        boolean output = sut.isLessThanMultipleOf20(input);

        Assert.assertFalse(output);

    }
}
