package ru.job4j.array;

/**
 * Turn.
 *
 * @author Sergey Gavrilov (sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Turn {
    /**
     * Method turn
     *
     * @param array[]
     * @return array
     */
    public int[] turn(int[] array) {
        int store;
        for (int index = 0; index <= array.length / 2 - 1; index++) {
            store = array[index];
            array[index] = array[array.length - index - 1];
            array[array.length - index - 1] = store;
            if ((array.length % 2 != 0) & (array.length / 2 == index)) {
                break;
            }
        }
        return array;
    }

}