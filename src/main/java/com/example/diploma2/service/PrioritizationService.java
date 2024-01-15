package com.example.diploma2.service;

import com.example.diploma2.model.Task;
import com.example.diploma2.model.RiceTask;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrioritizationService {

    // Prioritization method: Value vs. Cost
    public List<Task> prioritizeValueVsCost(List<Task> tasks) {
        // Implement the prioritization logic here
        for (Task task : tasks) {
            double priority = calculatePriority(task);
            task.setPriority(priority);
        }
        return tasks;
    }

    // Add more prioritization methods as needed

    public List<RiceTask> prioritizeRICE(List<RiceTask> tasks) {
        // Реалізуйте логіку розрахунку RICE Score
        for (RiceTask task : tasks) {
            double riceScore = calculateRICEScore(task);
            task.setRiceScore(riceScore);
        }
        return tasks;
    }

    private double calculateRICEScore(RiceTask task) {
        // Реалізуйте формулу розрахунку RICE Score
        return (double) (task.getReach() * task.getImpact() * task.getConfidence()) / task.getEffort();
    }

    // Utility method to calculate priority based on your criteria
    private double calculatePriority(Task task) {
        // Implement your prioritization logic here
        // For example, priority = task.getValue() / task.getCost();
        return task.getValue() / task.getCost();
    }
}
