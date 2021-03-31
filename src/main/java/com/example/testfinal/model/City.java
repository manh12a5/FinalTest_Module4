package com.example.testfinal.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String name;
    @ManyToOne
    private Nation nation;
    @Min(1)
    private double area;
    @Min(1)
    private int population;
    @Min(1)
    private Long GDP;
    @NotEmpty
    private String description;

    public City() {
    }

    public City(Long id, String name, Nation nation, @Min(1) double area, @Min(1) int population, @Min(1) Long GDP, String description) {
        this.id = id;
        this.name = name;
        this.nation = nation;
        this.area = area;
        this.population = population;
        this.GDP = GDP;
        this.description = description;
    }

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

    public Nation getNation() {
        return nation;
    }

    public void setNation(Nation nation) {
        this.nation = nation;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public Long getGDP() {
        return GDP;
    }

    public void setGDP(Long GDP) {
        this.GDP = GDP;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
