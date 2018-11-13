package ru.job4j.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     *
     * @param task задача
     */
    public void put(Task task) {
        Optional<Task> element = tasks.stream()
                .filter(x -> x.getPriority() >= task.getPriority())
                .findAny();
        if (element.isPresent() && tasks.size() == 0) {
            tasks.add(task);
        } else {
            if (element.equals(Optional.empty())) {
                tasks.add(task);
            } else {
                tasks.add(tasks.indexOf(element.get()), task);
            }
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}
