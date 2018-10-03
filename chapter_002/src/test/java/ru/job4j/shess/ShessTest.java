package ru.job4j.shess;

import org.junit.Test;
import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.PawnBlack;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ShessTest {

    /**
     * Test Нельзя идти, на пути фигура
     */
    @Test
    public void figureСannotGoInTheWayOfAFigure() {
        Logic logic = new Logic();
        Figure pawnBlack = new PawnBlack(Cell.B7);
        logic.figures[0] = pawnBlack;
        BishopBlack bishopBlack1 = new BishopBlack(Cell.C8);
        logic.figures[1] = bishopBlack1;
        Figure pawnBlack2 = new PawnBlack(Cell.H3);
        logic.figures[2] = pawnBlack2;
        logic.move(Cell.C8, Cell.A6);
        assertThat(logic.findBy(Cell.A6), is (-1));
    }

    /**
     * Test Фигура так не ходит
     */
    @Test
    public void figureСannotGoLikeThat() {
        Logic logic = new Logic();
        Figure pawnBlack = new PawnBlack(Cell.B7);
        logic.figures[0] = pawnBlack;
        BishopBlack bishopBlack1 = new BishopBlack(Cell.C8);
        logic.figures[1] = bishopBlack1;
        logic.move(Cell.C8, Cell.E1);
        assertThat(logic.findBy(Cell.E1), is (-1));
    }

    /**
     * Test Фигура может так ходить
     */
    @Test
    public void figureGoInLikeThat() {
        Logic logic = new Logic();
        Figure pawnBlack = new PawnBlack(Cell.B7);
        logic.figures[0] = pawnBlack;
        BishopBlack bishopBlack1 = new BishopBlack(Cell.C8);
        logic.figures[1] = bishopBlack1;
        logic.move(Cell.C8, Cell.G4);
        assertThat(logic.findBy(Cell.G4), is (1));
    }
    @Test
    public void figureCannotGoLikeThatIsWorthAFigureAtTheEnd() {
        Logic logic = new Logic();
        Figure pawnBlack = new PawnBlack(Cell.B7);
        logic.figures[0] = pawnBlack;
        BishopBlack bishopBlack1 = new BishopBlack(Cell.C8);
        logic.figures[1] = bishopBlack1;
        logic.move(Cell.C8, Cell.H3);
        assertThat(logic.findBy(Cell.H3), is (1));
    }

}
