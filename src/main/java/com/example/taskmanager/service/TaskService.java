package com.example.taskmanager.service;

import com.example.taskmanager.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TaskService {
    private final ArrayList<Task> tasks = new ArrayList<>();
    private int nextId = 1;

    public TaskService() {
    }

    public ArrayList<Task> getAllTasks() {
        return tasks;
    }

    public boolean addTask(String title) {
        Task task = new Task(nextId, title);

        if (tasks.add(task)) {
            nextId++;
            return true;
        }

        return false;
    }


}
