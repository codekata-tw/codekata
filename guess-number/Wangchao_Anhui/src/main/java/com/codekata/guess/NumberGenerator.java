package com.codekata.guess;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collections;

public class NumberGenerator {

    public ArrayList<Integer> generate1(int size) {
        ArrayList<Integer> list = Lists.newArrayList(size);
        for (int i = 1; i < size; i++) {
            list.add(getRandomInteger(0, 9));
        }
        Collections.shuffle(list);
        return list;
    }

    private Integer getRandomInteger(int min, int max) {
        return (int) (Math.random() * ((max - min) + 1)) + min;
    }
}
