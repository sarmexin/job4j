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
    public void PutInAQueueOf3ValuesThenPickUpThe3ValuesThenPickUpThe3ValuesFromTheStack2() {
        SimpleQueue<String> simpleQueue = new SimpleQueue<>();
        simpleQueue.push("One");
        simpleQueue.push("Two");
        simpleQueue.push("Three");
        assertThat(simpleQueue.pool(), is("One"));
        assertThat(simpleQueue.pool(), is("Two"));
        assertThat(simpleQueue.pool(), is("Three"));
        assertThat(simpleQueue.pool(), is("null"));
        assertThat(simpleQueue.pool(), is("null"));
        assertThat(simpleQueue.getStack2().pool(), is("One"));
        assertThat(simpleQueue.getStack2().pool(), is("Two"));
        assertThat(simpleQueue.getStack2().pool(), is("Three"));
        assertThat(simpleQueue.getStack2().pool(), is("null"));
        assertThat(simpleQueue.getStack2().pool(), is("null"));
    }
}