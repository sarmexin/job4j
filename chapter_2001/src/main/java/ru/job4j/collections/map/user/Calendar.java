package ru.job4j.collections.map.user;

import java.util.Objects;

/**
 * @author Sergey gavrilov (sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Calendar {
    private int data;
    private int month;
    private int year;

    public Calendar(int data, int month, int year) {
        this.data = data;
        this.month = month;
        this.year = year;
    }

    @Override
    public int hashCode() {

        return Objects.hash(data, month, year);
    }
}
