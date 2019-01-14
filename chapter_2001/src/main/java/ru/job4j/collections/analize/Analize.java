package ru.job4j.collections.analize;

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
        int added;
        int changed = 0;
        int deleted = previous.size();
        for (User user : previous) {
            for (User user1 : current) {
                if (user.getId() == user1.getId() && !user.getName().equals(user1.getName())) {
                    changed++;
                    break;
                }
            }
        }
        int result = 0;
        for (User user : previous) {
            for (User user1 : current) {
                if (user.getId() == user1.getId()) {
                    result++;
                    deleted--;
                    break;
                }
            }
        }
        added = current.size() - result;
        Info info = new Info(added, changed, deleted);
        return info;
    }
}
