package ru.job4j.list.queue;

import ru.job4j.list.linked.DynamicLinked;

public class SimpleQueueStack<T> {
    private DynamicLinked<T> list = new DynamicLinked<>();

    public void push(T date) {
        list.add(date);
    }

    public T pool() {
        DynamicLinked.Node el = list.deleteFIFO();
        T result = (T) "null";
        if ( el != null) {
            result = (T) el.getDate();
            //System.out.println("***1***" + result);
        }
        return  result;
    }
}
