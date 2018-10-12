package ru.job4j.chess.firuges.black;

import ru.job4j.chess.OccupiedWayException;
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
    public Cell[] way(Cell source, Cell dest) throws OccupiedWayException {
        if (Math.abs(source.x - dest.x) != Math.abs(source.y - dest.y)) {
            System.out.println((source.x - dest.x) + "  " + (source.y - dest.y));
            throw new OccupiedWayException("Так ходить нельзя");
        }
        Cell[] steps = new Cell[Math.abs(source.x - dest.x)];
        int deltaX = 0, deltaY = 0;
        deltaX = Integer.compare(dest.x, source.x);
        deltaY = Integer.compare(dest.y, source.y);
        for (int i = 1; i < steps.length + 1; i++) {
            if ((source.x + deltaX * i) >= 0 && (source.x + deltaX * i) <= 7 && (source.y + deltaY * i) >= 0 && (source.y + deltaY * i) <= 7 && source.x + deltaX * (i - 1) != dest.x && source.y + deltaY * (i - 1) != dest.y) {
                steps[i - 1] = Cell.findCell(source.x + deltaX * i, source.y + deltaY * i);
            }
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
