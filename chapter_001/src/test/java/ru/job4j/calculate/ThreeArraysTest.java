package ru.job4j.calculate;

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
public class ThreeArraysTest {
    /**
     * Test addition.
     */
    @Test
    public void theAdditionOfTheArray() {
        ThreeArrays ob = new ThreeArrays();
        int[] arraysTest1 = new int[]{5, 7, 9, 12, 15, 16};
        int[] arraysTest2 = new int[]{1, 8, 19, 20, 24, 25};
        int[] expect = new int[]{1, 5, 7, 8, 9, 12, 15, 16, 19, 20, 24, 25};
        int[] result = ob.addition(arraysTest1, arraysTest2);
        assertThat(result, is(expect));
    }

    /**
     * Test addition.
     */
    @Test
    public void theAdditionOfTheArray2() {
        ThreeArrays ob = new ThreeArrays();
        int[] arraysTest1 = new int[]{5, 7, 9, 12, 15, 16, 30, 50, 60, 70, 80};
        int[] arraysTest2 = new int[]{1, 8, 19, 20, 24, 25};
        int[] expect = new int[]{1, 5, 7, 8, 9, 12, 15, 16, 19, 20, 24, 25, 30, 50, 60, 70, 80};
        int[] result = ob.addition(arraysTest1, arraysTest2);
        assertThat(result, is(expect));
    }

    /**
     * Test addition.
     */
    @Test
    public void theAdditionOfTheArray3() {
        ThreeArrays ob = new ThreeArrays();
        int[] arraysTest1 = new int[]{5, 7, 9, 12, 15, 16, 30, 50, 60, 70, 80};
        int[] arraysTest2 = new int[]{};
        int[] expect = new int[]{5, 7, 9, 12, 15, 16, 30, 50, 60, 70, 80};
        int[] result = ob.addition(arraysTest1, arraysTest2);
        assertThat(result, is(expect));
    }

    /**
     * Test addition.
     */
    @Test
    public void theAdditionOfTheArray4() {
        ThreeArrays ob = new ThreeArrays();
        int[] arraysTest1 = new int[]{};
        int[] arraysTest2 = new int[]{5, 7, 9, 12, 15, 16, 30, 50, 60, 70, 80};
        int[] expect = new int[]{5, 7, 9, 12, 15, 16, 30, 50, 60, 70, 80};
        int[] result = ob.addition(arraysTest1, arraysTest2);
        assertThat(result, is(expect));
    }

    /**
     * Test addition.
     */
    @Test
    public void theAdditionOfTheArray5() {
        ThreeArrays ob = new ThreeArrays();
        int[] arraysTest1 = new int[]{1, 8, 19, 20, 24, 25};
        int[] arraysTest2 = new int[]{5, 7, 9, 12, 15, 16, 30, 50, 60, 70, 80};
        int[] expect = new int[]{1, 5, 7, 8, 9, 12, 15, 16, 19, 20, 24, 25, 30, 50, 60, 70, 80};
        int[] result = ob.addition(arraysTest1, arraysTest2);
        assertThat(result, is(expect));
    }
    /**
     * Test addition.
     */
    @Test
    public void theAdditionOfTheArray6() {
        ThreeArrays ob = new ThreeArrays();
        int[] arraysTest1 = new int[]{};
        int[] arraysTest2 = new int[]{};
        int[] expect = new int[]{};
        int[] result = ob.addition(arraysTest1, arraysTest2);
        assertThat(result, is(expect));
    }
}
