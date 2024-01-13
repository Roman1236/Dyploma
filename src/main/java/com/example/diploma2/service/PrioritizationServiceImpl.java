package com.example.diploma2.service;

import com.example.diploma2.model.PrioritizationResult;
import com.example.diploma2.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class PrioritizationServiceImpl implements PrioritizationService {

    @Override
    public List<PrioritizationResult> prioritizeByValueToCost(List<Task> tasks) {
        List<PrioritizationResult> results = new ArrayList<>();

        for (Task task : tasks) {
            double prioritizationScore = calculatePriority(task);
            PrioritizationResult result = new PrioritizationResult();
            result.setMethodName("Цінність проти витрат");
            result.setPrioritizationScore(prioritizationScore);
            results.add(result);
        }

        results.sort(Comparator.comparingDouble(PrioritizationResult::getPrioritizationScore).reversed());
        return results;
    }

    private double calculatePriority(Task task) {
        // Реалізуйте обчислення пріоритету відповідно до бажаних правил
        // У цьому методі ви можете використовувати всі дані з класу Task,
        // щоб розрахувати пріоритет і повернути його як результат.
        return task.getValue() / task.getCost();
    }

    // Додайте інші методи для інших методів пріоритезації
}
