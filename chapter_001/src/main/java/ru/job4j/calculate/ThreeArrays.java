package ru.job4j.calculate;

/**
 * ThreeArrays.
 *
 * @author Sergey Gavrilov (sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ThreeArrays {
    /**
     * Из двух массивов упорядоченных по возрастанию создаёт третий упорядочунный по возрастанию массив
     *
     * @param array
     * @param arrayTwo
     * @return arrayThree
     */
    public int[] addition(int[] array, int[] arrayTwo) {
        int[] arrayThree = new int[array.length + arrayTwo.length];

        if (array.length == 0) {
            arrayThree = arrayTwo;
            return arrayThree;
        }
        if (arrayTwo.length == 0) {
            arrayThree = array;
            return arrayThree;
        }
        int element1 = 0, element2 = 0;
        int time1 = array[element1];
        int time2 = arrayTwo[element2];
        for (int index = 0; index < arrayThree.length; index++) {
            if (time1 > time2) {
                arrayThree[index] = time2;
                if (element2 == arrayTwo.length - 1) {
                    arrayThree[index++] = arrayTwo[element2];
                    for (int j = element1; j < array.length; j++) {
                        arrayThree[index++] = array[element1++];
                    }
                    break;
                }
                element2++;
                time2 = arrayTwo[element2];
            } else {
                arrayThree[index] = time1;
                if (element1 == array.length - 1) {
                    arrayThree[index++] = array[element1];
                    for (int j = element2; j < arrayTwo.length; j++) {
                        arrayThree[index++] = arrayTwo[element2++];
                    }
                    break;
                }
                element1++;
                time1 = array[element1];
            }
        }
        return arrayThree;
    }
}
