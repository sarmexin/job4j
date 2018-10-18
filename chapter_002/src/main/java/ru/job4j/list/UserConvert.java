package ru.job4j.list;

import java.util.HashMap;
import java.util.List;

/**
 * @author Sergey Gavrilov (mailto:sermexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class UserConvert {
    /**
     * Метод принимает в себя список пользователей и конвертирует его в Map с ключом Integer id и соответствующим ему User
     *
     * @param list
     * @return
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> element = new HashMap<>();
        for (User el : list) {
            el.setId(el.hashCode());
            element.put(el.hashCode(), el);
        }
        return element;
    }

}