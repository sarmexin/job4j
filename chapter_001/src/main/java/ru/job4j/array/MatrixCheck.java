package ru.job4j.array;

/**
 * MatrixCheck.
 *
 * @author Sergey Gavrilov (sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class MatrixCheck {
    /**
     * Method mono.
     *
     * @param data[][]
     * @return result
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int index = 0; index < data.length - 1; index++) {
            if (data.length % 2 != 0 & data[0][0] != data[0][data.length - 1]) {
                result = false;
                break;
            }
            if (data[index][index] != data[index + 1][index + 1]) {
                result = false;
                break;
            }
            if (data[index][data.length - 1 - index] != data[index + 1][data.length - 2 - index]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
