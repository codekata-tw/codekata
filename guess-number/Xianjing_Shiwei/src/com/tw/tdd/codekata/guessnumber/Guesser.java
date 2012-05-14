package com.tw.tdd.codekata.guessnumber;

/**
 * Created by IntelliJ IDEA.
 * User: swzhou
 * Date: 4/19/12
 * Time: 10:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class Guesser {
    private String answer;
    private GameStatus status;

    public Guesser(String answer) {
        this.answer = answer;
        status = new GameStatus();
    }

    public String verify(String guess) {
        IGuessResult result = getResult(guess);
        status.updateFrom(result);
        return result.toString();
    }

    private IGuessResult getResult(String guess) {
        GuessResult result = new GuessResult();
        char[] guessNumbers = guess.toCharArray();
        for (int i = 0; i < guessNumbers.length; i++) {
            if (answer.indexOf(guessNumbers[i]) == i) {
                result.addMatch();
            } else if (answer.indexOf(guessNumbers[i]) >= 0) {
                result.addFound();
            }
        }
        return result;
    }

    public String currentStatus() {
        return status.current();
    }

    public boolean finish() {
        return status.finish();
    }
    
    public boolean win() {
        return status.win();
    }
    
    public boolean lose() {
        return status.lose();
    }
}
