package com.codekata.guess;

import org.junit.Test;

import java.util.ArrayList;

public class GameTest {
    @Test
    public void should_generate_number_and_guess(){
        GuessNumber guessNumber = new GuessNumber();
        ArrayList<Object> number = guessNumber.generate();

    }
}
