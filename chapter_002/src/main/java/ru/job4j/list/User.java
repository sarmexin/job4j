package ru.job4j.list;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * @author Sergey Gavrilov (mailto:sermexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class User {
    private Integer id;
    private String name;
    private String city;

    public User(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}