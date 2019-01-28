package threads.department;

import java.util.*;

/**
 * Класс содержит методы для сортировки департаментов.
 *
 * @author Sergey gavrilov (sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class DepartmentSort {
    /**
     * Отсортировать список департаментов по возрастанию.
     *
     * @param department исходный список департаментов.
     * @return отсортированный список департаментов.
     */
    public String[] departmentSortIncrease(String[] department) {
        String[] departmentSort = this.departmentEdit(department);
        Set<String> set = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        set.addAll(Arrays.asList(departmentSort));
        String[] Array = new String[set.size()];
        return set.toArray(Array);
    }

    /**
     * Отсортировать список департаментов по убыванию.
     *
     * @param department исходный список департаментов.
     * @return отсортированный список департаментов.
     */
    public String[] departmentSortDecrease(String[] department) {
        String[] departmentSort = this.departmentEdit(department);
        Set<String> set = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int min = Math.min(o1.length(), o2.length());
                for (int index = 0; index < min; index++) {
                    Character leftChar = o1.charAt(index);
                    Character rightChar = o2.charAt(index);
                    if (rightChar.compareTo(leftChar) != 0) {
                        return rightChar - leftChar;
                    }
                }
                return o1.length() - o2.length();
            }
        });
        set.addAll(Arrays.asList(departmentSort));
        String[] Array = new String[set.size()];
        return set.toArray(Array);
    }

    /**
     * Восстановить недостающие в исходном списке департаменты.
     *
     * @param department исходный список департаментов.
     * @return восстановленный список департаментов.
     */
    public String[] departmentEdit(String[] department) {
        Set<String> departmentsSet = new TreeSet<>();
        departmentsSet.addAll(Arrays.asList(department));
        for (String element : department) {
            ArrayList<Integer> positions = new ArrayList<>();
            for (int position = 0; position < element.length(); position++) {
                if (element.charAt(position) == '/') {
                    positions.add(position);
                }
            }
            for (Integer pos : positions) {
                char[] departmentChar = element.toCharArray();
                String code = new String(departmentChar, 0, pos);
                departmentsSet.add(code);
            }
        }
        return departmentsSet.toArray(new String[departmentsSet.size()]);
    }
}