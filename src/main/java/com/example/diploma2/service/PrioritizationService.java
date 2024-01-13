package com.example.diploma2.service;

import com.example.diploma2.model.Task;
import com.example.diploma2.model.PrioritizationResult;

import java.util.List;

public interface PrioritizationService {
    List<PrioritizationResult> prioritizeByValueToCost(List<Task> tasks);
    // Додайте інші методи для інших методів пріоритезації, якщо потрібно
}
