package ru.job4j.condition;

/**
 * @author Sergey Gavrilov (mailto:sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Point {
	/**
	* Поле координат точки.
	* x coordinate.
	* y coordinate.
	*/
    private int x;
    private int y;
	

	/**
	* Конструктор точки.
	* @param x - координаты по оси х.
	* @param y - координаты по оси y.
	*/
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
	
	/**
	* Функция вычисления расстояния между точками.
	* @param Point that  
	* @return расстояние между точками
	*/
    public double distanceTo(Point that) {
            return Math.sqrt(
                    Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2));
    }
	
	/**
	* main
	* @param args - args*/
    public static void main(String[] args) {
        Point a = new Point(0, 1);
        Point b = new Point(2, 5);
        System.out.println("x1 = " + a.x);
        System.out.println("y1 = " + a.y);
        System.out.println("x2 = " + b.x);
        System.out.println("y2 = " + b.y);
        double result = a.distanceTo(b);
        System.out.println("Расстояние между точками А и В : " + result);
    }
}