package com.example.diploma2.repository;

import com.example.diploma2.model.TwoByTwoMatrixTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TwoByTwoMatrixTaskRepository extends JpaRepository<TwoByTwoMatrixTask, Long> {
}

