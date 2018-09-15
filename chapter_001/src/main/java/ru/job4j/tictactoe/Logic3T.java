package ru.job4j.tictactoe;

import java.util.function.Predicate;

/**
 * Logic3T.
 *
 * @author Sergey Gavrilov (sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Logic3T {
    private final Figure3T[][] table;

    /**
     * Конструктор.
     *
     * @param table
     */
    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    /**
     * Method fillBy.
     *
     * @param predicate
     * @param startX    Начальная координата по X.
     * @param startY    Начальная координата по Y.
     * @param deltaX    Приращение по X.
     * @param deltaY    Приращение по Y.
     * @return
     */
    public boolean fillBy(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            Figure3T cell = this.table[startX][startY];
            if ((deltaX == 0 && deltaY == 1) || (deltaX == 1 && deltaY == 0)) {
                for (int i = 0; i != this.table.length; i++) {
                    int startX1 = startX;
                    int startY1 = startY;
                    if (deltaX == 1) {
                        startY1 += i;
                    } else {
                        startX1 += i;
                    }
                    result = true;
                    for (int j = 0; j != this.table.length; j++) {
                        cell = this.table[startX1][startY1];
                        startX1 += deltaX;
                        startY1 += deltaY;
                        if (!predicate.test(cell)) {
                            result = false;
                            break;
                        }
                    }
                    if (result == true) {
                        break;
                    }
                }
                break;
            }
            startX += deltaX;
            startY += deltaY;
            if (!predicate.test(cell)) {
                result = false;
                break;
            }
        }
        return result;
    }

    /**
     * Method isWinnerX.
     *
     * @return
     */

    public boolean isWinnerX() {
        return this.fillBy(Figure3T::hasMarkX, 0, 0, 1, 1)
                || this.fillBy(Figure3T::hasMarkX, this.table.length - 1, 0, -1, 1)
                || this.fillBy(Figure3T::hasMarkX, 0, 0, 1, 0)
                || this.fillBy(Figure3T::hasMarkX, 0, 0, 0, 1);
    }

    /**
     * Method isWinnerO.
     *
     * @return
     */

    public boolean isWinnerO() {
        return this.fillBy(Figure3T::hasMarkO, 0, 0, 1, 1)
                || this.fillBy(Figure3T::hasMarkO, this.table.length - 1, 0, -1, 1)
                || this.fillBy(Figure3T::hasMarkO, 0, 0, 1, 0)
                || this.fillBy(Figure3T::hasMarkO, 0, 0, 0, 1);

    }

    /**
     * Method hasGap.
     *
     * @return
     */

    public boolean hasGap() {
        boolean result = false;
        for (int index = 0; index < table.length; index++) {
            for (int index2 = 0; index2 < table.length; index2++) {
                if (!table[index][index2].hasMarkO() && !table[index][index2].hasMarkX()) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
}