package com.tw.tdd.codekata.guessnumber;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 5/2/12
 * Time: 12:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class AnswerGenerator implements IAnswerGenerator {

    private final IRandomNumberProducer numberProducer;

    public AnswerGenerator(IRandomNumberProducer producer) {
        numberProducer = producer;
    }

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
        Integer currentNumber = numberProducer.produce();
        while(result.contains(currentNumber.toString())) {
            currentNumber = numberProducer.produce();
        }
        return currentNumber;
    }

}
