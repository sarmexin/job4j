package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.Arrays;

/**
 * @author Sergey gavrilov (sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        if (Math.abs(source.x - dest.x) != Math.abs(source.y - dest.y)) {
            throw new ImpossibleMoveException("Так ходить нельзя");
        }
        Cell[] steps = new Cell[Math.abs(source.x - dest.x)];
        int deltaX = Integer.compare(dest.x, source.x);
        int deltaY = Integer.compare(dest.y, source.y);
        int x, y, x1 = source.x, y1 = source.y;
        for (int i = 1; i < steps.length + 1; i++) {
            x = source.x + deltaX * i;
            y = source.y + deltaY * i;
            if (x >= 0 && x <= 7 && y >= 0 && y <= 7 && x1 != dest.x && y1 != dest.y) {
                steps[i - 1] = Cell.findCell(x, y);
            }
            x1 = x;
            y1 = y;
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
