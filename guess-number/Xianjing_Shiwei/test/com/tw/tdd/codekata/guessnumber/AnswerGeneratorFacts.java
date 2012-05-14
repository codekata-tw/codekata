package com.tw.tdd.codekata.guessnumber;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 5/2/12
 * Time: 12:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class AnswerGeneratorFacts {

    @Test
    public void should_generate_string_with_4_chars() {
        IAnswerGenerator generator = givenAnswerGenerator();
        String result = generator.generate();
        assertEquals(4, result.length());
    }

    @Test
    public void should_generate_string_contains_number_only() {
        IAnswerGenerator generator = givenAnswerGenerator();
        String result = generator.generate();
        assertTrue(result.matches("\\d+"));
    }

    @Test
    public void should_generate_string_with_different_numbers() {
        IAnswerGenerator generator = givenAnswerGenerator();
        String result = generator.generate();
        resultShouldContainDifferentNumbers(result);
    }

    private IAnswerGenerator givenAnswerGenerator() {
        return new AnswerGenerator(new RandomNumberProducerStub(new int[] {1,2,3,4}));
    }

    private void resultShouldContainDifferentNumbers(String result) {
        String compare = "";
        for(int i=0;i<result.length();i++) {
            char currentNumber = result.charAt(i);
            assertTrue(compare.indexOf(currentNumber) < 0);
            compare += currentNumber;
        }
    }


    private class RandomNumberProducerStub implements IRandomNumberProducer {

        private int[] candidateNumbers;
        private int currentIndex = -1;

        private RandomNumberProducerStub(int[] candidateNumbers) {
            this.candidateNumbers = candidateNumbers;
        }

        public Integer produce() {
            currentIndex = (currentIndex + 1) % candidateNumbers.length;
            return candidateNumbers[currentIndex];
        }
    }

}
