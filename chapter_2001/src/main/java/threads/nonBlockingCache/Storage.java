package threads.nonBlockingCache;

import java.util.concurrent.ConcurrentHashMap;

public class Storage {
    protected ConcurrentHashMap<Integer, Base> concurrentHashMap = new ConcurrentHashMap<>();

    /**
     *
     * @param model
     */
    public void add(Base model){
        concurrentHashMap.putIfAbsent(model.getId(), model);
    }

    /**
     *
     * @param model
     * @return
     */
    public  void update(Base model) {
        int key = model.getId();
        concurrentHashMap.computeIfPresent(key, (key, model) -> {
            if (concurrentHashMap.get(key).getVersion() == model.getVersion()) {
                return concurrentHashMap.put(key, model);
            } else {
                throw new OptimisticException("Throw Exception in Thread");
            }
        });
    }

    /**
     *
     * @param model
     * @return
     */
    public void delete(Base model) {
        concurrentHashMap.remove(model.getId(), model);
    }
}