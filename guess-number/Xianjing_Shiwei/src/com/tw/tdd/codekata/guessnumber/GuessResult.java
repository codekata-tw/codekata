package com.tw.tdd.codekata.guessnumber;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 5/8/12
 * Time: 10:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class GuessResult implements IGuessResult {
    public int match;
    public int found;

    public int getFound() {
        return found;
    }

    public void addFound() {
        this.found++;
    }

    public int getMatch() {
        return match;
    }

    public void addMatch() {
        this.match++;
    }

    public String toString() {
        return getMatch() + "A" + getFound() + "B";
    }

    public boolean allMatch() {
        return getMatch() == 4;
    }
}
