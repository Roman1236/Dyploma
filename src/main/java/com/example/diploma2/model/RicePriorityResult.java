package com.example.diploma2.model;

public class RicePriorityResult implements Comparable<RicePriorityResult> {
    private String name;
    private double riceScore;

    public RicePriorityResult(String name, double riceScore) {
        this.name = name;
        this.riceScore = riceScore;
    }

    public String getName() {
        return name;
    }

    public double getRiceScore() {
        return riceScore;
    }

    @Override
    public int compareTo(RicePriorityResult other) {
        // Сортування за спаданням RICE Score
        return Double.compare(other.riceScore, this.riceScore);
    }
}
