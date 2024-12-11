package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class QuizMakerTest {

    @Test
    public void returns_right_when_given_right_answer() {
        String input = "The Eagles are an NFL team from which city?|New York|Philadelphia*|Washington|Los Angeles";
        QuizQuestion sut = new QuizQuestion(input);

        String output = sut.findCorrectAnswer(input);

        Assert.assertEquals("2", output);
    }

}
