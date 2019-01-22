package threads.nonBlockingCache;

import java.util.concurrent.ConcurrentHashMap;

import static javafx.scene.input.KeyCode.V;

public class Storage {
    protected ConcurrentHashMap<Integer, Base> concurrentHashMap = new ConcurrentHashMap<>();

    /**
     *
     * @param model
     */
    public synchronized void add(Base model){
        concurrentHashMap.put(model.getId(), model);
    }

    /**
     *
     * @param model
     * @return
     */
    public  boolean update(Base model) {
        //public Base computeIfPresent(Base model.getId(), BiFunction <concurrentHashMap.get(model.getId()), U, R> -> concurrentHashMap.put(model.getId(),model));

        int versionModel = model.getVersion();
        int versionMap = concurrentHashMap.get(model.getId()).getVersion();
        if (versionModel == versionMap) {
            concurrentHashMap.put(model.getId(), model);
        } else {
            throw new OptimisticException("Throw Exception in Thread");
        }
        return false;
    }

    /**
     *
     * @param model
     * @return
     */
    public synchronized boolean delete(Base model) {

        concurrentHashMap.remove(model.getId());
        return false;
    }
    private void newVersion() {}


}
