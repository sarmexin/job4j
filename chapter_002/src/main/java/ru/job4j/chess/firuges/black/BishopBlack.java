package ru.job4j.chess.firuges.black;

import ru.job4j.chess.Logic;
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
    public Logic logic = new Logic();

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[64];

        //пределяем дельты
        int deltaX = 0, deltaY = 0;
        if (source.x < dest.x) {
            deltaX = 1;
        }
        if (source.x > dest.x) {
            deltaX = -1;
        }
        if (source.y < dest.y) {
            deltaY = 1;
        }
        if (source.y > dest.y) {
            deltaY = -1;
        }
        int a = 0;
        for (int i = 1; i != 8; i++) {
            if ((source.x + deltaX * i) >= 0 && (source.x + deltaX * i) <= 7 && (source.y + deltaY * i) >= 0 && (source.y + deltaY * i) <= 7 && source.x + deltaX * (i - 1) != dest.x && source.y + deltaY * (i - 1) != dest.y) {
                steps[i - 1] = logic.findCell(source.x + deltaX * i, source.y + deltaY * i);
                System.out.println("if=" + i + " " + steps[i - 1] + "дельты" + deltaX + " " + deltaY);
                a = i;
            } else {
                break;
            }
        }
        System.out.print("Клетки на котороые может пойти фигура ");
        for (int m = 0; m != a; m++) {
            System.out.print("  " + steps[m]);
        }
        System.out.println();
        Cell[] steps2 = Arrays.copyOf(steps, a);
        return steps2;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
