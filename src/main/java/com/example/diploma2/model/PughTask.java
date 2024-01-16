package com.example.diploma2.model;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "pugh_tasks")
public class PughTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name; // Added Task Name field

    @ElementCollection
    @CollectionTable(name = "pugh_criteria_importance")
    @MapKeyColumn(name = "criterion")
    @Column(name = "importance")
    private Map<String, Double> criteriaImportance = new HashMap<>();

    @ElementCollection
    @CollectionTable(name = "pugh_criteria_scores")
    @MapKeyColumn(name = "criterion")
    @Column(name = "score")
    private Map<String, Double> criteriaScores = new HashMap<>();

    @Column(name = "total_score")
    private double totalScore;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Double> getCriteriaImportance() {
        return criteriaImportance;
    }

    public void setCriteriaImportance(Map<String, Double> criteriaImportance) {
        this.criteriaImportance = criteriaImportance;
    }

    public Map<String, Double> getCriteriaScores() {
        return criteriaScores;
    }

    public void setCriteriaScores(Map<String, Double> criteriaScores) {
        this.criteriaScores = criteriaScores;
    }

    public double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(double totalScore) {
        this.totalScore = totalScore;
    }

    public double calculateTotalScore() {
        double totalScore = 0;
        for (Map.Entry<String, Double> entry : criteriaImportance.entrySet()) {
            String criterion = entry.getKey();
            double importance = entry.getValue();
            double score = criteriaScores.getOrDefault(criterion, 0.0);
            totalScore += importance * score;
        }
        return totalScore;
    }
}
