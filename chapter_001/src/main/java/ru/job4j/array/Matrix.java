package ru.job4j.array;

/**
 * Matrix.
 *
 * @author Sergey Gavrilov (sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Matrix {
    /**
     * Method multiple.
     *
     * @param size.
     * @return table[][].
     */
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int indexline = 0; indexline < size; indexline++) {
            for (int indexcolumn = 0; indexcolumn < size; indexcolumn++) {
                table[indexline][indexcolumn] = (indexline + 1) * (indexcolumn + 1);
            }
        }
        return table;
    }
}
