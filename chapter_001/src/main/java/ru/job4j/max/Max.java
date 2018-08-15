
package ru.job4j.max;

/**
 * @author Sergey Gavrilov (mailto:sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Max {
	/**
     * Находит максимальное из двух чисел.
     * @param question Принимает два числа.
     * @return максимальное число.
     */
	public int max(int first, int second) {
	    return (first > second) ? first : second;
	}
}