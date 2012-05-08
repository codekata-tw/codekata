package com.tw.tdd.codekata.guessnumber;

public class Validator {

    public boolean isValidate(String input) {
        return input.matches("\\d{4}");
    }
}
