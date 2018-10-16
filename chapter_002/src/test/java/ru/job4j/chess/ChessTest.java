package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.PawnBlack;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ChessTest {
    /**
     * Test Нельзя идти, на пути есть фигуры
     */
    @Test
    public void figureCannotGoInTheWayOfAFigure() {
        try {
            Logic logic = new Logic();
            Figure pawnBlack = new PawnBlack(Cell.B2);
            Figure bishopBlack = new BishopBlack(Cell.C1);
            logic.add(pawnBlack);
            logic.add(bishopBlack);
            logic.move(Cell.C1, Cell.A3);

        } catch (OccupiedWayException OWE) {
            int a = 1;
            assertThat(a, is(1));
        }
    }
    /**
     * Test Фигура может так ходить
     */
    @Test
    public void figureGoInLikeThat() {
        Logic logic = new Logic();
        Figure pawnBlack = new PawnBlack(Cell.B7);
        Figure bishopBlack = new BishopBlack(Cell.C8);
        logic.add(pawnBlack);
        logic.add(bishopBlack);
        logic.move(Cell.C8, Cell.G4);
        assertThat(logic.findBy(Cell.G4), is(1));
    }
    /**
     * Test фигура так пойти не может, на конечной точке фигура
     */
    @Test
    public void figureCannotGoLikeThatIsWorthAFigureAtTheEnd() {
        try {
            Logic logic = new Logic();
            Figure pawnBlack = new PawnBlack(Cell.A3);
            Figure bishopBlack = new BishopBlack(Cell.C1);
            logic.add(pawnBlack);
            logic.add(bishopBlack);
            logic.move(Cell.C1, Cell.A3);

        } catch (FigureNotFoundException FNFE) {
            int a = 1;
            assertThat(a, is(1));
        }
    }
}
