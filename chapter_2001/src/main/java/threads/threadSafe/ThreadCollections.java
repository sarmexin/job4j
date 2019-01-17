package threads.threadSafe;

import ru.job4j.collections.list.array.DynamicContainer;

import java.util.Iterator;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class ThreadCollections<E> extends DynamicContainerDecorator<E> {

    public ThreadCollections(DynamicContainer dynamicContainer) {
        super(dynamicContainer);
    }

    @Override
    public synchronized Iterator<E> iterator() {
        return this.copy(dynamicContainer).iterator();
    }

    public synchronized void add(E value) {
        dynamicContainer.add(value);
    }

    public E get(int index) {
        return (E) dynamicContainer.get(index);
    }

    private synchronized DynamicContainer<E> copy(DynamicContainer<E> dynamicContainer) {
        Object[] array = new Object[dynamicContainer.getIndex()];
        DynamicContainer<E> container = new DynamicContainer<>(array);;
        for (int i = 0; i < dynamicContainer.getIndex(); i++) {
            container.add(dynamicContainer.get(i));
        }


        return container;
    }
}
