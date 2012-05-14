package com.tw.tdd.codekata.guessnumber;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 5/8/12
 * Time: 7:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class GameFacts {

    @Test
    public void should_play_game_and_win() {
        Mockery context = givenMockContext();
        final AnswerGenerator answerGenerator = context.mock(AnswerGenerator.class);
        final InputCollector inputCollector = context.mock(InputCollector.class);
        final OutputPrinter outputPrinter = context.mock(OutputPrinter.class);
        context.checking(new Expectations() {
            {
                one(answerGenerator).generate();
                will(returnValue("1234"));
            }

            {
                one(inputCollector).guess();
                will(returnValue("1567"));
                oneOf(outputPrinter).print(with(equal("1A0B")));
            }

            {
                one(inputCollector).guess();
                will(returnValue("1527"));
                oneOf(outputPrinter).print(with(equal("1A1B")));
            }

            {
                one(inputCollector).guess();
                will(returnValue("1234"));
                oneOf(outputPrinter).print(with(equal("4A0B")));
                oneOf(outputPrinter).print(with(equal("Win")));
            }
        });

        startGameAndVerify(context, answerGenerator, inputCollector, outputPrinter);
    }

    @Test
    public void should_play_game_and_lose() {
        Mockery context = givenMockContext();
        final AnswerGenerator answerGenerator = context.mock(AnswerGenerator.class);
        final InputCollector inputCollector = context.mock(InputCollector.class);
        final OutputPrinter outputPrinter = context.mock(OutputPrinter.class);
        context.checking(new Expectations() {
            {
                one(answerGenerator).generate();
                will(returnValue("1234"));
            }

            {
                one(inputCollector).guess();
                will(returnValue("0156"));
                oneOf(outputPrinter).print(with(equal("0A1B")));
            }

            {
                one(inputCollector).guess();
                will(returnValue("0156"));
                oneOf(outputPrinter).print(with(equal("0A1B")));
            }

            {
                one(inputCollector).guess();
                will(returnValue("0156"));
                oneOf(outputPrinter).print(with(equal("0A1B")));
            }

            {
                one(inputCollector).guess();
                will(returnValue("0156"));
                oneOf(outputPrinter).print(with(equal("0A1B")));
            }

            {
                one(inputCollector).guess();
                will(returnValue("0156"));
                oneOf(outputPrinter).print(with(equal("0A1B")));
            }

            {
                one(inputCollector).guess();
                will(returnValue("0156"));
                oneOf(outputPrinter).print(with(equal("0A1B")));
                oneOf(outputPrinter).print(with(equal("Lose, answer is: " + 1234)));
            }
        });

        startGameAndVerify(context, answerGenerator, inputCollector, outputPrinter);
    }

    @Test
    public void should_play_game_and_validate_invalid_input() {
        Mockery context = givenMockContext();
        final AnswerGenerator answerGenerator = context.mock(AnswerGenerator.class);
        final InputCollector inputCollector = context.mock(InputCollector.class);
        final OutputPrinter outputPrinter = context.mock(OutputPrinter.class);
        context.checking(new Expectations() {
            {
                one(answerGenerator).generate();
                will(returnValue("1234"));
            }

            {
                one(inputCollector).guess();
                will(returnValue("A123"));
                oneOf(outputPrinter).print(with(equal("invalid input")));
            }

            {
                one(inputCollector).guess();
                will(returnValue("1234"));
                oneOf(outputPrinter).print(with(equal("4A0B")));
                oneOf(outputPrinter).print(with(equal("Win")));
            }
        });

        startGameAndVerify(context, answerGenerator, inputCollector, outputPrinter);
    }

    private Mockery givenMockContext() {
        return new JUnit4Mockery() {
            {
                setImposteriser(ClassImposteriser.INSTANCE);
            }
        };
    }

    private void startGameAndVerify(Mockery context, AnswerGenerator answerGenerator, InputCollector inputCollector, OutputPrinter outputPrinter) {
        Game game = new Game(answerGenerator, inputCollector, outputPrinter);
        game.start();
        context.assertIsSatisfied();
    }
}
