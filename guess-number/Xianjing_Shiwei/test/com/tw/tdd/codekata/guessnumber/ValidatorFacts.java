package com.tw.tdd.codekata.guessnumber;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 5/8/12
 * Time: 7:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class ValidatorFacts {

    Validator validator;

    @Before
    public void setUp() {
        validator = new Validator();
    }

    @Test
    public void should_be_invalid_when_input_contains_more_than_4_chars() {
        assertFalse(validator.isValidate("12345"));
    }

    @Test
    public void should_be_invalid_when_input_contains_less_than_4_chars() {
        assertFalse(validator.isValidate("123"));
    }

    @Test
    public void should_be_invalid_when_input_contains_non_numeric_chars() {
        assertFalse(validator.isValidate("a123"));
    }

    @Test
    public void should_be_valid_when_input_contains_4_numbers() {
        assertTrue(validator.isValidate("1234"));
    }
}

