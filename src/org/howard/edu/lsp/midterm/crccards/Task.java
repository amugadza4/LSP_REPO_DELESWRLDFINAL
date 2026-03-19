package org.howard.edu.lsp.midterm.crccards;

/**
 * Represents a task in the Task Management System.
 * Stores task information and manages task status.
 *
 * @author Ropafadzo Adele Mugadza
 */
public class Task {

    private String taskId;
    private String description;
    private String status;

    /**
     * Constructs a Task with the given ID and description.
     * Default status is OPEN.
     *
     * @param taskId      unique identifier for the task
     * @param description brief description of the task
     */
    public Task(String taskId, String description) {
        this.taskId = taskId;
        this.description = description;
        this.status = "OPEN";
    }

    /**
     * Returns the task ID.
     *
     * @return the task ID
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * Returns the task description.
     *
     * @return the task description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the current task status.
     *
     * @return the task status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the task status. Valid values: OPEN, IN_PROGRESS, COMPLETE.
     * Any other value sets the status to UNKNOWN.
     *
     * @param status the new status
     */
    public void setStatus(String status) {
        if (status.equals("OPEN") || status.equals("IN_PROGRESS") || status.equals("COMPLETE")) {
            this.status = status;
        } else {
            this.status = "UNKNOWN";
        }
    }

    /**
     * Returns a string in the format: taskId description [status]
     *
     * @return formatted task string
     */
    @Override
    public String toString() {
        return taskId + " " + description + " [" + status + "]";
    }
}
