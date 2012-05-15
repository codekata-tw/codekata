package com.codekata.guess;

import java.util.List;

public class Guesser {
    private List<Integer> answer;

    public Guesser(List<Integer> answer) {
        this.answer = answer;
    }

    public GuessResult guess(List<Integer> guessList) {
        int partMatch = getPartMatch(guessList);
        int exactlyMatch = getExactlyMatchNumber(guessList);
        partMatch = partMatch - exactlyMatch;

        return new GuessResult(exactlyMatch, partMatch);
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


}
