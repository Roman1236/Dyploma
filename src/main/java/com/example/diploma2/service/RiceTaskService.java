package com.example.diploma2.service;

import com.example.diploma2.model.RiceTask;
import com.example.diploma2.repository.RiceTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class RiceTaskService {
    private final RiceTaskRepository riceTaskRepository;

    @Autowired
    public RiceTaskService(RiceTaskRepository riceTaskRepository) {
        this.riceTaskRepository = riceTaskRepository;
    }

    public List<RiceTask> getAllRiceTasks() {
        return riceTaskRepository.findAll();
    }

    public RiceTask saveRiceTask(RiceTask riceTask) {
        return riceTaskRepository.save(riceTask);
    }
    // Додайте інші методи, які вам потрібні
}