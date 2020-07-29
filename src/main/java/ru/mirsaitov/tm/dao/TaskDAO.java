package ru.mirsaitov.tm.dao;

import ru.mirsaitov.tm.entity.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskDAO {

    private List<Task> tasks = new ArrayList<>();

    /**
     * Create task by name
     *
     * @param name - name of task
     * @return created task
     */
    public Task create(final String name) {
        final Task task = new Task(name);
        tasks.add(task);
        return task;
    }

    /**
     * Create task by name and description
     *
     * @param name - name of task
     * @param description - description of task
     * @return created task
     */
    public Task create(final String name, final String description) {
        final Task task = new Task(name, description);
        tasks.add(task);
        return task;
    }

    /**
     * Clear tasks
     */
    public void clear() {
        tasks.clear();
    }

    /**
     * Return tasks
     */
    public List<Task>  findAll() {
        return new ArrayList<>(tasks);
    }

}
