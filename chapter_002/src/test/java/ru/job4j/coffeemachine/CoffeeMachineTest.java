package ru.job4j.coffeemachine;

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

public class CoffeeMachineTest {
    /**
     * Проверка прравильности выдачи сдачи
     * Test changes
     */
    @Test
    public void When50RubPrice35RubThen10And5() {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        int[] deliver = new int[]{10, 5};
        assertThat(coffeeMachine.changes(50, 35), is(deliver));
    }

    /**
     * Проверка прравильности выдачи сдачи
     * Test changes
     */
    @Test
    public void When100RubPrice77RubThen10And10And2And1() {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        int[] deliver = new int[]{10, 10, 2, 1};
        assertThat(coffeeMachine.changes(100, 77), is(deliver));
    }

}
