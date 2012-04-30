package com.tw.tdd.codekata.guessnumber;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
}
