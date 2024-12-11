package com.techelevator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.junit.Assert.assertThat;

public class WordCountTests {

    @Test
    public void happy_path_string_of_hellos_will_return_correct_count_for_each_unique_instance(){
        WordCount sut = new WordCount();

        Assertions.assertEquals(1, sut.getCount(new String[]{"Hello", "Ciao", "Bonjour", "Ciao", "Ciao"}).get("Hello"));
        Assertions.assertEquals(3, sut.getCount(new String[]{"Hello", "Ciao", "Bonjour", "Ciao", "Ciao"}).get("Ciao"));
        Assertions.assertEquals(1, sut.getCount(new String[]{"Hello", "Ciao", "Bonjour", "Ciao", "Ciao"}).get("Bonjour"));

    }

    @Test
    public void happy_path_string_of_sports_will_return_correct_count_for_each_unique_instance(){
        WordCount sut = new WordCount();

        Assertions.assertEquals(3, sut.getCount(new String[]{"Eagles", "Eagles", "Eagles", "Sixers", "Sixers", "Phillies", "Flyers", "Phillies"}).get("Eagles"));
        Assertions.assertEquals(2, sut.getCount(new String[]{"Eagles", "Eagles", "Eagles", "Sixers", "Sixers", "Phillies", "Flyers", "Phillies"}).get("Sixers"));
        Assertions.assertEquals(2, sut.getCount(new String[]{"Eagles", "Eagles", "Eagles", "Sixers", "Sixers", "Phillies", "Flyers", "Phillies"}).get("Phillies"));
        Assertions.assertEquals(1, sut.getCount(new String[]{"Eagles", "Eagles", "Eagles", "Sixers", "Sixers", "Phillies", "Flyers", "Phillies"}).get("Flyers"));

    }

    @Test
    public void empty_string_returns_empty_map(){
        WordCount sut = new WordCount();

        Assertions.assertNull(sut.getCount(new String[]{}).get(""));

    }

    @Test
    public void happy_path_string_of_hellos_will_return_correct_count_for_each_unique_instance_when_all_words_are_the_same(){
        WordCount sut = new WordCount();

        Assertions.assertEquals(5, sut.getCount(new String[]{"Ciao", "Ciao", "Ciao", "Ciao", "Ciao"}).get("Ciao"));

    }

    @Test
    public void happy_path_string_of_hellos_will_return_correct_count_when_all_words_are_the_same_but_misspelled(){
        WordCount sut = new WordCount();

        Assertions.assertEquals(2, sut.getCount(new String[]{"Ciao", "CIAO", "ciao", "CiAo", "Ciao"}).get("Ciao"));
        Assertions.assertEquals(1, sut.getCount(new String[]{"Ciao", "CIAO", "ciao", "CiAo", "Ciao"}).get("CIAO"));
        Assertions.assertEquals(1, sut.getCount(new String[]{"Ciao", "CIAO", "ciao", "CiAo", "Ciao"}).get("ciao"));
        Assertions.assertEquals(1, sut.getCount(new String[]{"Ciao", "CIAO", "ciao", "CiAo", "Ciao"}).get("CiAo"));

    }

    @Test
    public void happy_path_string_of_one_word_will_return_correct_count_of_that_word(){
        WordCount sut = new WordCount();

        Assertions.assertEquals(1, sut.getCount(new String[]{"Ciao"}).get("Ciao"));

    }

}
