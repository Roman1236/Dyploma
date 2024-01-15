package com.example.diploma2.service;

import com.example.diploma2.model.KanoTask;
import com.example.diploma2.repository.KanoTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class KanoTaskService {
    private final KanoTaskRepository kanoTaskRepository;

    @Autowired
    public KanoTaskService(KanoTaskRepository kanoTaskRepository) {
        this.kanoTaskRepository = kanoTaskRepository;
    }

    public List<KanoTask> getAllKanoTasks() {
        return kanoTaskRepository.findAll();
    }

    public KanoTask saveKanoTask(KanoTask kanoTask) {
        return kanoTaskRepository.save(kanoTask);
    }
    // Додайте інші методи, які вам потрібні
}