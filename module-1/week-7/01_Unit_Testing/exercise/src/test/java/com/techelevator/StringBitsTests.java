package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class StringBitsTests {

    @Test
    public void null_string_returns_empty_string() {
        String input = null;
        StringBits sut = new StringBits();

        String output = sut.getBits(input);

        Assert.assertEquals("", output);
        Assert.assertEquals(0, output.length());
    }

    @Test
    public void empty_string_returns_empty_string() {
        String input = "";
        StringBits sut = new StringBits();

        String output = sut.getBits(input);

        Assert.assertEquals("", output);
        Assert.assertEquals(0, output.length());

    }

    @Test
    public void one_char_string_returns_same_string() {
        String input = "a";
        StringBits sut = new StringBits();

        String output = sut.getBits(input);

        Assert.assertEquals("a", output);
        Assert.assertEquals(1, output.length());

    }

    @Test
    public void two_char_string_returns_one_char_string() {
        String input = "ab";
        StringBits sut = new StringBits();

        String output = sut.getBits(input);

        Assert.assertEquals("a", output);
        Assert.assertEquals(1, output.length());

    }

    @Test
    public void happy_path_test_1() {
        String input = "Hello";
        StringBits sut = new StringBits();

        String output = sut.getBits(input);

        Assert.assertEquals("Hlo", output);
    }

    @Test
    public void happy_path_test_2() {
        String input = "Philadelphia Eagles";
        StringBits sut = new StringBits();

        String output = sut.getBits(input);

        Assert.assertEquals("Piaepi als", output);
    }

    @Test
    public void happy_path_test_3() {
        String input = "h€ll0 w0r1d!!";
        StringBits sut = new StringBits();

        String output = sut.getBits(input);

        Assert.assertEquals("hl0wrd!", output);
    }

}
