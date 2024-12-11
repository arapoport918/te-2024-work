package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class NonStartTests {

    @Test
    public void strings_that_are_null_should_return_null() {
        String input1 = null;
        String input2 = null;
        NonStart sut = new NonStart();

        String output = sut.getPartialString(input1, input2);

        Assert.assertEquals("", output);

    }

    @Test
    public void strings_that_are_empty_should_return_empty_string() {
        String input1 = "";
        String input2 = "";
        NonStart sut = new NonStart();

        String output = sut.getPartialString(input1, input2);

        Assert.assertEquals("", output);

    }

    @Test
    public void strings_that_are_1_char_long_should_return_empty_string() {
        String input1 = "a";
        String input2 = "b";
        NonStart sut = new NonStart();

        String output = sut.getPartialString(input1, input2);

        Assert.assertEquals("", output);

    }

    @Test
    public void string_with_2_chars_and_string_with_1_char_should_return_1_char_from_longer_string() {
        String input1 = "ab";
        String input2 = "b";
        NonStart sut = new NonStart();

        String output = sut.getPartialString(input1, input2);

        Assert.assertEquals("b", output);

    }

    @Test
    public void strings_with_2_chars_should_return_1_char_from_each_string() {
        String input1 = "ab";
        String input2 = "ab";
        NonStart sut = new NonStart();

        String output = sut.getPartialString(input1, input2);

        Assert.assertEquals("bb", output);

    }

    @Test
    public void strings_with_3_chars_should_return_2_chars_from_each_string() {
        String input1 = "cat";
        String input2 = "hat";
        NonStart sut = new NonStart();

        String output = sut.getPartialString(input1, input2);

        Assert.assertEquals("atat", output);

    }

    @Test
    public void given_strings_should_return_all_but_first_char_from_each_string() {
        String input1 = "Hello";
        String input2 = "There";
        NonStart sut = new NonStart();

        String output = sut.getPartialString(input1, input2);

        Assert.assertEquals("ellohere", output);

    }

    @Test
    public void given_strings_should_return_all_but_first_char_from_each_string_varying_string_lengths() {
        String input1 = "Go";
        String input2 = "Birds";
        NonStart sut = new NonStart();

        String output = sut.getPartialString(input1, input2);

        Assert.assertEquals("oirds", output);

    }

    @Test
    public void null_string_and_string_of_several_char_length_should_return_all_but_first_char_of_longer() {
        String input1 = null;
        String input2 = "Philly";
        NonStart sut = new NonStart();

        String output = sut.getPartialString(input1, input2);

        Assert.assertEquals("hilly", output);

    }

    @Test
    public void string_of_numbers_spaces_and_symbols_should_return_all_but_first_char_of_longer() {
        String input1 = "$15.00";
        String input2 = "h€ll0 w0r1d";
        NonStart sut = new NonStart();

        String output = sut.getPartialString(input1, input2);

        Assert.assertEquals("15.00€ll0 w0r1d", output);

    }
}
