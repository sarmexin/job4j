package threads.threadSafe;

import ru.job4j.collections.list.array.DynamicContainer;

import java.util.Iterator;
import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class DynamicContainerDecorator<E> extends DynamicContainer {
    @GuardedBy("this")
    private DynamicContainer dynamicContainer;

    public DynamicContainerDecorator(Object[] container, DynamicContainer dynamicContainer) {
        super(container);
        this.dynamicContainer = dynamicContainer;
    }

    @Override
    public synchronized void add(<E> value) {
        dynamicContainer.add(value);
    }

    @Override
    public Object get(int index) {
        return super.get(index);
    }

    @Override
    public Iterator iterator() {
        return super.iterator();
    }
}
