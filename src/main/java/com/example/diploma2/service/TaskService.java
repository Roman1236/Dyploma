package com.example.diploma2.service;

import com.example.diploma2.model.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAllTasks();
    void saveTask(Task task);
    void saveTasks(List<Task> tasks); // Доданий метод для збереження списку задач
    Task getTaskById(Long id);
    void deleteTask(Long id);
}
