package com.example.diploma2.repository;

import com.example.diploma2.model.KanoTask;
import com.example.diploma2.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface KanoTaskRepository extends JpaRepository<KanoTask, Long> {
}
