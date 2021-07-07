package com.lambdaschool.webcountries;

public class Country {
    private String name;
    private double population;
    private double mass;
    private double medianAge;

    public Country(String name, double population, double mass, double medianAge) {
        this.name = name;
        this.population = population;
        this.mass = mass;
        this.medianAge = medianAge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPopulation() {
        return population;
    }

    public void setPopulation(double population) {
        this.population = population;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public double getMedianAge() {
        return medianAge;
    }

    public void setMedianAge(double medianAge) {
        this.medianAge = medianAge;
    }
}
