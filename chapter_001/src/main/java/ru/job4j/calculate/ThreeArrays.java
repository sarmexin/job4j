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
     * Из двух массивов упорядоченных по возрастанию сщздаёт третий упорядочунный по возрастанию
     *
     * @param array
     * @param arrayTwo
     * @return arrayThree
     */
    public int[] addition(int[] array, int[] arrayTwo) {
        int[] arrayThree = new int[array.length + arrayTwo.length];
        int element1 = 0, element2 = 0, element3 = 0;
        int time1 = array[element1];
        int time2 = arrayTwo[element2];
        for (int index = 0; index < arrayThree.length; index++) {
            if (time1 > time2) {
                arrayThree[element3] = time2;
                element3++;
                if (element2 == arrayTwo.length - 1) {
                    for (int index2 = element1; index2 < array.length; index2++) {
                        arrayThree[element3] = array[element1];
                        element1++;
                        element3++;
                    }
                    break;
                }
                element2++;
                time2 = arrayTwo[element2];
            } else {
                arrayThree[element3] = time1;
                element3++;
                if (element1 == array.length - 1) {
                    for (int index3 = element2; index3 < arrayTwo.length; index3++) {
                        arrayThree[element3] = arrayTwo[element2];
                        element2++;
                        element3++;
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
