package com.codekata.guess;

import com.google.common.collect.Lists;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        List<Integer> answer = Lists.newArrayList(1, 2, 3, 4);
        Game game = new Game(answer);
        game.run();
    }
}
