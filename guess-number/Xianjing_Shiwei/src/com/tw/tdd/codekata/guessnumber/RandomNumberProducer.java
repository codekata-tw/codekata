package com.tw.tdd.codekata.guessnumber;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 5/8/12
 * Time: 7:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class RandomNumberProducer implements IRandomNumberProducer {
    public Integer produce() {
        return new Integer((int)(Math.random()*10));
    }
}
