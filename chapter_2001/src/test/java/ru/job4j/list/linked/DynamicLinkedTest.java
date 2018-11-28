package ru.job4j.list.linked;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * Test.
 *
 * @author Sergey Gavrilov (mailto:sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class DynamicLinkedTest {
    private DynamicLinked<DynamicLinked.Node> dynamicLinked = new DynamicLinked<>();

    @Before
    public void testBefore() {
        DynamicLinked.Node<String> newLink1 = new DynamicLinked.Node<>("One");
        DynamicLinked.Node<String> newLink2 = new DynamicLinked.Node<>("One");
        DynamicLinked.Node<String> newLink3 = new DynamicLinked.Node<>("One");
//        DynamicLinked.Node<String>
//        dynamicLinked.add("One");
//        dynamicLinked.add("Two");
//        dynamicLinked.add("Three");

    }

    @Test(expected = ConcurrentModificationException.class)
    public void test() {
        //Iterator<DynamicLinked.Node<String>> iterator = dynamicLinked.new DynamicLinkedIterator();
        Iterator<DynamicLinked.Node<String>> iterator = dynamicLinked.iterator();
        assertThat(iterator.hasNext(), is(true));
        System.out.println(iterator.hasNext());
        iterator.next();
        assertThat(iterator.hasNext(), is(true));
        System.out.println(iterator.hasNext());
        iterator.next();
        assertThat(iterator.hasNext(), is(true));
        System.out.println(iterator.hasNext());
        iterator.next();
        assertThat(iterator.hasNext(), is(false));
        System.out.println(iterator.hasNext());
        //dynamicLinked.add("End");
        DynamicLinked.Node<String> newLink4 = new DynamicLinked.Node<>("One");
        assertThat(iterator.hasNext(), is(true));
        System.out.println(iterator.hasNext());
        iterator.next();
        assertThat(iterator.hasNext(), is(false));
        System.out.println(iterator.hasNext());
    }
}