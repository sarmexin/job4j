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
            startX += deltaX;
            startY += deltaY;
            if (!predicate.test(cell)) {
                result = false;
                break;
            }
        }
        return result;
    }

    public boolean isWinnerX() {
        boolean result = true;
        for (int i = 0; i != this.table.length; i++) {
            if (!this.fillBy(Figure3T::hasMarkX, 0, 0, 1, 0) ||
                    !this.fillBy(Figure3T::hasMarkX, 0, 0, 0, 1)) {
                result = false;
                break;
            }
        }
        return result ||
                this.fillBy(Figure3T::hasMarkX, 0,0, 1, 1) ||
                this.fillBy(Figure3T::hasMarkX, this.table.length - 1 , 0, -1, 1);
    }


    public boolean isWinnerO() {
        boolean result = true;
        for (int i = 0; i != this.table.length; i++) {
            if (!this.fillBy(Figure3T::hasMarkO, 0, 0, 1, 0) ||
                    !this.fillBy(Figure3T::hasMarkO, 0, 0, 0, 1)) {
                result = false;
                break;
            }
        }
        return result ||
                this.fillBy(Figure3T::hasMarkO, 0,0, 1, 1) ||
                this.fillBy(Figure3T::hasMarkO, this.table.length - 1 , 0, -1, 1);
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
            if (result == true) {
                break;
            }
        }
        return result;
    }
}