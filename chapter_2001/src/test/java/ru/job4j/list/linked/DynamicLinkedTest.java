package ru.job4j.list.linked;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.Matchers.nullValue;
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
    private DynamicLinked<Integer> integerDynamicLinked = new DynamicLinked<>();

    @Before
    public void testBefore() {
        dynamicLinked.add("Two");
        dynamicLinked.add("One");
        integerDynamicLinked.add(1);
        integerDynamicLinked.add(2);
        integerDynamicLinked.add(3);
        integerDynamicLinked.add(4);
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

    @Test
    public void getOnException() {
        dynamicLinked.delete();
        dynamicLinked.delete();
        assertThat(dynamicLinked.get(0), is(nullValue()));
    }

    @Test
    public void deleteOnException() {
        dynamicLinked.delete();
        dynamicLinked.delete();
        assertThat(dynamicLinked.delete(), is(nullValue()));
    }

    @Test
    public void testHasCycle() {
        assertThat(integerDynamicLinked.hasCycle(), is(false));
        integerDynamicLinked.get(4).setNext(integerDynamicLinked.getFirst());
        assertThat(integerDynamicLinked.hasCycle(), is(true));
    }

    @Test
    public void testHasCycle2() {
        assertThat(integerDynamicLinked.hasCycle(), is(false));
        integerDynamicLinked.get(3).setNext(integerDynamicLinked.get(1).getNext());
        assertThat(integerDynamicLinked.hasCycle(), is(true));
    }
}