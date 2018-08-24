package ru.job4j.array;

/**
 * BubbleSort.
 *
 * @author Sergey Gavrilov (sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class BubbleSort {
    /**
     * Method sort.
     *
     * @param array[].
     * @return array[].
     */
    public int[] sort(int[] array) {
        int temp;
        for (int indexone = 0; indexone < array.length; indexone++) {
            for (int index = 0; index < (array.length - indexone - 1); index++) {
                if (array[index] > array[index + 1]) {
                    temp = array[index];
                    array[index] = array[index + 1];
                    array[index + 1] = temp;
                }
            }
        }
        return array;
    }
}
