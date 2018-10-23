package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertNull;

/**
 * Test.
 *
 * @author Sergey Gavrilov (mailto:sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class StartUITest {
    private String ls = System.lineSeparator();
    private StringBuilder menu =
            new StringBuilder("0 : Add new Item.").append(ls)
                    .append("1 : Show all items").append(ls)
                    .append("2 : Edit item").append(ls)
                    .append("3 : Delete item").append(ls)
                    .append("4 : Find item by Id").append(ls)
                    .append("5 : Find items by name").append(ls)
                    .append("6. Exit Program").append(ls);
    ByteArrayOutputStream out = new ByteArrayOutputStream();


    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.out.println("execute after method");
    }

    /**
     * Test Add new item.
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        List<String> list = new ArrayList<>();
        list.add("0");
        list.add("test name");
        list.add("desc");
        list.add("6");
        Input input = new StubInput(list);
        new StartUI(input, tracker).init();
        assertThat(tracker.findByName("test name").get(0).getName(), is("test name"));
    }

    /**
     * Test Delete Item.
     */
    @Test
    public void whenUserAddItemThenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("name2", "desc2"));
        Item item2 = tracker.add(new Item("name3", "desc3"));
        String result = item2.getId();
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("3");
        list.add(item2.getId());
        list.add("1");
        list.add("6");
        Input input = new StubInput(list);
        new StartUI(input, tracker).init();
        assertNull(tracker.findById(result));
    }

    /**
     * Test Edit Item.
     */
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        List<String> list = new ArrayList<>();
        list.add("2");
        list.add(item.getId());
        list.add("test replace");
        list.add("6");
        Input input = new StubInput(list);
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getDescription(), is("test replace"));
    }


    /**
     * Test Show Item.
     */
    @Test
    public void whenUserAddItemThenShowAllItems() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("name1", "desc1"));
        Item item2 = tracker.add(new Item("name2", "desc2"));
        Item item3 = tracker.add(new Item("name1", "desc3"));
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("6");
        Input input = new StubInput(list);
        System.setOut(new PrintStream(out));
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(menu)
                                .append("-------------Список всех заявок --------------------")
                                .append(System.lineSeparator())
                                .append(item1)
                                .append(System.lineSeparator())
                                .append(item2)
                                .append(System.lineSeparator())
                                .append(item3)
                                .append(System.lineSeparator())
                                .append(menu)
                                .toString()
                )
        );
    }

    /**
     * Test Find Item by Id.
     */
    @Test
    public void whenUserAddItemThenFindItemById() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("name1", "desc1"));
        Item item2 = tracker.add(new Item("name2", "desc2"));
        Item item3 = tracker.add(new Item("name1", "desc3"));
        List<String> list = new ArrayList<>();
        list.add("4");
        list.add(item2.getId());
        list.add("6");
        Input input = new StubInput(list);
        System.setOut(new PrintStream(out));
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(menu)
                                .append(item2)
                                .append(System.lineSeparator())
                                .append(menu)
                                .toString()
                )
        );
    }

    /**
     * Test Not find Item by Id.
     */
    @Test
    public void whenUserAddItemThenNotFindItemById() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("name1", "desc1"));
        Item item2 = tracker.add(new Item("name2", "desc2"));
        Item item3 = tracker.add(new Item("name1", "desc3"));
        List<String> list = new ArrayList<>();
        list.add("4");
        list.add("12345");
        list.add("6");
        Input input = new StubInput(list);
        System.setOut(new PrintStream(out));
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(menu)
                                .append("Заявки с Id : " + "12345" + " не найдено.")
                                .append(System.lineSeparator())
                                .append(menu)
                                .toString()
                )
        );
    }

    /**
     * Test Find Item by name.
     */
    @Test
    public void whenUserAddItemThenFindItemByName() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("name1", "desc1"));
        Item item2 = tracker.add(new Item("name2", "desc2"));
        Item item3 = tracker.add(new Item("name1", "desc3"));
        List<String> list = new ArrayList<>();
        list.add("5");
        list.add(item1.getName());
        list.add("6");
        Input input = new StubInput(list);
        System.setOut(new PrintStream(out));
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(menu)
                                .append(item1)
                                .append(System.lineSeparator())
                                .append(item3)
                                .append(System.lineSeparator())
                                .append(menu)
                                .toString()
                )
        );
    }

    /**
     * Test Not find Item by name.
     */
    @Test
    public void whenUserAddItemThenNotFindItemByName() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("name1", "desc1"));
        Item item2 = tracker.add(new Item("name2", "desc2"));
        Item item3 = tracker.add(new Item("name1", "desc3"));
        List<String> list = new ArrayList<>();
        list.add("5");
        list.add("12345");
        list.add("6");
        Input input = new StubInput(list);
        System.setOut(new PrintStream(out));
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(menu)
                                .append("Заявки с именем : " + "12345" + " не найдено.")
                                .append(System.lineSeparator())
                                .append(menu)
                                .toString()
                )
        );
    }
}


