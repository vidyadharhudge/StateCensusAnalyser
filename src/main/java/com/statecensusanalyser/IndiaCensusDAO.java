package com.statecensusanalyser;

import com.statecensusanalyser.model.IndianStateCensusAnalyser;
import com.statecensusanalyser.model.IndianStateCode;

public class IndiaCensusDAO
{ public String state;
    public int population;
    public int area;
    public int density;
    public String stateCode;
    public IndiaCensusDAO(IndianStateCensusAnalyser indianStateCensesAnalyzer)
    {
        state=indianStateCensesAnalyzer.getState();
        population=indianStateCensesAnalyzer.getPopulation();
        area=indianStateCensesAnalyzer.getArea();
        density=indianStateCensesAnalyzer.getDensity();
    }
    public IndiaCensusDAO(IndianStateCode indianStateCode)
    {
        stateCode=indianStateCode.getStateCode();
    }

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

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }
}

