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
    public final Figure[] figures = new Figure[32]; //Массив фигур
    private int index = 0;
    public static Cell cell[] = Cell.values();

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    public class ImpossibleMoveException extends RuntimeException {
    }

    public class OccupiedWayException extends RuntimeException {
    }

    public class FigureNotFoundException extends RuntimeException {
    }

    public boolean move(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException { //Метод движения проверяет возможность передвижения фигуры по ячейкам из массива, возвращаемый методолм move
        boolean rst = false;
        int index1 = this.findBy(dest);
        try {
            if (index1 != -1) {
                throw new FigureNotFoundException();
            }
            int index = this.findBy(source);
            if (index != -1) {
                Cell[] steps = this.figures[index].way(source, dest); // Получает массив steps клеток возможных передвижения
                System.out.println("Массив передвижения, длина =" + steps.length);
                boolean rst2 = false;
                for (int i = 0; i != steps.length; i++) {
                    if (steps[i].equals(dest)) {
                        System.out.println("Фигура может так пойти попала на маршрут");
                        rst2 = true;
                        break;
                    }
                }
                if (rst2 == false) {
                    throw new OccupiedWayException();
                }
                // Проверка, что путь не занят фигурами
                for (int m = 0; m != steps.length; m++) {
                    System.out.println(" Путь фигуры " + steps[m]);
                }
                for (int i = 0; i != steps.length; i++) {
                    if (this.findBy(steps[i]) != -1) {
                        throw new ImpossibleMoveException();
                    }
                }
                rst = true; // Флаг переведён на усешно
                this.figures[index] = this.figures[index].copy(dest);
            }
        } catch (FigureNotFoundException fnfe) {
            System.out.println(" *******************на dest фигура " + rst);
        } catch (OccupiedWayException owe) {
            System.out.println("***************** Так ходить нельзя " + rst);
        } catch (ImpossibleMoveException ime) {
            System.out.println("***************** Путь занят фигурами " + rst);
        }
        System.out.println("возвращение флага из метода move");
        System.out.println(" ");
        return rst;
    }

    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    public int findBy(Cell cell) { //Метод поиска фигуры в массиве figures, возвращает индекс фигуры. Принимает начальну точку
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) { //Пробегает по массиву фигур figures
           // System.out.print(this.figures[index] + " ");
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) { //Сравнивает содержимое массива с начальной точкой, ищет совпадение
                rst = index;
                break;
            }
        }
        return rst; //Возврат индекса фигуры
    }

    public Cell findCell(int x1, int y1) {
        int e = -1;
        for (int i = 0; i <= 63; i++) {
            if (cell[i].x == x1 && cell[i].y == y1) {
                e = i;
                break;
            }
        }
        return Cell.valueOf(cell[e].toString());
    }

}
