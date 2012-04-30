package com.codekata.guess;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GuesserTest {

    private Guesser guesser;

    @Before
    public void setUp() {
        List<Integer> answer = new ArrayList<Integer>();
        answer.add(1);
        answer.add(2);
        answer.add(3);
        answer.add(4);

        guesser = new Guesser(answer);
    }

    @Test
    public void should_return_4a0b_when_number_and_position_all_match(){
        assertThat(guesser.guess("1234"), is("4a0b"));
    }

    @Test
    public void should_return_0a0b_when_no_match(){
        assertThat(guesser.guess("5678"), is("0a0b"));
    }

    @Test
    public void should_return_1a0b_when_1_exactly_match(){
        assertThat(guesser.guess("1890"),is("1a0b"));
    }
    @Test
    public void should_return_0a1b_when_1_patially_match(){
        assertThat(guesser.guess("5367"),is("0a1b"));
    }

    @Test
    public void should_return_3a0b_when_3_exactly_match(){
        assertThat(guesser.guess("5234"),is("3a0b"));
    }
}
