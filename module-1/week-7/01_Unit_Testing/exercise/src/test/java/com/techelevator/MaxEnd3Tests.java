package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class MaxEnd3Tests {

    @Test
    public void happy_path_return_array_with_highest_number_for_all_array_spots() {

        int[] input = new int[]{1, 2, 3};
        MaxEnd3 sut = new MaxEnd3();

        int[] output = sut.makeArray(input);

        Assert.assertArrayEquals(new int[]{3, 3, 3}, output);
        Assert.assertEquals(3, output.length);

    }

    @Test
    public void happy_path_return_array_with_highest_number_for_all_array_spots_when_all_the_same() {

        int[] input = new int[]{3, 3, 3};
        MaxEnd3 sut = new MaxEnd3();

        int[] output = sut.makeArray(input);

        Assert.assertArrayEquals(new int[]{3, 3, 3}, output);
        Assert.assertEquals(3, output.length);

    }

    @Test
    public void happy_path_return_array_with_highest_number_for_all_array_spots_when_there_is_a_negative_number() {

        int[] input = new int[]{-3, 0, 3};
        MaxEnd3 sut = new MaxEnd3();

        int[] output = sut.makeArray(input);

        Assert.assertArrayEquals(new int[]{3, 3, 3}, output);
        Assert.assertEquals(3, output.length);

    }

    @Test
    public void return_second_highest_number_when_highest_number_is_in_middle() {

        int[] input = new int[]{2, 1000000, 1};
        MaxEnd3 sut = new MaxEnd3();

        int[] output = sut.makeArray(input);

        Assert.assertArrayEquals(new int[]{2, 2, 2}, output);
        Assert.assertEquals(3, output.length);

    }

    @Test
    public void return_correct_value_when_all_numbers_are_negative_and_highest_is_in_middle() {

        int[] input = new int[]{-3, -1, -4};
        MaxEnd3 sut = new MaxEnd3();

        int[] output = sut.makeArray(input);

        Assert.assertArrayEquals(new int[]{-3, -3, -3}, output);
        Assert.assertEquals(3, output.length);

    }

    @Test
    public void return_correct_value_when_all_numbers_are_negative() {

        int[] input = new int[]{-1, -10, -4};
        MaxEnd3 sut = new MaxEnd3();

        int[] output = sut.makeArray(input);

        Assert.assertArrayEquals(new int[]{-1, -1, -1}, output);
        Assert.assertEquals(3, output.length);

    }

    @Test
    public void return_correct_value_when_all_numbers_are_zero() {

        int[] input = new int[]{0, 0, 0};
        MaxEnd3 sut = new MaxEnd3();

        int[] output = sut.makeArray(input);

        Assert.assertArrayEquals(new int[]{0, 0, 0}, output);
        Assert.assertEquals(3, output.length);

    }

    @Test
    public void return_correct_value_when_all_numbers_are_zero_and_middle_is_higher() {

        int[] input = new int[]{0, 1000000, 0};
        MaxEnd3 sut = new MaxEnd3();

        int[] output = sut.makeArray(input);

        Assert.assertArrayEquals(new int[]{0, 0, 0}, output);
        Assert.assertEquals(3, output.length);

    }

    @Test
    public void return_correct_value_when_last_value_is_highest() {

        int[] input = new int[]{0, 1000000, 1000000000};
        MaxEnd3 sut = new MaxEnd3();

        int[] output = sut.makeArray(input);

        Assert.assertArrayEquals(new int[]{1000000000, 1000000000, 1000000000}, output);
        Assert.assertEquals(3, output.length);

    }

    @Test
    public void return_correct_value_when_first_value_is_highest() {

        int[] input = new int[]{1000000000, 1000000, 0};
        MaxEnd3 sut = new MaxEnd3();

        int[] output = sut.makeArray(input);

        Assert.assertArrayEquals(new int[]{1000000000, 1000000000, 1000000000}, output);
        Assert.assertEquals(3, output.length);
    }

}
