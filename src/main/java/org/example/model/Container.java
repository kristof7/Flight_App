package org.example.model;

public class Container {
    private Integer id;
    private Integer weight;
    private WeightUnit weightUnit;
    private Integer pieces;


    public Integer getId() {
        return id;
    }

    public Integer getWeight() {
        return weight;
    }

    public WeightUnit getWeightUnit() {
        return weightUnit;
    }

    public Integer getPieces() {
        return pieces;
    }

    @Override
    public String toString() {
        return "Container{" +
                "id=" + id +
                ", weight=" + weight +
                ", weightUnit=" + weightUnit +
                ", pieces=" + pieces +
                '}';
    }
}
