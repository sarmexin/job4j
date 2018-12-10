package ru.job4j.collections.set;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Test.
 *
 * @author Sergey Gavrilov (mailto:sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class SimpleSetTest {
    private SimpleSet<Integer> simpleSet = new SimpleSet<>(new Integer[]{1, 2, 3});

    @Test
    public void testIterator() {
        Iterator iterator = simpleSet.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void testAdd() {
        simpleSet.add(777);
        Iterator iterator = simpleSet.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(777));
        assertThat(iterator.hasNext(), is(false));
        simpleSet.add(777);
        Iterator iterator2 = simpleSet.iterator();
        assertThat(iterator2.hasNext(), is(true));
        assertThat(iterator2.next(), is(1));
        assertThat(iterator2.hasNext(), is(true));
        assertThat(iterator2.next(), is(2));
        assertThat(iterator2.hasNext(), is(true));
        assertThat(iterator2.next(), is(3));
        assertThat(iterator2.hasNext(), is(true));
        assertThat(iterator2.next(), is(777));
        assertThat(iterator2.hasNext(), is(false));
    }
}