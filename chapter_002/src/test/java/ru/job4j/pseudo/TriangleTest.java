package ru.job4j.pseudo;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Sergey Gavrilov (mailto:sermexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class TriangleTest {
    /**
     * Test figure triangle.
     */
    @Test
    public void whenDrawTriangle() {
        Triangle triangle = new Triangle();
        assertThat(triangle.draw(), is(new StringBuilder()
                        .append("   +")
                        .append("  + +")
                        .append(" +   +")
                        .append("+++++++")
                        .toString()
                )
        );
    }
}
