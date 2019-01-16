package threads.userStorage;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Sergey gavrilov (sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class UserStorage {
    private Map map = new HashMap();

    public Map getMap() {
        return map;
    }

    boolean add(User user) {
        boolean result = false;
        if (!map.containsKey(user.getId())) {
            map.put(user.getId(), user.getAmount());
            result = true;
        }
        return result;
    }

    boolean update(User user) {
        boolean result = false;
        if (map.containsKey(user.getId())) {
            map.put(user.getId(), user.getAmount());
            result = true;
        }
        return result;
    }

    boolean delete(User user) {
        boolean result = false;
        if (map.containsKey(user.getId())) {
            map.remove(user.getId());
            result = true;
        }
        return result;
    }

    boolean transfer(int fromId, int foId, int amount) {
        boolean result = false;
        if (map.containsKey(fromId) && map.containsKey(foId) && (int) map.get(fromId) > amount) {
            int transfer = (int) map.get(fromId) - amount;
            map.put(fromId, transfer);
            transfer = (int) map.get(foId) + amount;
            map.put(foId, transfer);
            result = true;
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserStorage that = (UserStorage) o;
        return Objects.equals(map, that.map);
    }

}
