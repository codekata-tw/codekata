package com.codekata.guess;

public class GuessResult {
    private final int exactlyMatch;
    private final int partMatch;

    public int getExactlyMatch() {
        return exactlyMatch;
    }

    public int getPartMatch() {
        return partMatch;
    }

    public GuessResult(int exactlyMatch, int partMatch) {
        this.exactlyMatch = exactlyMatch;
        this.partMatch = partMatch;
    }
}
