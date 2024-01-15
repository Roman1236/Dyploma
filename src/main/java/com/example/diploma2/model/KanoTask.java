package com.example.diploma2.model;

import javax.persistence.*;
@Entity
@Table(name = "kano_tasks")
public class KanoTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "product_satisfaction")
    private double productSatisfaction;

    @Column(name = "functionality")
    private double functionality;

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

    public double getProductSatisfaction() {
        return productSatisfaction;
    }

    public void setProductSatisfaction(double productSatisfaction) {
        this.productSatisfaction = productSatisfaction;
    }

    public double getFunctionality() {
        return functionality;
    }

    public void setFunctionality(double functionality) {
        this.functionality = functionality;
    }
}