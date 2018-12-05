package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Test.
 *
 * @author Sergey Gavrilov (mailto:sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class SimpleArrayTest {
    private SimpleArray<Integer> simpleArray = new SimpleArray<Integer>(20);

    @Before
    public void before() {
        simpleArray.add(10);
        simpleArray.add(20);
        simpleArray.add(30);
        simpleArray.add(40);
        simpleArray.add(50);
    }

    @Test
    public void testAdd() {
        assertThat(simpleArray.get(0), is(10));
    }

    @Test
    public void testSet() {
        simpleArray.set(5, 15);
        assertThat(simpleArray.get(5), is(15));
    }

    @Test
    public void testDelete() {
        simpleArray.delete(3);
        assertThat(simpleArray.get(5), is(50));
    }

    @Test(expected = NoSuchElementException.class)
    public void testIterator() {
        Iterator it = simpleArray.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(10));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(20));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(30));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(40));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(50));
        assertThat(it.hasNext(), is(false));
        it.next();
    }
}