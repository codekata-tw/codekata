package com.tw.tdd.codekata.guessnumber;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 5/8/12
 * Time: 11:15 PM
 * To change this template use File | Settings | File Templates.
 */
public interface IGuessResult {
    int getFound();

    int getMatch();

    boolean allMatch();
}
