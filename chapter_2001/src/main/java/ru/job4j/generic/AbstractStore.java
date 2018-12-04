package ru.job4j.generic;

/**
 * @author Sergey gavrilov (sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public abstract class AbstractStore<T> {
    private Object[] users = new Object[100];
    int index = 0;

    public void add(T model) {
        users[index++] = model;
    }

    public boolean replace(String id, T model) {
        boolean result = false;
        int element = Integer.parseInt(id);
        for (int i = 0; i < users.length; i++) {
            if (users[i].equals(users[element])) {
                users[i] = model;
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean delete(String id) {
        boolean result = false;
        int element = Integer.parseInt(id);
        if (element >= 0 && element <users.length) {
            users[element] = null;
            result = true;
        }
        return result;
    }

    public T findById(String id) {
        Object result = null;
        int element = Integer.parseInt(id);
        for (int i = 0; i < users.length; i++) {
            if (users[element] == null) {
                break;
            }
            if (users[i].equals(users[element])) {
                result = users[i];
                break;
            }
        }
        return (T) result;
    }

}
