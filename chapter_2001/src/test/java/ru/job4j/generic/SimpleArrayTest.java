package ru.job4j.generic;

import org.junit.Test;

import javax.swing.text.html.HTMLDocument;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

public class SimpleArrayTest {
    private SimpleArray<Integer> simpleArray = new SimpleArray<Integer>(20);

    @Test
    public void testAdd() {
        simpleArray.add(100);
        assertThat(simpleArray.get(0), is(100));
    }

    @Test
    public void testSet() {
        simpleArray.set(5, 15);
        assertThat(simpleArray.get(5), is(15));
    }

    @Test
    public void testDelete() {
        simpleArray.set(5, 15);
        simpleArray.delete(5);
        assertThat(simpleArray.get(5), is(nullValue()));
    }

    @Test
    public void testIterator() {
        simpleArray.add(10);
        simpleArray.add(44);
        simpleArray.add(null);
        simpleArray.add(null);
        simpleArray.add(55);
        Iterator it = simpleArray.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(10));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(44));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(55));
        assertThat(it.hasNext(), is(false));
        assertThat(it.next(), is(nullValue()));
        assertThat(it.next(), is(nullValue()));
        assertThat(it.hasNext(), is(false));
        assertThat(it.next(), is(nullValue()));
    }
}