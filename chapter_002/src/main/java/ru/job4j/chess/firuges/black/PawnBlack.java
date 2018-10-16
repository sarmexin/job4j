package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * @author Sergey gavrilov (sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class PawnBlack implements Figure {
    private final Cell position;

    public PawnBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (Math.abs(source.x - dest.x) != 0 || source.y - dest.y != 1) {
            throw new ImpossibleMoveException("Так ходить нельзя");
        }
        Cell[] steps = new Cell[0];
        if (source.y == dest.y + 1 && source.x == dest.x) {
            steps = new Cell[]{dest};
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new PawnBlack(dest);
    }
}
