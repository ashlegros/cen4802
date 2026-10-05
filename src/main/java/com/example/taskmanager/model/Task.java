package com.example.taskmanager.model;

public class Task {
    private int id;
    private String title;
    private boolean completed;
    private String priority;

    public Task(int id, String title, String priority) {
        this.id = id;
        this.title = title;
        this.completed = false;
        this.priority = priority;
    }

    public Task(int id, String title) {
        this.id = id;
        this.title = title;
        this.completed = false;
        this.priority = "Low";
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public boolean isCompleted() {
        return completed;
    }
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
    public void setCompletedTrue() {
        this.completed = true;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
