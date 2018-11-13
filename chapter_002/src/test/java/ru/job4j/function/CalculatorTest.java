package ru.job4j.function;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Test.
 *
 * @author Sergey Gavrilov (mailto:sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class CalculatorTest {
    /**
     * Test linear.
     */
    @Test
    public void testLinear() {
        Calculator calculator = new Calculator();
        List<Double> buffer = calculator.diapason(10, 13, (x) -> x + 10);
        assertThat(buffer, is(Arrays.asList((double) 20, (double) 21, (double) 22)));
    }

    /**
     * Test quadratic.
     */
    @Test
    public void testQuadratic() {
        Calculator calculator = new Calculator();
        List<Double> buffer = calculator.diapason(2, 5, (x) -> Math.pow(x, 2));
        assertThat(buffer, is(Arrays.asList((double) 4, (double) 9, (double) 16)));
    }

    /**
     * Test logarithmic.
     */
    @Test
    public void testLogarithmic() {
        Calculator calculator = new Calculator();
        List<Double> buffer = calculator.diapason(10, 13, (x) -> Math.log(x));
        assertThat(buffer, is(Arrays.asList(2.302585092994046, 2.3978952727983707, 2.4849066497880004)));
    }
}
