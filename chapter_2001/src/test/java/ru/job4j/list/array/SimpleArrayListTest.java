package ru.job4j.list.array;

import org.junit.Test;
import org.junit.Before;
import ru.job4j.list.array.SimpleArrayList;

import java.util.ConcurrentModificationException;
import java.lang.IndexOutOfBoundsException;
import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Sergey Gavrilov (mailto:sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class SimpleArrayListTest {
    private SimpleArrayList<Integer> list;

    @Before
    public void beforeTest() {
        list = new SimpleArrayList<>(4);
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(list.get(0), is(3));
    }

    @Test
    public void whenAddThreeElementsThenUseGetSizeResultThree() {
        assertThat(list.getSize(), is(3));
    }

    @Test
    public void whenAddThreeElementsThenDeleteOneElement() {
        list.delete(2);
        assertThat(list.getSize(), is(2));
        assertThat(list.get(1), is(1));
    }

    @Test
    public void whenAddThreeElementsThenDeleteNonExistentElement() {
        list.delete(555);
        assertThat(list.getSize(), is(3));
    }
    @Test
    public void testIterator() {
        Iterator iterator = list.iterator();
        assertThat(iterator.hasNext(), is(true));
        iterator.next();
        assertThat(iterator.hasNext(), is(true));
        iterator.next();
        assertThat(iterator.hasNext(), is(true));
        iterator.next();
        assertThat(iterator.hasNext(), is(false));
    }
    @Test(expected = ConcurrentModificationException.class)
    public void testConcurrentModificationException() {
        Iterator iterator = list.iterator();
        list.add(10);
        assertThat(iterator.hasNext(), is(true));
        iterator.next();
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testArrayIndexOutOfBoundsException() {
        list.add(10);
        list.add(11);
    }
    @Test
    public void testSet() {
        list.set(1, 1000);
        assertThat(list.get(1), is(1000));
        list.set(2, 100);
        assertThat(list.get(2), is(100));

    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetException() {
        list.set(4, 100);
    }
}