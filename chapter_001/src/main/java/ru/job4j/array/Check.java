package ru.job4j.array;

/**
 * Sheck.
 *
 * @author Sergey Gavrilov (sarmexin@gmail.com)
 * @version $Id$
 * @since 0.2
 */
public class Check {
    public boolean mono(boolean[] data) {
        boolean result = false;
        int sheck = 0;
        for (int index = 0; index < data.length; index++) {
            if (data[index] == true) sheck++;
        }
        if (sheck == data.length || sheck == 0) result = true;
        return result;
    }
}