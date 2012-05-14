package com.tw.tdd.codekata.guessnumber;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 5/8/12
 * Time: 7:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class GameFacts {

    @Test
    public void should_play_game() {
        Mockery context = new JUnit4Mockery() {
            {
                setImposteriser(ClassImposteriser.INSTANCE);
            }
        };
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
                one(inputCollector).guess();
                will(returnValue("1527"));
                one(inputCollector).guess();
                will(returnValue("1234"));
            }
            {
                one(outputPrinter).print();
                will(returnValue("1A0B"));
                one(outputPrinter).print();
                will(returnValue("1A1B"));
                one(outputPrinter).print();
                will(returnValue("Win"));
            }
        });

        Game game = new Game(answerGenerator, inputCollector, outputPrinter);
        game.play();

        context.assertIsSatisfied();
    }
}
