package ru.job4j.list.linked;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * Test.
 *
 * @author Sergey Gavrilov (mailto:sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class DynamicLinkedTest {
    private DynamicLinked<String> dynamicLinked = new DynamicLinked<>();

    @Before
    public void testBefore() {
        dynamicLinked.add("Two");
        dynamicLinked.add("One");
    }

    @Test(expected = ConcurrentModificationException.class)
    public void testIterator() {
        Iterator iterator = dynamicLinked.iterator();
        assertThat(iterator.hasNext(), is(true));
        iterator.next();
        assertThat(iterator.hasNext(), is(true));
        iterator.next();
        assertThat(iterator.hasNext(), is(false));
        Iterator iterator2 = dynamicLinked.iterator();
        dynamicLinked.add("End");
        assertThat(iterator2.hasNext(), is(true));
        iterator2.next();
    }

    @Test
    public void testAddAndGeyIndex() {
        assertThat(dynamicLinked.get(1).getDate(), is("One"));
        assertThat(dynamicLinked.get(2).getDate(), is("Two"));
    }

    @Test
    public void testDelete() {
        dynamicLinked.delete();
        assertThat(dynamicLinked.get(1).getDate(), is("Two"));
    }

    @Test(expected = NoSuchElementException.class)
    public void getOnException() {
        dynamicLinked.delete();
        dynamicLinked.delete();
        assertThat(dynamicLinked.get(0).getDate(), is("Two"));
    }

    @Test(expected = NoSuchElementException.class)
    public void deleteOnException() {
        dynamicLinked.delete();
        dynamicLinked.delete();
        dynamicLinked.delete();
    }
}