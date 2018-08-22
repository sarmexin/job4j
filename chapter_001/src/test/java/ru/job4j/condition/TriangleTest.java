package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.*;

/**
 * @author Sergey Gavrilov (mailto:sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class TriangleTest {
 @Test
 public void whenAreaSetThreePointsThenTriangleArea() {
 // создаем три объекта класса Point.
 Point a = new Point(0, 0);
 Point b = new Point(0, 2);
 Point c = new Point(2, 0);
 // Создаем объект треугольник и передаем в него объекты точек.
 Triangle triangle = new Triangle(a, b, c);
 // Вычисляем площадь.
 double result = triangle.area();
 // Задаем ожидаемый результат.
 double expected = 2;
 //Проверяем результат и ожидаемое значение.
 assertThat(result, closeTo(expected, 0.1));
 }
@Test
public void name() throws Exception {
 Triangle triangle = new Triangle(null, null, null);
 boolean result = triangle.exist(6, 4, 2);
 assertFalse(result);
}
@Test
public void name1() throws Exception {
 Triangle triangle = new Triangle(null, null, null);
 boolean result = triangle.exist(2, 6, 4);
 assertFalse(result);
}
@Test
public void name2() throws Exception {
 Triangle triangle = new Triangle(null, null, null);
 boolean result = triangle.exist(4, 2, 6);
 assertFalse(result);
}
}
