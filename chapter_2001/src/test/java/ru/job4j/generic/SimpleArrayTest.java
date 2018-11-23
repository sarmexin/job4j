package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleArrayTest {
    @Test
    public void testAdd() {
        SimpleArray<Integer> simpleArray = new SimpleArray<Integer>(20);
        simpleArray.add(100);
        assertThat(simpleArray.get(0), is(100));
    }

    @Test
    public void testSet() {
        SimpleArray<Integer> simpleArray = new SimpleArray<Integer>(20);
        simpleArray.set(5, 15);
        assertThat(simpleArray.get(5), is(15));
    }

    @Test
    public void testDelete() {
        SimpleArray<Integer> simpleArray = new SimpleArray<Integer>(20);
        simpleArray.set(5, 15);
        simpleArray.delete(5);
        assertThat(simpleArray.get(5), is(0));
    }
}