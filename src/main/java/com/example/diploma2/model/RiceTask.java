package com.example.diploma2.model;

import javax.persistence.*;

@Entity
@Table(name = "rice_tasks")
public class RiceTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "reach")
    private double reach;

    @Column(name = "impact")
    private double impact;

    @Column(name = "confidence")
    private double confidence;

    @Column(name = "effort")
    private double effort;

    @Column(name = "rice_score")
    private double riceScore;

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

    public double getReach() {
        return reach;
    }

    public void setReach(double reach) {
        this.reach = reach;
    }

    public double getImpact() {
        return impact;
    }

    public void setImpact(double impact) {
        this.impact = impact;
    }

    public double getConfidence() {
        return confidence;
    }

    public void setConfidence(double confidence) {
        this.confidence = confidence;
    }

    public double getEffort() {
        return effort;
    }

    public void setEffort(double effort) {
        this.effort = effort;
    }

    public double getRiceScore() {
        return riceScore;
    }

    public void setRiceScore(double riceScore) {
        this.riceScore = riceScore;
    }
}