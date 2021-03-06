package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
        Item item = new Item("test1", "testDescription", "123L");
        Item result = tracker.add(item);
        assertThat(result, is(item));
    }

    /**
     * Проверка редактирования заявки.
     * Test replace
     */
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous1 = new Item("test1", "testDescription", "123L");
        tracker.add(previous1);
        Item previous2 = new Item("test2", "testDescription2", "1234L");
        tracker.add(previous2);
        previous2.setId(previous1.getId());
        tracker.replace(previous1.getId(), previous2);
        assertThat(tracker.findById(previous1.getId()).getName(), is("test2"));
    }

    /**
     * Проверка удаления заявки.
     * Test delete
     */
    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item previous1 = new Item("test1", "testDescription", "123L");
        tracker.add(previous1);
        Item previous2 = new Item("test2", "testDescription", "123L");
        tracker.add(previous2);
        Item previous3 = new Item("test3", "testDescription", "123L");
        tracker.add(previous3);
        Item previous4 = new Item("test4", "testDescription", "123L");
        tracker.add(previous4);
        Item previous5 = new Item("test5", "testDescription", "123L");
        tracker.add(previous5);
        String prov = previous3.getId();
        tracker.delete(prov);
        Item previous = null;
        assertThat(tracker.findById(prov), is(previous));
    }

    /**
     * Проверка получения списка всех заявок.
     * Test findAll
     */
    @Test
    public void whenGetAListOfAllApplications() {
        Tracker tracker = new Tracker();
        Item previous1 = new Item("test1", "testDescription", "123L");
        tracker.add(previous1);
        Item previous2 = new Item("test2", "testDescription", "123L");
        tracker.add(previous2);
        Item previous3 = new Item("test3", "testDescription", "123L");
        tracker.add(previous3);
        Item previous4 = new Item("test4", "testDescription", "123L");
        tracker.add(previous4);
        List<Item> result = tracker.findAll();
        List<Item> expect = new ArrayList<>();
        expect.add(previous1);
        expect.add(previous2);
        expect.add(previous3);
        expect.add(previous4);
        assertThat(result, is(expect));
    }

    /**
     * Проверка получения списка по имени.
     * Test findByName
     */
    @Test
    public void whenGetAListOfNamed() {
        Tracker tracker = new Tracker();
        Item prov = null;
        Item previous1 = new Item("test1", "testDescription", "123L");
        tracker.add(previous1);
        Item previous2 = new Item("test2", "testDescription", "123L");
        tracker.add(previous2);
        Item previous3 = new Item("test1", "testDescription", "23L");
        tracker.add(previous3);
        Item previous4 = new Item("test4", "testDescription", "123L");
        tracker.add(previous4);
        List<Item> result = tracker.findByName("test2");
        List<Item> expect = new ArrayList<>();
        expect.add(previous2);
        assertThat(result, is(expect));
    }

    /**
     * Проверка получения заявки по Id.
     * Test findById
     */
    @Test
    public void whenTheReceiptOfTheApplicationForId() {
        Tracker tracker = new Tracker();
        Item previous1 = new Item("test1", "testDescription", "123L");
        tracker.add(previous1);
        Item previous2 = new Item("test2", "testDescription", "123L");
        tracker.add(previous2);
        Item previous3 = new Item("test3", "testDescription", "123L");
        tracker.add(previous3);
        Item previous4 = new Item("test4", "testDescription", "123L");
        tracker.add(previous4);
        String idProv = previous3.getId();
        assertThat(tracker.findById(idProv), is(previous3));
    }
}
