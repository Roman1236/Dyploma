package com.example.diploma2.controller;

import com.example.diploma2.model.PrioritizationResult;
import com.example.diploma2.model.Task;
import com.example.diploma2.service.PrioritizationService;
import com.example.diploma2.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;
    private final PrioritizationService prioritizationService;

    @Autowired
    public TaskController(TaskService taskService, PrioritizationService prioritizationService) {
        this.taskService = taskService;
        this.prioritizationService = prioritizationService;
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping("/prioritize")
    public List<PrioritizationResult> prioritizeTasks(@RequestBody List<Task> tasks) {
        List<PrioritizationResult> results = prioritizationService.prioritizeByValueToCost(tasks);
        taskService.saveTasks(tasks);
        return results;
    }

    // Додаткові методи для створення, оновлення і видалення задач
}
