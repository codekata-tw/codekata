package com.codekata.guess;

public class Outputer {
    private static final String FAILURE_MSG = "you guessed more than 6 times, failed!";
    private static final String SUCCESS_MSG = "good play!";

    private final GuessResult guessResult;
    private final int numOfGuess;

    public Outputer(GuessResult guessResult, int numOfGuess) {
        this.guessResult = guessResult;
        this.numOfGuess = numOfGuess;
    }

    public String output() {
        System.out.println(getResult());
        return getResult();
    }

    private String getResult() {
        if (numOfGuess < 6) {
            return guessResultMsg(guessResult);
        }
        return FAILURE_MSG;
    }

    private String guessResultMsg(GuessResult result) {
        if(result.getExactlyMatch() == 4){
            return SUCCESS_MSG;
        }
        return result.getExactlyMatch() +  "a" + result.getPartMatch() + "b";
    }
}
