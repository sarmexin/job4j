package ru.job4j.list.queue;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Test.
 *
 * @author Sergey Gavrilov (mailto:sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class SimpleQueueTest {

    @Test
    public void testSimpleQueue() {
        SimpleQueue<String> simpleQueue = new SimpleQueue<>();
        simpleQueue.push("One");
        simpleQueue.push("Two");
        simpleQueue.push("Three");
        assertThat(simpleQueue.pool(), is("One"));
        assertThat(simpleQueue.pool(), is("Two"));
        simpleQueue.push("Four");
        simpleQueue.push("Fifth");
        assertThat(simpleQueue.pool(), is("Three"));
        assertThat(simpleQueue.pool(), is("Four"));
        assertThat(simpleQueue.pool(), is("Fifth"));
        assertNull(simpleQueue.pool());
    }
}