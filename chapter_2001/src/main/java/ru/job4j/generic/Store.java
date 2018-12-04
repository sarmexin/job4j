package ru.job4j.generic;

/**
 * @author Sergey gavrilov (sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public interface Store<T extends Base> {
    void add(T model);

    void replace(String id, T model);

    void delete(String id);

    T findById(String id);
}
