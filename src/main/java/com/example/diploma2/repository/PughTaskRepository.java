package com.example.diploma2.repository;

import com.example.diploma2.model.PughTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PughTaskRepository extends JpaRepository<PughTask, Long> {
}
