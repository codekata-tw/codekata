package com.tw.tdd.codekata.guessnumber;

/**
 * Created by IntelliJ IDEA.
 * User: swzhou
 * Date: 4/19/12
 * Time: 10:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class Guesser {
    private String secretNumbers;
    private String status;
    private int guestTimes;

    public Guesser(String secretNumbers) {
        this.secretNumbers = secretNumbers;
    }

    public String verify(String guess) {
        guestTimes ++;
        int flagB = 0;
        int flagA = 0;
        char[] guessNumbers = guess.toCharArray();
        for (int i = 0; i < guessNumbers.length; i++) {
            if (secretNumbers.indexOf(guessNumbers[i]) == i) {
                flagA++;
            } else if (secretNumbers.indexOf(guessNumbers[i]) >= 0) {
                flagB++;
            }
        }
        if (flagA != 4) {
            if(guestTimes < 6) {
                status = "In progress";
            } else {
                status = "Lose";
            }
        }
        else
            status = "Win";
            return flagA + "A" + flagB + "B";

    }

    public String getStatus() {

        return status;
    }
}
