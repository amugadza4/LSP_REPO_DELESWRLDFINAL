package org.howard.edu.lsp.midterm.crccards;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Manages a collection of Task objects.
 * Prevents duplicate task IDs and supports lookup by ID or status.
 *
 * @author Ropafadzo Adele Mugadza
 */
public class TaskManager {

    private Map<String, Task> tasks;

    /**
     * Constructs an empty TaskManager.
     */
    public TaskManager() {
        tasks = new LinkedHashMap<>();
    }

    /**
     * Adds a task to the manager.
     * Throws IllegalArgumentException if the task ID already exists.
     *
     * @param task the Task to add
     * @throws IllegalArgumentException if duplicate task ID is found
     */
    public void addTask(Task task) {
        if (tasks.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Duplicate task ID: " + task.getTaskId());
        }
        tasks.put(task.getTaskId(), task);
    }

    /**
     * Finds a task by its ID.
     * Returns null if the task is not found.
     *
     * @param taskId the ID to search for
     * @return the Task if found, or null
     */
    public Task findTask(String taskId) {
        return tasks.getOrDefault(taskId, null);
    }

    /**
     * Returns all tasks matching the given status.
     *
     * @param status the status to filter by
     * @return list of matching Task objects
     */
    public List<Task> getTasksByStatus(String status) {
        List<Task> result = new ArrayList<>();
        for (Task task : tasks.values()) {
            if (task.getStatus().equals(status)) {
                result.add(task);
            }
        }
        return result;
    }
}
