package ru.job4j.max;

/**
 * @author Sergey Gavrilov (mailto:sarmexin@gmail.com)
 * @version $Id$
 * @since 0.11
 */
 public class Max {
	 
	/**
    * Находит максимальное из двух чисел.
    * @param first second Принимает два числа.
    * @return максимальное число.
    */
	public int max(int first, int second) {
	    return first > second ? first : second;
	}
	
    /**
    * Находит максимальное из трёх чисел.
    * @param first second third Принимает три числа.
    * @return максимальное число.
    */
	public int maxx(int first, int second, int third) {
		int temp = this.max(first, second);
		int tempmax = this.max(temp, third);
		return tempmax;
	}	
}