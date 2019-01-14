package ru.job4j.collections.analize;

import java.util.HashMap;
import java.util.List;

/**
 * @author Sergey gavrilov (sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Analize {
    /**
     * Метод возвращает статистку об изменении коллекции
     *
     * @param previous
     * @param current
     * @return
     */
    public Info diff(List<User> previous, List<User> current) {
        HashMap hashMap = new HashMap();
        for (User user : current) {
            hashMap.put(user.getId(), user.getName());
        }
        int added = 0;
        int changed = 0;
        int deleted = 0;
        for (User user : previous) {
            Object user1 = hashMap.remove(user.getId());
            if (user1 == null) {
                deleted++;
            } else {
                if (!user.getName().equals(user1)) {
                    changed++;
                }
            }
        }
        added = hashMap.size();
        return new Info(added, changed, deleted);
    }
}
