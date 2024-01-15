package com.example.diploma2.service;

import com.example.diploma2.model.TwoByTwoMatrixTask;
import com.example.diploma2.repository.TwoByTwoMatrixTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TwoByTwoMatrixTaskService {
    private final TwoByTwoMatrixTaskRepository twoByTwoMatrixTaskRepository;

    @Autowired
    public TwoByTwoMatrixTaskService(TwoByTwoMatrixTaskRepository twoByTwoMatrixTaskRepository) {
        this.twoByTwoMatrixTaskRepository = twoByTwoMatrixTaskRepository;
    }

    public List<TwoByTwoMatrixTask> getAllTwoByTwoMatrixTasks() {
        return twoByTwoMatrixTaskRepository.findAll();
    }

    public TwoByTwoMatrixTask saveTwoByTwoMatrixTask(TwoByTwoMatrixTask task) {
        return twoByTwoMatrixTaskRepository.save(task);
    }
    // Додайте інші методи, які вам потрібні
}