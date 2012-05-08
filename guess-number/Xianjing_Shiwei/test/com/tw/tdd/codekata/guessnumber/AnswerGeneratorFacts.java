package com.tw.tdd.codekata.guessnumber;

import org.junit.Assert;
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
        AnswerGenerator generator = new AnswerGenerator();
        String result = generator.generate();
        assertEquals(4, result.length());
    }

    @Test
    public void should_generate_string_contains_number_only() {
        AnswerGenerator generator = new AnswerGenerator();
        String result = generator.generate();
        assertTrue(result.matches("\\d+"));
    }

    @Test
    public void should_generate_string_with_different_numbers() {
        AnswerGenerator generator = new AnswerGenerator();
        String result = generator.generate();
        String compare = "";
        for(int i=0;i<result.length();i++) {
            char currentNumber = result.charAt(i);
            assertTrue(compare.indexOf(currentNumber) < 0);
            compare += currentNumber;
        }
    }




}
