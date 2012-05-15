package com.codekata.guess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class NumberSource {

    public List<Integer> getNumbers() {
        return convertToArray(getUserInput());
    }

    private String getUserInput() {
        String inputLine = null;
        System.out.println("please input 4 numbers:" + "     ");
        BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
        try {
            inputLine = is.readLine();
            if (inputLine.length() == 0) {
                return null;
            }
        } catch (IOException e) {
            System.out.println("IOException:" + e);
        }
        return inputLine;
    }

    private List<Integer> convertToArray(String guess) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < guess.length(); i++) {
            result.add(Integer.parseInt(String.valueOf(guess.charAt(i))));
        }
        return result;
    }

}
