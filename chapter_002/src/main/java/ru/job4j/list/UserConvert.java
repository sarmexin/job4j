package ru.job4j.list;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        HashMap<Integer, User> map = new HashMap<>();
        Long n = list.stream().peek(x -> map.put(x.hashCode(), x)).count();
        return map;
    }
}
