package com.example.diploma2.model;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "value")
    private double value;

    @Column(name = "cost")
    private double cost;

    @Column(name = "priority")
    private double priority; // Нове поле для пріоритету




    public Task() {
        }

    public void setValue(double value) {
        this.value = value;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getPriority() {
        return priority;
    }

    public void setPriority(double priority) {
        this.priority = priority;
    }

    public Task(String name, Double cost, Double value) {
        this.name = name;
        this.cost = cost;
        this.value = value;
    }

    // Геттери та сеттери для полів
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

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
