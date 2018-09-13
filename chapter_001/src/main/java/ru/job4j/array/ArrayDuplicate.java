package ru.job4j.array;

import java.util.Arrays;

/**
 * ArrayDuplicate.
 *
 * @author Sergey Gavrilov (sarmexin@gmail.com)
 * @version $Id$
 * @since 0.2
 */
public class ArrayDuplicate {
    /**
     * Method remove.
     *
     * @param array
     * @return array.
     */
    public String[] remove(String[] array) {
        String time;
        int number = 0;
        for (int index = 0; index < array.length - number; index++) {
            for (int index2 = 0; index2 < array.length - number; index2++) {
                if (index == index2) {
                    index2++;
                }
                if (array[index].equals(array[index2])) {
                    time = array[array.length - 1 - number];
                    array[array.length - 1 - number] = array[index];
                    array[index2] = time;
                    number++;
                }
            }
        }
        return Arrays.copyOf(array, array.length - number);
    }
}
