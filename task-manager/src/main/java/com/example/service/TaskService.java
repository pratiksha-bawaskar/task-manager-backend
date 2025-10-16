package com.example.service;

import java.util.*;

import com.example.model.Task;

public class TaskService {
    private final List<Task> taskList = new ArrayList<>();

    public void addTask(Task task) {
        taskList.add(task);
        System.out.println("Task added: " + task);
    }

    public void viewTasks() {
        if (taskList.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            taskList.forEach(System.out::println);
        }
    }

    public void deleteTask(int id) {
        Task toRemove = null;
        for (Task task : taskList) {
            if (task.getId() == id) {
                toRemove = task;
                break;
            }
        }
        if (toRemove != null) {
            taskList.remove(toRemove);
            System.out.println("Task deleted: " + toRemove);
        } else {
            System.out.println("Task not found.");
        }
    }
}