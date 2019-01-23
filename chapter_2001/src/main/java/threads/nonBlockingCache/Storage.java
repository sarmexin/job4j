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
        concurrentHashMap.computeIfPresent(model.getId(), (key, modelM) -> {
            if (concurrentHashMap.get(key).getVersion() == model.getVersion()) {
                System.out.println("Успел" );
                model.setId(model.getId() + 1);
                return model;
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