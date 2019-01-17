package threads.threadSafe;

import ru.job4j.collections.list.array.DynamicContainer;

import java.util.Iterator;
import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public abstract class DynamicContainerDecorator<E> implements Iterable<E> {
    @GuardedBy("this")
    protected DynamicContainer dynamicContainer;

    public DynamicContainerDecorator(DynamicContainer dynamicContainer) {
        this.dynamicContainer = dynamicContainer;
    }
}
