package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Sergey Gavrilov (mailto:sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class TrackerTest {
    /**
     * Проверка на добавление заявки.
     * Test add
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.findAll()[0], is(item));
    }

    /**
     * Проверка редактирования заявки.
     * Test replace
     */
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2", 1234L);
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    /**
     * Проверка удаления заявки.
     * Test delete
     */
    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item previous1 = new Item("test1", "testDescription", 123L);
        tracker.add(previous1);
        Item previous2 = new Item("test2", "testDescription", 123L);
        tracker.add(previous2);
        Item previous3 = new Item("test3", "testDescription", 123L);
        tracker.add(previous3);
        Item previous4 = new Item("test4", "testDescription", 123L);
        tracker.add(previous4);
        String prov = previous3.getId();
        tracker.delete(prov);
        assertThat(tracker.findAll()[2], is(previous4));
    }

    /**
     * Проверка получения списка всех заявок.
     * Test findAll
     */
    @Test
    public void whenGetAListOfAllApplications() {
        Tracker tracker = new Tracker();
        Item previous1 = new Item("test1", "testDescription", 123L);
        tracker.add(previous1);
        Item previous2 = new Item("test2", "testDescription", 123L);
        tracker.add(previous2);
        Item previous3 = new Item("test3", "testDescription", 123L);
        tracker.add(previous3);
        Item previous4 = new Item("test4", "testDescription", 123L);
        tracker.add(previous4);
        assertThat(tracker.findAll()[3], is(previous4));
        assertThat(tracker.findAll()[2], is(previous3));
    }

    /**
     * Проверка получения списка по имени.
     * Test findByName
     */
    @Test
    public void whenGetAListOfNamed() {
        Tracker tracker = new Tracker();
        Item prov = null;
        Item previous1 = new Item("test1", "testDescription", 123L);
        tracker.add(previous1);
        Item previous2 = new Item("test2", "testDescription", 123L);
        tracker.add(previous2);
        Item previous3 = new Item("test1", "testDescription", 123L);
        tracker.add(previous3);
        Item previous4 = new Item("test4", "testDescription", 123L);
        tracker.add(previous4);
        assertThat(tracker.findByName("test1")[0], is(previous1));
        assertThat(tracker.findByName("test1")[1], is(previous3));
    }

    /**
     * Проверка получения заявки по Id.
     * Test findById
     */
    @Test
    public void whenTheReceiptOfTheApplicationForId() {
        Tracker tracker = new Tracker();
        Item previous1 = new Item("test1", "testDescription", 123L);
        tracker.add(previous1);
        Item previous2 = new Item("test2", "testDescription", 123L);
        tracker.add(previous2);
        Item previous3 = new Item("test3", "testDescription", 123L);
        tracker.add(previous3);
        Item previous4 = new Item("test4", "testDescription", 123L);
        tracker.add(previous4);
        String idProv = previous3.getId();
        assertThat(tracker.findById(idProv), is(previous3));
    }
}
