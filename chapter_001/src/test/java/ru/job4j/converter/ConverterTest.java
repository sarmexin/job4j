package ru.job4j.converter;

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
public class ConverterTest {
    /**
     * Test rubleToDollar.
     */
    @Test
    public void when60RubleToDollarThen1() {
        Converter converter = new Converter();
        int result = converter.rubleToDollar(60);
        assertThat(result, is(1));
    }

    /**
     * Test rubleToEuro.
     */
    @Test
    public void when70RubleToEuroThen1() {
        Converter converter = new Converter();
        int result = converter.rubleToEuro(70);
        assertThat(result, is(1));
    }

    /**
     * Test euroToRuble.
     */
    @Test
    public void when2EuroToRubleThen140() {
        Converter converter = new Converter();
        int result = converter.euroToRuble(2);
        assertThat(result, is(140));
    }

    /**
     * Test dollarToRuble.
     */
    @Test
    public void when2DollarToRubleThen120() {
        Converter converter = new Converter();
        int result = converter.dollarToRuble(2);
        assertThat(result, is(120));
    }
}
