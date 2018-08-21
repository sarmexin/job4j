package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FactorialTest {
    @Test
    public void whenCalculateFactorialForFiveThenOneHundreedTwenty() {
		int result;
		Factorial factorial = new Factorial();
		result = factorial.calc(5);
		assertThat(result, is(120));
    }

    @Test
    public void whenCalculateFactorialForZeroThenOne() {
		int result;
		Factorial factorial = new Factorial();
		result = factorial.calc(0);
		assertThat(result, is(1));
    }
}