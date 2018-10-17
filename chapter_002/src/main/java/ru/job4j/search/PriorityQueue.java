package ru.job4j.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
        if (tasks.size() != 0) {
            for (int i = 0; i != tasks.size(); i++) {
                if (tasks.get(i).getPriority() > task.getPriority()) {
                    tasks.add(i, task);
                    break;
                }
                if (tasks.get(i).getPriority() == task.getPriority() && tasks.get(i + 1).getPriority() > task.getPriority())   {
                    tasks.add(i + 1, task);
                    break;
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
