package ru.job4j.sorting;

/**
 * @author Sergey gavrilov (sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class User implements Comparable<User> {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int compareTo(User user) {
        return age.compareTo(user.getAge());
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

