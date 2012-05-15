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
    public void should_return_4_exact_match_0_part_match_when_all_value_and_position_both_match(){
        List<Integer> guess = Lists.newArrayList(1, 2, 3, 4);

        assertThat(guesser.guess(guess).getExactlyMatch(), is(4));
        assertThat(guesser.guess(guess).getPartMatch(), is(0));
    }

    @Test
    public void should_return_0_exact_and_part_match_when_no_match() {
        List<Integer> guess = Lists.newArrayList(5, 6, 7, 8);
        assertThat(guesser.guess(guess).getExactlyMatch(), is(0));
        assertThat(guesser.guess(guess).getPartMatch(), is(0));
    }

    @Test
    public void should_return_1_exact_and_0_part_match_when_1_value_and_position_match() {
        List<Integer> guess = Lists.newArrayList(1, 8, 9, 0);
        assertThat(guesser.guess(guess).getExactlyMatch(), is(1));
        assertThat(guesser.guess(guess).getPartMatch(), is(0));
    }

    @Test
    public void should_return_0_exact_and_1_part_when_1_value_match_position_not_match() {
        List<Integer> guess = Lists.newArrayList(5, 3, 6, 7);
        assertThat(guesser.guess(guess).getExactlyMatch(), is(0));
        assertThat(guesser.guess(guess).getPartMatch(), is(1));
    }

    @Test
    public void should_return_3_exact_and_0_part_when_3_value_and_position_match() {
        List<Integer> guess = Lists.newArrayList(5, 2, 3, 4);
        assertThat(guesser.guess(guess).getExactlyMatch(), is(3));
        assertThat(guesser.guess(guess).getPartMatch(), is(0));
    }

    @Test
    public void should_return_0_exact_and_3_part_when_3_value_match_position_not_match() {
        List<Integer> guess = Lists.newArrayList(2, 3, 4, 5);
        assertThat(guesser.guess(guess).getExactlyMatch(), is(0));
        assertThat(guesser.guess(guess).getPartMatch(), is(3));
    }

    @Test
    public void should_return_2_exact_and_2_part_when_2_number_match_all_2_number_match_value() {
        List<Integer> guess = Lists.newArrayList(1, 4, 3, 2);
        assertThat(guesser.guess(guess).getExactlyMatch(), is(2));
        assertThat(guesser.guess(guess).getPartMatch(), is(2));
    }


}
