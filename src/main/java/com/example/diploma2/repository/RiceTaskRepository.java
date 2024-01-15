package com.example.diploma2.repository;

import com.example.diploma2.model.RiceTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RiceTaskRepository extends JpaRepository<RiceTask, Long> {
}
