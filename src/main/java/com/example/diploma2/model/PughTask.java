package com.example.diploma2.model;

import javax.persistence.*;
@Entity
@Table(name = "pugh_tasks")
public class PughTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "criteria1")
    private double criteria1;

    @Column(name = "criteria2")
    private double criteria2;

    @Column(name = "criteria3")
    private double criteria3;

    @Column(name = "criteria4")
    private double criteria4;

    @Column(name = "criteria5")
    private double criteria5;

    @Column(name = "criteria6")
    private double criteria6;

    @Column(name = "criteria7")
    private double criteria7;

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

    public double getCriteria1() {
        return criteria1;
    }

    public void setCriteria1(double criteria1) {
        this.criteria1 = criteria1;
    }

    public double getCriteria2() {
        return criteria2;
    }

    public void setCriteria2(double criteria2) {
        this.criteria2 = criteria2;
    }

    public double getCriteria3() {
        return criteria3;
    }

    public void setCriteria3(double criteria3) {
        this.criteria3 = criteria3;
    }

    public double getCriteria4() {
        return criteria4;
    }

    public void setCriteria4(double criteria4) {
        this.criteria4 = criteria4;
    }

    public double getCriteria5() {
        return criteria5;
    }

    public void setCriteria5(double criteria5) {
        this.criteria5 = criteria5;
    }

    public double getCriteria6() {
        return criteria6;
    }

    public void setCriteria6(double criteria6) {
        this.criteria6 = criteria6;
    }

    public double getCriteria7() {
        return criteria7;
    }

    public void setCriteria7(double criteria7) {
        this.criteria7 = criteria7;
    }

    public double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(double totalScore) {
        this.totalScore = totalScore;
    }
}