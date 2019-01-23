package threads.nonBlockingCache;

import java.util.concurrent.ConcurrentHashMap;

public class Storage {
    protected ConcurrentHashMap<Integer, Base> concurrentHashMap = new ConcurrentHashMap<>();

    /**
     * @param model
     */
    public void add(Base model) {
        concurrentHashMap.putIfAbsent(model.getId(), model);
    }

    /**
     * @param model
     */
    public void update(Base model) {
        concurrentHashMap.computeIfPresent(model.getId(), (key, modelM) -> {
            if (modelM.getVersion() > model.getVersion()) {
                throw new OptimisticException("Throw Exception in Thread");
            }
            model.setVersion(model.getVersion() + 1);
            return model;
        });
    }

    /**
     * @param model
     * @return
     */
    public void delete(Base model) {
        concurrentHashMap.remove(model.getId(), model);
    }
}