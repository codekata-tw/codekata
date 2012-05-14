package com.tw.tdd.codekata.guessnumber;

/**
 * Created by IntelliJ IDEA.
 * User: swzhou
 * Date: 12-5-14
 * Time: 上午7:49
 * To change this template use File | Settings | File Templates.
 */
public class Game {
    private AnswerGenerator answerGenerator;
    private InputCollector inputCollector;
    private OutputPrinter outputPrinter;
    private final Validator validator;

    public Game(AnswerGenerator answerGenerator, InputCollector inputCollector, OutputPrinter outputPrinter) {
        this.answerGenerator = answerGenerator;
        this.inputCollector = inputCollector;
        this.outputPrinter = outputPrinter;
        validator = new Validator();
    }

    public void start() {
        String answer = answerGenerator.generate();
        Guesser guesser = new Guesser(answer);
        while (!guesser.finish()) {
            String guess = inputCollector.guess();
            if (!validator.isValid(guess)) {
                outputPrinter.print("invalid input");
                continue;
            }
            String result = guesser.verify(guess);
            outputPrinter.print(result);
        }
        outputPrinter.print(guesser.currentStatus());
    }
}
