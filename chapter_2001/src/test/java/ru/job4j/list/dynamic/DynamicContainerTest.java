package ru.job4j.list.dynamic;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

/**
 * Test.
 *
 * @author Sergey Gavrilov (mailto:sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class DynamicContainerTest {
    private DynamicContainer<Integer> dynamicContainer = new DynamicContainer<>(new Integer[]{1, 2, 3});
    private Iterator<Integer> it = dynamicContainer.new ContainerIterator<>();

    @Test(expected = ConcurrentModificationException.class)
    public void testAdd() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(false));
        dynamicContainer.add(55);
        assertThat(dynamicContainer.getContainer().length, is(6));
        assertThat(it.hasNext(), is(true));

    }
    @Test
    public void testGet() {
        assertThat(dynamicContainer.get(1), is(2));
        assertThat(dynamicContainer.get(20), is(nullValue()));
    }
}