package ru.job4j.array;

/**
 * Check.
 *
 * @author Sergey Gavrilov (sarmexin@gmail.com)
 * @version $Id$
 * @since 0.2
 */
public class Check {
    /**
     * Method mono.
     *
     * @param data
     * @return result.
     */
    public boolean mono(boolean[] data) {
        boolean result = true;
        int sheck = 0;
        for (int index = 0; index < data.length - 1; index++) {
            if (data[0] != data[index + 1]) {
                result = false;
                break;
            }
        }
        return result;
    }
}