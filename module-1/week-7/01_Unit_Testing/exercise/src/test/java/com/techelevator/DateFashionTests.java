package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class DateFashionTests {

    //8 or more is yes unless one of the values is 2 or less then no
    //anything else is a 1

    @Test
    public void you_and_date_are_10s_should_result_in_yes() {

        int input1 = 10;
        int input2 = 10;
        DateFashion sut = new DateFashion();

        int output = sut.getATable(input1, input2);

        Assert.assertEquals(2, output);

    }
    @Test
    public void you_and_date_are_1s_should_result_in_no() {

        int input1 = 1;
        int input2 = 1;
        DateFashion sut = new DateFashion();

        int output = sut.getATable(input1, input2);

        Assert.assertEquals(0, output);

    }

    @Test
    public void you_are_8_and_date_is_6_should_result_in_yes() {

        int input1 = 8;
        int input2 = 6;
        DateFashion sut = new DateFashion();

        int output = sut.getATable(input1, input2);

        Assert.assertEquals(2, output);

    }

    @Test
    public void you_are_6_and_date_is_8_should_result_in_yes() {

        int input1 = 6;
        int input2 = 8;
        DateFashion sut = new DateFashion();

        int output = sut.getATable(input1, input2);

        Assert.assertEquals(2, output);

    }

    @Test
    public void you_are_8_and_date_is_2_should_result_in_no() {

        int input1 = 8;
        int input2 = 2;
        DateFashion sut = new DateFashion();

        int output = sut.getATable(input1, input2);

        Assert.assertEquals(0, output);

    }

    @Test
    public void you_are_2_and_date_is_8_should_result_in_no() {

        int input1 = 2;
        int input2 = 8;
        DateFashion sut = new DateFashion();

        int output = sut.getATable(input1, input2);

        Assert.assertEquals(0, output);

    }

    @Test
    public void you_are_9_and_date_is_1_should_result_in_no() {

        int input1 = 9;
        int input2 = 1;
        DateFashion sut = new DateFashion();

        int output = sut.getATable(input1, input2);

        Assert.assertEquals(0, output);

    }

    @Test
    public void you_are_1_and_date_is_1_should_result_in_no() {

        int input1 = 1;
        int input2 = 9;
        DateFashion sut = new DateFashion();

        int output = sut.getATable(input1, input2);

        Assert.assertEquals(0, output);

    }

    @Test
    public void you_are_2_and_date_is_2_should_result_in_no() {

        int input1 = 2;
        int input2 = 2;
        DateFashion sut = new DateFashion();

        int output = sut.getATable(input1, input2);

        Assert.assertEquals(0, output);

    }

    @Test
    public void you_are_5_and_date_is_5_should_result_in_maybe() {

        int input1 = 5;
        int input2 = 5;
        DateFashion sut = new DateFashion();

        int output = sut.getATable(input1, input2);

        Assert.assertEquals(1, output);

    }

    @Test
    public void you_are_7_and_date_is_7_should_result_in_maybe() {

        int input1 = 7;
        int input2 = 7;
        DateFashion sut = new DateFashion();

        int output = sut.getATable(input1, input2);

        Assert.assertEquals(1, output);

    }

    @Test
    public void you_are_3_and_date_is_4_should_result_in_maybe() {

        int input1 = 3;
        int input2 = 4;
        DateFashion sut = new DateFashion();

        int output = sut.getATable(input1, input2);

        Assert.assertEquals(1, output);

    }

    @Test
    public void you_are_3_and_date_is_6_should_result_in_maybe() {

        int input1 = 3;
        int input2 = 6;
        DateFashion sut = new DateFashion();

        int output = sut.getATable(input1, input2);

        Assert.assertEquals(1, output);

    }


}
