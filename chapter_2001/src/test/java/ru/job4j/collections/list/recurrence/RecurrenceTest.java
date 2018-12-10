package ru.job4j.collections.list.recurrence;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class RecurrenceTest {
    private Recurrence<Integer> recurrence = new Recurrence<>();
    @Before
    public void testBefore() {
        recurrence.add(1);
        recurrence.add(2);
        recurrence.add(3);
        recurrence.add(4);
    }

    @Test
    public void testHasCycle() {
        assertThat(recurrence.hasCycle(), is(false));
        recurrence.get(4).setNext(recurrence.getFirst());
        assertThat(recurrence.hasCycle(), is(true));
    }

    @Test
    public void testHasCycle2() {
        assertThat(recurrence.hasCycle(), is(false));
        recurrence.get(3).setNext(recurrence.get(1).getNext());
        assertThat(recurrence.hasCycle(), is(true));
    }


}