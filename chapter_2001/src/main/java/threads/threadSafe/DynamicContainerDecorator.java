package threads.threadSafe;

import ru.job4j.collections.list.array.DynamicContainer;

import java.util.Iterator;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class DynamicContainerDecorator<E> implements Iterable<E> {
    @GuardedBy("this")
    protected DynamicContainer<E> dynamicContainer;

    public DynamicContainerDecorator(DynamicContainer<E> dynamicContainer) {
        this.dynamicContainer = dynamicContainer;
    }

    @Override
    public synchronized Iterator<E> iterator() {
        return this.copy(dynamicContainer).iterator();
    }

    private synchronized DynamicContainer<E> copy(DynamicContainer<E> dynamicContainer) {
        Object[] array = new Object[dynamicContainer.getIndex()];
        DynamicContainer<E> container = new DynamicContainer<>(array);
        for (int i = 0; i < dynamicContainer.getIndex(); i++) {
            container.add(dynamicContainer.get(i));
        }
        return container;
    }

    public synchronized void add(E value) {
        dynamicContainer.add(value);
    }

    public synchronized E get(int index) {
        return (E) dynamicContainer.get(index);
    }
}
