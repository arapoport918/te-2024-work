package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class CigarPartyTests {

    //weekend cases
    @Test
    public void cigar_party_should_be_true_when_cigars_is_40_when_its_the_weekend() {

        int input = 40;
        boolean test = true;
        CigarParty sut = new CigarParty();

        boolean output = sut.haveParty(input, test);

        Assert.assertTrue(output);
    }

    //when cigars is 39
    @Test
    public void cigar_party_should_be_false_when_cigars_is_39_when_its_the_weekend() {

        int input = 39;
        boolean test = true;
        CigarParty sut = new CigarParty();

        boolean output = sut.haveParty(input, test);

        Assert.assertFalse(output);

    }

    //when cigars is 60
    @Test
    public void cigar_party_should_be_true_when_cigars_is_60_when_its_the_weekend() {

        int input = 60;
        boolean test = true;
        CigarParty sut = new CigarParty();

        boolean output = sut.haveParty(input, test);

        Assert.assertTrue(output);

    }

    @Test
    public void cigar_party_should_be_true_when_cigars_is_61_when_its_the_weekend() {

        int input = 61;
        boolean test = true;
        CigarParty sut = new CigarParty();

        boolean output = sut.haveParty(input, test);

        Assert.assertTrue(output);

    }

    @Test
    public void cigar_party_should_be_true_when_cigars_is_50_when_its_the_weekend() {

        int input = 50;
        boolean test = true;
        CigarParty sut = new CigarParty();

        boolean output = sut.haveParty(input, test);

        Assert.assertTrue(output);

    }

    @Test
    public void cigar_party_should_be_true_when_cigars_is_500_when_its_the_weekend() {

        int input = 500;
        boolean test = true;
        CigarParty sut = new CigarParty();

        boolean output = sut.haveParty(input, test);

        Assert.assertTrue(output);

    }

    @Test
    public void cigar_party_should_be_false_when_cigars_is_0_when_its_the_weekend() {

        int input = 0;
        boolean test = true;
        CigarParty sut = new CigarParty();

        boolean output = sut.haveParty(input, test);

        Assert.assertFalse(output);

    }

    //not weekend test cases
    @Test
    public void cigar_party_should_be_true_when_cigars_is_40_when_its_not_the_weekend() {

        int input = 40;
        boolean test = false;
        CigarParty sut = new CigarParty();

        boolean output = sut.haveParty(input, test);

        Assert.assertTrue(output);
    }

    //when cigars is 39
    @Test
    public void cigar_party_should_be_false_when_cigars_is_39_when_its_not_the_weekend() {

        int input = 39;
        boolean test = false;
        CigarParty sut = new CigarParty();

        boolean output = sut.haveParty(input, test);

        Assert.assertFalse(output);

    }

    //when cigars is 60
    @Test
    public void cigar_party_should_be_true_when_cigars_is_60_when_its_not_the_weekend() {

        int input = 60;
        boolean test = false;
        CigarParty sut = new CigarParty();

        boolean output = sut.haveParty(input, test);

        Assert.assertTrue(output);

    }

    @Test
    public void cigar_party_should_be_true_when_cigars_is_61_when_its_not_the_weekend() {

        int input = 61;
        boolean test = false;
        CigarParty sut = new CigarParty();

        boolean output = sut.haveParty(input, test);

        Assert.assertFalse(output);

    }

    @Test
    public void cigar_party_should_be_true_when_cigars_is_50_when_its_not_the_weekend() {

        int input = 50;
        boolean test = false;
        CigarParty sut = new CigarParty();

        boolean output = sut.haveParty(input, test);

        Assert.assertTrue(output);

    }

    @Test
    public void cigar_party_should_be_true_when_cigars_is_500_when_its_not_the_weekend() {

        int input = 500;
        boolean test = false;
        CigarParty sut = new CigarParty();

        boolean output = sut.haveParty(input, test);

        Assert.assertFalse(output);

    }


}
