package com.statecensusanalyser.model;

import com.opencsv.bean.CsvBindByName;

public class IndianStateCensusAnalyser
{
    @CsvBindByName(column="State")
    public String state;

    @CsvBindByName (column ="Population")
    public int population;

    @CsvBindByName(column = "AreaInSqKm")
    public int area;

    @CsvBindByName (column = "DensityPerSqKm")
    public int density;


    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getDensity() {
        return density;
    }

    public void setDensity(int density) {
        this.density = density;
    }

    @Override
    public String toString() {
        return "IndianStateCensesAnalyzer{" +
                "state='" + state + '\'' +
                ", population=" + population +
                ", area=" + area +
                ", density=" + density +
                '}';
    }
}
