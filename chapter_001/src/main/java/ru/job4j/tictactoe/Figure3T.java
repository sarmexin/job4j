package ru.job4j.tictactoe;

import javafx.scene.shape.Rectangle;

/**
 * Figure3T.
 *
 * @author Sergey Gavrilov (mailto:sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Figure3T extends Rectangle {
    private boolean markX = false;
    private boolean markO = false;

    public Figure3T() {
    }

    /**
     * Конструктор.
     *
     * @param markX
     */
    public Figure3T(boolean markX) {
        this.markX = markX;
        this.markO = !markX;
    }

    /**
     * Method take.
     *
     * @param markX
     */
    public void take(boolean markX) {
        this.markX = markX;
        this.markO = !markX;
    }

    /**
     * Method HasMarkX.
     *
     * @return
     */

    public boolean hasMarkX() {
        return this.markX;
    }

    /**
     * Method hasMarkO.
     *
     * @return
     */

    public boolean hasMarkO() {
        return this.markO;
    }
}

