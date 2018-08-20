package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Sergey Gavrilov (mailto:sarmexin@gmail.com)
 * @version $Id$
 * @since 0.11
 */

public class CounterTest {
	
	@Test
	public void sumOfEvenNumbers() {
		int result;
		Counter counter = new Counter();
			result = counter.add(1, 10);
			assertThat(result, is(30));
	}
}