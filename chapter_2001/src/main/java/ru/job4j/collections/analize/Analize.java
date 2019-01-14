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
        int added;
        int changed = 0;
        int deleted = previous.size();
        for (User user : previous) {
            if (hashMap.containsKey(user.getId()) && !hashMap.containsValue(user.getName())) {
                changed++;
            }
        }
        int result = 0;
        for (User user : previous) {
            if (hashMap.containsKey(user.getId())) {
                result++;
                deleted--;
            }
        }
        added = current.size() - result;
        Info info = new Info(added, changed, deleted);
        return info;
    }
}
