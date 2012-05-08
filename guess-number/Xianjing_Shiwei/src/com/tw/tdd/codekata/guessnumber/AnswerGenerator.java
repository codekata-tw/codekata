package com.tw.tdd.codekata.guessnumber;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 5/2/12
 * Time: 12:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class AnswerGenerator {


    public String generate() {
        String result = "";
        for(int i=0;i<4;i++) {
            Integer currentNumber = generateNextNumber(result);
            result += currentNumber;
        }
        System.out.println(result);
        return result;
    }

    private Integer generateNextNumber(String result) {
        Integer currentNumber = getRandomNumber();
        while(result.contains(currentNumber.toString())) {
            currentNumber = getRandomNumber();
        }
        return currentNumber;
    }

    private Integer getRandomNumber() {
        return new Integer((int)(Math.random()*10));
    }
}
