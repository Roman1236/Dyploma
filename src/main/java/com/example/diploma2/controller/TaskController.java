package com.example.diploma2.controller;

import com.example.diploma2.model.Task;
import com.example.diploma2.service.PrioritizationService;
import com.example.diploma2.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {

    private final TaskService taskService;
    private final PrioritizationService prioritizationService;

    @Autowired
    public TaskController(TaskService taskService, PrioritizationService prioritizationService) {
        this.taskService = taskService;
        this.prioritizationService = prioritizationService;
    }

    @PostMapping("/prioritize")
    public ResponseEntity<List<Task>> prioritizeTasks(@RequestBody List<Task> tasks) {
        List<Task> prioritizedTasks = prioritizationService.prioritizeValueVsCost(tasks);
        taskService.saveAllTasks(prioritizedTasks); // Assuming TaskService has a saveAllTasks method
        return ResponseEntity.ok(prioritizedTasks);
    }
//    @PostMapping("/prioritize")
//    public ResponseEntity<List<Task>> prioritizeTasks(@RequestBody List<Task> tasks,
//                                                      @RequestParam String method) {
//        List<Task> prioritizedTasks;
//        switch (method) {
//            case "RICE":
//                prioritizedTasks = prioritizationService.prioritizeRICE(tasks);
//                break;
//            // Інші випадки для різних методів
//            default:
//                throw new IllegalArgumentException("Невідомий метод пріоритизації");
//        }
//        taskService.saveAllTasks(prioritizedTasks);
//        return ResponseEntity.ok(prioritizedTasks);
//    }


    @GetMapping("/getAllTasks")
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    @PostMapping("/tasks")
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        // Handle the creation of the task, e.g., save it to the database
        Task createdTask = taskService.saveTask(task);

        // Return a response with the created task (you can also include additional data)
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }

}
