package ru.job4j.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();
    private List<Task> result = new ArrayList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     *
     * @param task задача
     */
    public void put(Task task) {
        if (tasks.size() != 0) {
            int j = tasks.size();
            for (int i = 0; i != j; i++) {
                if (tasks.get(i).getPriority() > task.getPriority()) {
                    tasks.add(i, task);
                }
            }
            if (tasks.get(tasks.size() - 1).getPriority() < task.getPriority()) {
                tasks.addLast(task);
            }
        } else {
            tasks.add(task);
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}
