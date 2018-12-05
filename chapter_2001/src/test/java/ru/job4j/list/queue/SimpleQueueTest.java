package ru.job4j.list.queue;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

public class SimpleQueueTest {

    @Test
    public void pool() {
        SimpleQueue<String> simpleQueue = new SimpleQueue<>();
        simpleQueue.push("One");
        simpleQueue.push("Two");
        simpleQueue.push("Three");
        assertThat(simpleQueue.pool(), is("One"));
        assertThat(simpleQueue.pool(), is("Two"));
        assertThat(simpleQueue.pool(), is("Three"));
        assertThat(simpleQueue.pool(), is("null"));


        //System.out.println(simpleQueue.pool());
       // System.out.println("In test :" + simpleQueue.pool());
       // System.out.println("In test :" + simpleQueue.pool());
       // System.out.println("In test :" + simpleQueue.pool());
    }

    @Test
    public void push() {

    }
}