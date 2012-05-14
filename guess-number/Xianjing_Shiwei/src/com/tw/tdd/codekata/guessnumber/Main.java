package com.tw.tdd.codekata.guessnumber;

/**
 * Created by IntelliJ IDEA.
 * User: swzhou
 * Date: 12-5-14
 * Time: 下午9:37
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    
    public static void main(String[] args) {
        AnswerGenerator answerGenerator = new AnswerGenerator(new RandomNumberProducer());
        InputCollector inputCollector = new InputCollector();
        OutputPrinter outputPrinter = new OutputPrinter();
        Game game = new Game(answerGenerator, inputCollector, outputPrinter);
        game.start();
    }
}
