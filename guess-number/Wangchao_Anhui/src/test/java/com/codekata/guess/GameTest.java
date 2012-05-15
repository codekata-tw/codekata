package com.codekata.guess;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameTest {

    private Game game;
    private List<Integer> answer;

    @Before
    public void setUp() throws Exception {
        answer = Lists.newArrayList(1, 2, 3, 4);
        game = new Game(answer);
    }

    @Test
    public void should_return_guessed_result_when_guess_is_wrong() {
        List<Integer> guessNumbers = Lists.newArrayList(2, 3, 4, 5);
        game.setNumberSource(createNumberSource(guessNumbers));

        String result = game.guess();

        assertThat(result, is("0a3b"));
    }

    @Test
    public void should_show_success_message_when_guess_correctly() {
        game.setNumberSource(createNumberSource(answer));

        String result = game.guess();

        assertThat(result, is("good play!"));
    }

    @Test
    public void should_show_failure_message_when_guess_count_reach_6() {
        List<Integer> numbers = Lists.newArrayList(5, 6, 7, 8);
        game.setNumberSource(createNumberSource(numbers));

        String result = guessSixTimesWrong();

        assertThat(game.getNumOfGuess(), is(6));
        assertThat(result, is("you guessed more than 6 times, failed!") );
    }

    private String guessSixTimesWrong() {
        int count = 6;
        String result = "";
        while(count>0){
            result = game.guess();
            count--;
        }
        return result;
    }


    private NumberSource createNumberSource(List<Integer> numbers) {
        NumberSource source = mock(NumberSource.class);
        when(source.getNumbers()).thenReturn(numbers);
        return source;
    }
}
