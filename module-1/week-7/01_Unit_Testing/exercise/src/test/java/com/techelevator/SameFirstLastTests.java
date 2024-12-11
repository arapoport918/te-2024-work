package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class SameFirstLastTests {

    @Test
    public void happy_path_string_is_greater_than_1_and_first_and_last_element_are_equal() {

        int[] input = new int[]{1, 5, 1};
        SameFirstLast sut = new SameFirstLast();

        boolean output = sut.isItTheSame(input);

        Assert.assertTrue(output);
    }

    @Test
    public void happy_path_string_is_greater_than_1_and_first_and_last_element_are_not_equal() {

        int[] input = new int[]{1, 5, 3};
        SameFirstLast sut = new SameFirstLast();

        boolean output = sut.isItTheSame(input);

        Assert.assertFalse(output);
    }

    @Test
    public void array_is_empty() {

        int[] input = new int[]{};
        SameFirstLast sut = new SameFirstLast();

        boolean output = sut.isItTheSame(input);

        Assert.assertFalse(output);
    }

    @Test
    public void happy_path_string_is_greater_than_1_and_first_and_last_element_are_equal_length_is_2() {

        int[] input = new int[]{1, 1};
        SameFirstLast sut = new SameFirstLast();

        boolean output = sut.isItTheSame(input);

        Assert.assertTrue(output);
    }

    @Test
    public void happy_path_string_is_greater_than_1_and_first_and_last_element_are_not_equal_length_is_2() {

        int[] input = new int[]{1, 2};
        SameFirstLast sut = new SameFirstLast();

        boolean output = sut.isItTheSame(input);

        Assert.assertFalse(output);
    }

    @Test
    public void happy_path_string_is_greater_than_1_and_first_and_last_element_are_equal_long_array_length() {

        int[] input = new int[]{1, 5, 1};
        SameFirstLast sut = new SameFirstLast();

        boolean output = sut.isItTheSame(input);

        Assert.assertTrue(output);
    }

    @Test
    public void happy_path_string_is_greater_than_1_and_first_and_last_element_are_equal_negative_numbers() {

        int[] input = new int[]{-11, -5, -11};
        SameFirstLast sut = new SameFirstLast();

        boolean output = sut.isItTheSame(input);

        Assert.assertTrue(output);
    }

    @Test
    public void happy_path_string_is_greater_than_1_and_first_and_last_element_are_not_equal_negative_numbers() {

        int[] input = new int[]{-11, 5, -101};
        SameFirstLast sut = new SameFirstLast();

        boolean output = sut.isItTheSame(input);

        Assert.assertFalse(output);
    }
}
