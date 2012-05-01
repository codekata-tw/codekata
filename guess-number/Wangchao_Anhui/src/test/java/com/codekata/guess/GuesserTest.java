package com.codekata.guess;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GuesserTest {

    private Guesser guesser;

    @Before
    public void setUp() {
        List<Integer> answer = Lists.newArrayList(1, 2, 3, 4);
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
    public void should_return_0a1b_when_1_partially_match(){
        assertThat(guesser.guess("5367"),is("0a1b"));
    }

    @Test
    public void should_return_3a0b_when_3_exactly_match(){
        assertThat(guesser.guess("5234"),is("3a0b"));
    }

    @Test
    public void should_return_0a3b_when_3_partially_match(){
        assertThat(guesser.guess("2345"),is("0a3b"));
    }

    @Test
    public void should_return_3a1b_when_3_exactly_match_and_1_partially_match(){
        assertThat(guesser.guess("1432"),is("2a2b"));
    }


}
