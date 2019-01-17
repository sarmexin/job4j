package threads.threadSafe;

import ru.job4j.collections.list.array.DynamicContainer;
import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class ThreadCollection<E> {
    @GuardedBy("this")
    private DynamicContainer<E> dynamicContainer;

    public ThreadCollection(DynamicContainer<E> dynamicContainer) {
        this.dynamicContainer = dynamicContainer;
    }

    public synchronized void add(E value) {
        dynamicContainer.add(value);
    }
    public E get(int index) {
        return dynamicContainer.get(index);
    }


}
