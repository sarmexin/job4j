package threads.department;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Класс, содержащий тесты нат класс DepartmentSort.
 *
 * @author Sergey Gavrilov (mailto:sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class DepartmentSortTest {
    /**
     * Тест проверяет воостановление недостающих департаментов в списке.
     */
    @Test
    public void whenTheDepartmentMissingThenSortRecoversIt() {
        String[] sourceDepartment = {
                "K1/SK1",
                "K1/SK2",
                "K1/SK1/SSK1",
                "K1/SK1/SSK2",
                "K2",
                "K2/SK1/SSK1",
                "K2/SK1/SSK2"
        };
        String[] expected = {
                "K1",
                "K1/SK1",
                "K1/SK1/SSK1",
                "K1/SK1/SSK2",
                "K1/SK2",
                "K2",
                "K2/SK1",
                "K2/SK1/SSK1",
                "K2/SK1/SSK2"
        };
        DepartmentSort departmentSort = new DepartmentSort();
        String[] result = departmentSort.departmentEdit(sourceDepartment);
        assertThat(result, is(expected));
    }

    /**
     * Тест проверяет сортировку департаментов по возразтанию.
     */
    @Test
    public void whenTheListThenSortsTheListByIncrease() {
        String[] sourceDepartment = {
                "K1/SK1",
                "K1/SK2",
                "K1/SK1/SSK1",
                "K1/SK1/SSK2",
                "K2",
                "K2/SK1/SSK1",
                "K2/SK1/SSK2"
        };
        String[] expected = {
                "K1",
                "K1/SK1",
                "K1/SK1/SSK1",
                "K1/SK1/SSK2",
                "K1/SK2",
                "K2",
                "K2/SK1",
                "K2/SK1/SSK1",
                "K2/SK1/SSK2"
        };
        DepartmentSort departmentSort = new DepartmentSort();
        String[] result = departmentSort.departmentSortIncrease(sourceDepartment);
        assertThat(result, is(expected));
    }

    /**
     * тест проверяет сортировку департаментов по убыванию.
     */
    @Test
    public void whenTheListThenSortsTheListByDecrease() {
        String[] sourceDepartment = {
                "K1/SK1",
                "K1/SK2",
                "K1/SK1/SSK1",
                "K1/SK1/SSK2",
                "K2",
                "K2/SK1/SSK1",
                "K2/SK1/SSK2"
        };
        String[] expected = {
                "K2",
                "K2/SK1",
                "K2/SK1/SSK2",
                "K2/SK1/SSK1",
                "K1",
                "K1/SK2",
                "K1/SK1",
                "K1/SK1/SSK2",
                "K1/SK1/SSK1"
        };
        DepartmentSort departmentSort = new DepartmentSort();
        String[] result = departmentSort.departmentSortDecrease(sourceDepartment);
        assertThat(result, is(expected));
    }
}