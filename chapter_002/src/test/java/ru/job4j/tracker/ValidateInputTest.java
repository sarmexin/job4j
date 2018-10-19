package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Test. Проверяет валидацию.
 *
 * @author Sergey Gavrilov (mailto:sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ValidateInputTest {
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    private final PrintStream out = System.out;

    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }

    @After
    public void loadSys() {
        System.setOut(this.out);
    }

    /**
     * Test ValidateInput. Проверяет на исключение MenuOutException.
     */
    @Test
    public void whenInvalidInput() {
        List<String> list = new ArrayList<String>();
        list.add("invalid");
        list.add("1");
        ValidateInput input = new ValidateInput(new StubInput(list));
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        input.ask("select", list2);
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Please enter validate data again.%n")
                )
        );
    }

    /**
     * Test ValidateInput. Проверяет на исключение NumberFormatException.
     */
    @Test
    public void whenSelectKeyInput() {
        List<String> list = new ArrayList<>();
        list.add("2");
        list.add("1");
        ValidateInput input = new ValidateInput(new StubInput(list));
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        input.ask("select", list2);
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Please select key from menu.%n")
                )
        );
    }
}