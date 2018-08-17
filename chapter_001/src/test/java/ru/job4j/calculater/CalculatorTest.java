package ru.job4j.calculator;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1, 1);
        double result = calc.getResult();
        double expected = 2;
        assertThat(result, is(expected));
    }
	
	@Test
    public void whenDiv2On2Then1() {
        Calculator calc = new Calculator();
        calc.div(10, 5);
        double result = calc.getResult();
        double expected = 2;
        assertThat(result, is(expected));
    }
	
	@Test
    public void whenSubtract4On2Then2() {
        Calculator calc = new Calculator();
        calc.subtract(10, 7);
        double result = calc.getResult();
        double expected = 3;
        assertThat(result, is(expected));
    }
	
	@Test
    public void whenMultiple2On3Then6() {
        Calculator calc = new Calculator();
        calc.multiple(10, 3);
        double result = calc.getResult();
        double expected = 30;
        assertThat(result, is(expected));
    }
}