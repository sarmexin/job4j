package ru.job4j.list.stack;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleStackTest {
    SimpleStack<Integer> simpleStack = new SimpleStack<>();

    @Before
    public void before() {
        simpleStack.push(1);
        simpleStack.push(2);
        simpleStack.push(3);
        simpleStack.push(4);
    }

    @Test
    public void testStackPushAndPool() {
        assertThat(simpleStack.pool(), is(4));
        assertThat(simpleStack.pool(), is(3));
        simpleStack.push(100);
        assertThat(simpleStack.pool(), is(100));
        assertThat(simpleStack.pool(), is(2));
    }
}