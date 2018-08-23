package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Sergey Gavrilov (mailto:sarmexin@gmail.com)
 * @version $Id$
 * @since 0.2
 */
public class CheckTest {
    /**
     * Test mono.
     */
    @Test
    public void whenDataMonoByTrueThenTrue() {
        Check check = new Check();
        boolean[] input = new boolean[]{true, true, true};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    /**
     * Test mono.
     */
    @Test
    public void whenDataByTwoTrueThenFalse() {
        Check check = new Check();
        boolean[] input = new boolean[]{true, false, true};
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }

    /**
     * Test mono.
     */
    @Test
    public void whenDataMonoByThreeTrueThenFalse() {
        Check check = new Check();
        boolean[] input = new boolean[]{true, true, true, false};
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }

    /**
     * Test mono.
     */
    @Test
    public void whenDataMonoByFourTrueThenTrue() {
        Check check = new Check();
        boolean[] input = new boolean[]{false, false, false, false};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }
}