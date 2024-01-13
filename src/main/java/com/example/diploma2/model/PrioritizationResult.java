package com.example.diploma2.model;

import javax.persistence.*;

@Entity
public class PrioritizationResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String methodName;
    private Double prioritizationScore;

    public PrioritizationResult() {
    }

    public PrioritizationResult(String methodName, Double prioritizationScore) {
        this.methodName = methodName;
        this.prioritizationScore = prioritizationScore;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Double getPrioritizationScore() {
        return prioritizationScore;
    }

    public void setPrioritizationScore(Double prioritizationScore) {
        this.prioritizationScore = prioritizationScore;
    }
}
