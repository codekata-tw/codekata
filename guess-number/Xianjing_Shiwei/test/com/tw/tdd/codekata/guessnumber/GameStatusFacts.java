package com.tw.tdd.codekata.guessnumber;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 5/8/12
 * Time: 11:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class GameStatusFacts {


    private GameStatus gameStatus;

    @Before
    public void setUp() {
        gameStatus = new GameStatus();
    }

    @Test
    public void should_not_started_when_no_guess_verified() {
        assertEquals("Not started", gameStatus.current());
    }

    @Test
    public void should_in_progress_when_guess_incorrect_number_for_1_time() {
        gameStatus.updateFrom(new NoMatchNoFoundResult());
        assertEquals("In progress", gameStatus.current());
    }

    @Test
    public void should_win_when_guess_correct_number_for_1_time() {
        gameStatus.updateFrom(new AllMatchResult());
        assertEquals("Win", gameStatus.current());
    }

    @Test
    public void should_lose_when_guess_incorrect_number_for_6_times() {
        IGuessResult notAllMatchResult = new NoMatchNoFoundResult();
        gameStatus.updateFrom(notAllMatchResult);
        gameStatus.updateFrom(notAllMatchResult);
        gameStatus.updateFrom(notAllMatchResult);
        gameStatus.updateFrom(notAllMatchResult);
        gameStatus.updateFrom(notAllMatchResult);
        gameStatus.updateFrom(notAllMatchResult);
        assertEquals("Lose", gameStatus.current());
    }

    private class AllMatchResult implements IGuessResult {
        public int getFound() {
            return 0;
        }

        public int getMatch() {
            return 4;
        }

        public boolean allMatch() {
            return true;
        }
    }

    private class NoMatchNoFoundResult implements IGuessResult {
        public int getFound() {
            return 0;
        }

        public int getMatch() {
            return 0;
        }

        public boolean allMatch() {
            return false;
        }
    }
}
