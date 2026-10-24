package com.example.taskmanager.service;

import com.example.taskmanager.model.Task;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

@Service
public class TaskService {
    private static final Logger log = LoggerFactory.getLogger("tasks");

    private final ArrayList<Task> tasks = new ArrayList<>();
    private int nextId = 1;

    public TaskService() {
    }

    public ArrayList<Task> getAllTasks() {
        return tasks;
    }

    public boolean addTask(String title, String priority) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be blank!");
        }

        Task task = new Task(nextId, title, priority);

        log.info("Adding task");

        if (tasks.add(task)) {
            nextId++;
            log.debug("Task: {} | Priority: {}", task, priority);
            log.info("Added task");
            return true;
        }

        return false;
    }

    public boolean updateTaskCompletionStatus(int id) {
        log.info("Completing task");

        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setCompletedTrue();
                log.debug("Task found: {}", task);
                log.info("Completed task");
                return true;
            }
        }

        log.warn("Task could not be completed");
        return false;
    }

    public boolean deleteTask(int id) {
        log.info("Deleting task");
        for (Task task : tasks) {
            if (task.getId() == id) {
                tasks.remove(task);
                log.debug("Task found: {}", task);
                log.info("Deleted task");
                return true;
            }
        }

        log.warn("Task could not be deleted.");
        return false;
    }

    public int getRemainingTasks() {
        int count = 0;
        for (Task task : tasks) {
            if (!task.isCompleted()) {
                count++;
            }
        }
        return count;
    }

}
