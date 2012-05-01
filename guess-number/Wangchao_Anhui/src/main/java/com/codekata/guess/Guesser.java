package com.codekata.guess;

import java.util.ArrayList;
import java.util.List;

public class Guesser {
    private List<Integer> answer;

    public Guesser(List<Integer> answer) {
        this.answer = answer;
    }

    public String guess(String guess) {
        List<Integer> guessList = convertToArray(guess);
        int partMatch = getPartMatch(guessList);
        int exactlyMatch = getExactlyMatchNumber(guessList);
        partMatch = partMatch - exactlyMatch;

        return exactlyMatch + "a" + partMatch + "b";
    }

    private int getPartMatch(List<Integer> guessList) {
        int partMatch = 0;

        for (Integer value : guessList) {
            if (answer.contains(value)) {
                partMatch += 1;
            }
        }

        return partMatch;
    }

    private int getExactlyMatchNumber(List<Integer> guessList) {
        int exactlyMatch = 0;

        for (int i = 0; i < guessList.size(); i++) {
            Integer value = guessList.get(i);
            if (value.equals(answer.get(i))) {
                exactlyMatch += 1;
            }
        }

        return exactlyMatch;
    }

    private List<Integer> convertToArray(String guess) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < guess.length(); i++) {
            result.add(Integer.parseInt(String.valueOf(guess.charAt(i))));
        }
        return result;
    }

}
