package com.codekata.guess;

import java.util.List;

public class Game {

    private Guesser guesser;

    private NumberSource numberSource = new NumberSource();
    private int numOfGuess = 0;

    public Game(List<Integer> answer) {
        this.guesser = new Guesser(answer);
    }

    public void setNumberSource(NumberSource source) {
        this.numberSource = source;
    }

    public String guess() {
        numOfGuess += 1;
        GuessResult guessResult = guesser.guess(numberSource.getNumbers());
        Outputer outputer = new Outputer(guessResult, numOfGuess);
        return outputer.output();
    }

    public int getNumOfGuess() {
        return numOfGuess;
    }

    public void run() {

        while (numOfGuess <= 6) {
            guess();
        }
    }
}
