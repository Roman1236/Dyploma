package com.example.diploma2.service;

import com.example.diploma2.model.PughTask;
import com.example.diploma2.repository.PughTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PughTaskService {
    private final PughTaskRepository pughTaskRepository;

    @Autowired
    public PughTaskService(PughTaskRepository pughTaskRepository) {
        this.pughTaskRepository = pughTaskRepository;
    }

    public List<PughTask> getAllPughTasks() {
        return pughTaskRepository.findAll();
    }

    public PughTask savePughTask(PughTask pughTask) {
        return pughTaskRepository.save(pughTask);
    }
    // Додайте інші методи, які вам потрібні
}