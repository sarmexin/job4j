package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * //TODO add comments.
 *
 * @author Sergey gavrilov (sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;
    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }
    public boolean move(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        int index = findBy(dest);
        if (index != -1) {
            throw new FigureNotFoundException("на dest фигура");
        }
        index = this.findBy(source);
        Cell[] steps = this.figures[index].way(source, dest);
        for (int i = 0; i != steps.length; i++) {
            if (this.findBy(steps[i]) != -1) {
                throw new OccupiedWayException("Путь занят фигурами");
            }
        }
        this.figures[index] = this.figures[index].copy(dest);
        return true;
    }
    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }
    public int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}
