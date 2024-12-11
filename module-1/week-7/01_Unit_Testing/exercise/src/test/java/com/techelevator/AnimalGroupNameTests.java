package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class AnimalGroupNameTests {

    //proper case returns correct animal group
    @Test
    public void animal_name_returns_the_correct_group_when_in_proper_case() {

        String input = "Elephant";
        AnimalGroupName sut = new AnimalGroupName();

        String output = sut.getHerd(input);

        Assert.assertEquals("Herd", output);

    }


    //all uppercase returns correct animal group
    @Test
    public void animal_name_returns_the_correct_group_when_in_uppercase() {

        String input = "ELEPHANT";
        AnimalGroupName sut = new AnimalGroupName();

        String output = sut.getHerd(input);

        Assert.assertEquals("Herd", output);

    }
    //all lowercase returns correct animal group
    @Test
    public void animal_name_returns_the_correct_group_when_in_lowercase() {

        String input = "elephant";
        AnimalGroupName sut = new AnimalGroupName();

        String output = sut.getHerd(input);

        Assert.assertEquals("Herd", output);

    }

    @Test
    public void animal_name_returns_the_correct_group_when_in_mix_of_lower_and_uppercase() {

        String input = "ElEpHaNt";
        AnimalGroupName sut = new AnimalGroupName();

        String output = sut.getHerd(input);

        Assert.assertEquals("Herd", output);

    }

    //name of animal not found
    @Test
    public void animal_name_is_not_found_on_list() {

        String input = "walrus";
        AnimalGroupName sut = new AnimalGroupName();

        String output = sut.getHerd(input);

        Assert.assertEquals("unknown", output);

    }

    //name of animal is empty
    @Test
    public void animal_name_is_empty() {

        String input = "";
        AnimalGroupName sut = new AnimalGroupName();

        String output = sut.getHerd(input);

        Assert.assertEquals("unknown", output);

    }

    //name of animal is null
    @Test
    public void animal_name_is_null() {

        String input = null;
        AnimalGroupName sut = new AnimalGroupName();

        String output = sut.getHerd(input);

        Assert.assertEquals("unknown", output);

    }

    @Test
    public void animal_name_returns_unknown_when_animal_name_in_list_is_misspelled() {

        String input = "Elephan";
        AnimalGroupName sut = new AnimalGroupName();

        String output = sut.getHerd(input);

        Assert.assertEquals("unknown", output);

    }

    @Test
    public void animal_name_returns_pat_when_given_flamingo() {

        String input = "Flamingo";
        AnimalGroupName sut = new AnimalGroupName();

        String output = sut.getHerd(input);

        Assert.assertEquals("Pat", output);
    }

}
