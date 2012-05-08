package com.tw.tdd.codekata.guessnumber;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by IntelliJ IDEA.
 * User: twer
 * Date: 4/19/12
 * Time: 10:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class GuesserFacts {

    @Test
    public void should_return_0A0B_when_no_number_matches_and_no_number_finds() {
        Guesser guesser = new Guesser("1234");
        String result = guesser.verify("5678");
        assertEquals("0A0B", result);
    }


    @Test
    public void should_return_0A1B_when_no_number_matches_and_1_number_finds() {
        Guesser guesser = new Guesser("1234");
        String result = guesser.verify("5671");
        assertEquals("0A1B", result);
    }

    @Test
    public void should_return_0A4B_when_no_number_matches_and_4_number_finds() {
        Guesser guesser = new Guesser("1234");
        String result = guesser.verify("4321");
        assertEquals("0A4B", result);
    }

    @Test
    public void should_return_1A0B_when_1_number_matches_and_no_number_finds() {
        Guesser guesser = new Guesser("1234");
        String result = guesser.verify("1567");
        assertEquals("1A0B", result);
    }

    @Test
    public void should_return_2A0B_when_2_number_matches_and_no_number_finds() {
        Guesser guesser = new Guesser("1234");
        String result = guesser.verify("1267");
        assertEquals("2A0B", result);
    }

    @Test
    public void should_return_2A2B_when_2_number_matches_and_2_number_finds() {
        Guesser guesser = new Guesser("1234");
        String result = guesser.verify("1432");
        assertEquals("2A2B", result);
    }

    @Test
    public void should_return_4A0B_when_all_number_matches() {
        Guesser guesser = new Guesser("1234");
        String result = guesser.verify("1234");
        assertEquals("4A0B", result);
    }

    @Test
    public void should_succeed_when_guess_correct_number_for_1_time() {
        Guesser guesser = new Guesser("1234");
        guesser.verify("1234");
        assertEquals("Win", guesser.currentStatus());
    }

    @Test
    public void should_in_progress_when_guess_incorrect_number_for_1_time() {
        Guesser guesser = new Guesser("1234");
        guesser.verify("1567");
        assertEquals("In progress", guesser.currentStatus());
    }

    @Test
    public void should_lose_when_guess_incorrect_number_for_6_times() {
        Guesser guesser = new Guesser("1234");
        guesser.verify("1567");
        guesser.verify("1567");
        guesser.verify("1567");
        guesser.verify("1567");
        guesser.verify("1567");
        guesser.verify("1567");
        assertEquals("Lose", guesser.currentStatus());
    }
}
