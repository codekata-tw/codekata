package com.tw.tdd.codekata.guessnumber;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 5/8/12
 * Time: 10:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class GameStatus {
    private int guestCount;
    private String status;

    public GameStatus() {
        this.guestCount = 0;
        this.status = "Not started";
    }

    public void updateFrom(IGuessResult resultI) {
        guestCount++;
        status = calculateStatus(resultI);
    }

    private String calculateStatus(IGuessResult resultI) {
        if (resultI.allMatch() && guestCount <= 6)
            return "Win";
        if (!resultI.allMatch() && guestCount == 6)
            return "Lose";
        return "In progress";
    }

    public String current() {
        return status;
    }
}
