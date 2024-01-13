package com.example.diploma2.repository;

import com.example.diploma2.model.PrioritizationResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrioritizationResultRepository extends JpaRepository<PrioritizationResult, Long> {
}
