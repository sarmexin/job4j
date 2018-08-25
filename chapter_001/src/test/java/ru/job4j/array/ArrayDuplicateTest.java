package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayDuplicateTest {
    /**
     * Test remove.
     */
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        //напишите здесь тест, проверяющий удаление дубликатов строк из массива строк.
        ArrayDuplicate duplicate = new ArrayDuplicate();
        String[] input = new String[]{"Привет", "Мир", "Привет", "Супер", "Мир"};
        String[] expect = new String[]{"Привет", "Мир", "Супер"};
        String[] result = duplicate.remove(input);
        assertThat(result, is(expect));
    }

    /**
     * Test remove.
     */
    @Test
    public void whenRemoveDuplicates() {
        //напишите здесь тест, проверяющий удаление дубликатов строк из массива строк.
        ArrayDuplicate duplicate = new ArrayDuplicate();
        String[] input = new String[]{"Привет", "Привет", "Привет", "Привет", "Привет"};
        String[] expect = new String[]{"Привет"};
        String[] result = duplicate.remove(input);
        assertThat(result, is(expect));
    }
}
