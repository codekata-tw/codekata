package com.tw.tdd.codekata.guessnumber;

public class Validator {

    public boolean isValid(String input) {
        return input.matches("\\d{4}");
    }
}
