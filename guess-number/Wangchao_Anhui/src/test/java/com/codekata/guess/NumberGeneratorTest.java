package com.codekata.guess;

import com.google.common.collect.ImmutableSet;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class NumberGeneratorTest {
    @Test
    public void should_generate_random_integers() {
        int numberCount = 4;
        NumberGenerator generator = new NumberGenerator();

        ArrayList<Integer> numberList = generator.generate1(numberCount);

        assertThat(numberList.size(), is(numberCount));
        assertThat(numberList.get(0), instanceOf(Integer.class));
    }

    @Test
    public void should_generate_unique_integers() {
        int numberCount = 10;
        NumberGenerator generator = new NumberGenerator();

        ArrayList<Integer> numberList = generator.generate1(numberCount);

        ImmutableSet<Integer> set = ImmutableSet.copyOf(numberList);
        assertThat(set.size(), is(numberList.size()));
    }
}
