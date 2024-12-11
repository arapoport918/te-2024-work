package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class FrontTimesTests {

    //string with one char
    //string wih two chars
    //string exactly three chars
    //long string
    @Test
    public void null_string_should_return_null() {

        String input = null;
        int num = 4;
        FrontTimes sut = new FrontTimes();

        String output = sut.generateString(input, num);

        Assert.assertEquals("", output);
    }
    @Test
    public void empty_string_should_return_empty_string() {

        String input = "";
        int num = 4;
        FrontTimes sut = new FrontTimes();

        String output = sut.generateString(input, num);

        Assert.assertEquals("", output);
    }

    @Test
    public void one_char_string_should_return_one_char_repeated_n_times() {

        String input = "a";
        int num = 4;
        FrontTimes sut = new FrontTimes();

        String output = sut.generateString(input, num);

        Assert.assertEquals("aaaa", output);
    }

    @Test
    public void two_char_string_should_return_two_chars_repeated_n_times() {

        String input = "Xy";
        int num = 4;
        FrontTimes sut = new FrontTimes();

        String output = sut.generateString(input, num);

        Assert.assertEquals("XyXyXyXy", output);
    }

    @Test
    public void three_char_string_should_return_three_chars_repeated_n_times() {

        String input = "Abc";
        int num = 4;
        FrontTimes sut = new FrontTimes();

        String output = sut.generateString(input, num);

        Assert.assertEquals("AbcAbcAbcAbc", output);
    }

    @Test
    public void more_than_three_char_string_should_return_three_chars_repeated_n_times() {

        String input = "FrontTimes";
        int num = 4;
        FrontTimes sut = new FrontTimes();

        String output = sut.generateString(input, num);

        Assert.assertEquals("FroFroFroFro", output);
    }

    @Test
    public void more_than_three_char_string_should_return_three_chars_repeated_n_times_includes_a_space() {

        String input = "J a v a";
        int num = 4;
        FrontTimes sut = new FrontTimes();

        String output = sut.generateString(input, num);

        Assert.assertEquals("J aJ aJ aJ a", output);
    }

    @Test
    public void string_of_spaces_when_string_is_just_spaces() {

        String input = "            ";
        int num = 4;
        FrontTimes sut = new FrontTimes();

        String output = sut.generateString(input, num);

        Assert.assertEquals("            ", output);
    }

    @Test
    public void string_of_special_characters_works() {

        String input = "$.#,";
        int num = 4;
        FrontTimes sut = new FrontTimes();

        String output = sut.generateString(input, num);

        Assert.assertEquals("$.#$.#$.#$.#", output);
    }

    @Test
    public void string_of_number_characters_works() {

        String input = "215";
        int num = 4;
        FrontTimes sut = new FrontTimes();

        String output = sut.generateString(input, num);

        Assert.assertEquals("215215215215", output);
    }

    @Test
    public void string_of_characters_works_when_int_is_0() {

        String input = "Chocolate";
        int num = 0;
        FrontTimes sut = new FrontTimes();

        String output = sut.generateString(input, num);

        Assert.assertEquals("", output);
    }

    @Test
    public void string_of_characters_works_when_int_is_1() {

        String input = "Chocolate";
        int num = 1;
        FrontTimes sut = new FrontTimes();

        String output = sut.generateString(input, num);

        Assert.assertEquals("Cho", output);
    }

    @Test
    public void string_of_characters_works_when_int_is_20() {

        String input = "Chocolate";
        int num = 20;
        FrontTimes sut = new FrontTimes();

        String output = sut.generateString(input, num);

        Assert.assertEquals("ChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoCho", output);
    }

    @Test
    public void string_of_characters_works_when_int_is_100() {

        String input = "Chocolate";
        int num = 100;
        FrontTimes sut = new FrontTimes();

        String output = sut.generateString(input, num);

        Assert.assertEquals("ChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoChoCho", output);
    }

}
