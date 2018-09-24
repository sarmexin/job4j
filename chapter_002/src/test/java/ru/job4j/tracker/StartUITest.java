package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

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
    /**
     * Test Add new item.
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
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
        Input input = new StubInput(new String[]{"1", "3", item2.getId(), "1", "6"});
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
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getDescription(), is("test replace"));
    }

    private String ls = System.lineSeparator();
    private StringBuilder menu =
            new StringBuilder("0 : Add new Item.").append(ls)
                    .append("1 : Show all items").append(ls)
                    .append("2 : Edit item").append(ls)
                    .append("3 : Delete item").append(ls)
                    .append("4 : Find item by Id").append(ls)
                    .append("5 : Find items by name").append(ls)
                    .append("6. Exit Program").append(ls);
    PrintStream stdout = System.out;
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    Tracker tracker = new Tracker();
    Item item1 = tracker.add(new Item("name1", "desc1"));
    Item item2 = tracker.add(new Item("name2", "desc2"));
    Item item3 = tracker.add(new Item("name1", "desc3"));

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.out.println("execute after method");
    }

    /**
     * Test Show Item.
     */
    @Test
    public void whenUserAddItemThenShowAllItems() {
        Input input = new StubInput(new String[]{"1", "6"});
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
        Input input = new StubInput(new String[]{"4", item2.getId(), "6"});
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
        Input input = new StubInput(new String[]{"4", "12345", "6"});
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
        Input input = new StubInput(new String[]{"5", item1.getName(), "6"});
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
        Input input = new StubInput(new String[]{"5", "12345", "6"});
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


