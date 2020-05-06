package com.statecensusanalyser;

import com.statecensusanalyser.model.IndianStateCensusAnalyser;
import com.statecensusanalyser.model.IndianStateCode;

public class IndiaCensusDAO<E>
{ private String state;
    private int population;
    private int area;
    private int density;
    private String stateCode;
    private int srNo;
    private String stateName;
    private int tin;
    IndianStateCensusAnalyser indianStateCensesAnalyzer;
    IndianStateCode indianStateCode;

    public IndiaCensusDAO(IndianStateCensusAnalyser indianStateCensesAnalyzer) {
        state = indianStateCensesAnalyzer.getState();
        population = indianStateCensesAnalyzer.getPopulation();
        area = indianStateCensesAnalyzer.getArea();
        density = indianStateCensesAnalyzer.getDensity();
    }
    public IndiaCensusDAO(IndianStateCode indianStateCode) {
        stateCode = indianStateCode.getStateCode();
        srNo = indianStateCode.getSrNo();
        stateName = indianStateCode.getStateName();
        tin = indianStateCode.getTin();
    }

    public IndiaCensusDAO(Class<E> csvClass) {
    }
    public String getState () {
        return state;
    }

    public void setState (String state){
        this.state = indianStateCensesAnalyzer.getState();
    }

    public int getPopulation () {
        return population;
    }

    public void setPopulation ( int population){
        this.population=indianStateCensesAnalyzer.getPopulation();
    }

    public int getArea () {
        return area;
    }

    public void setArea ( int area){
        this.area = indianStateCensesAnalyzer.getArea();
    }

    public int getDensity () {
        return density;
    }

    public void setDensity ( int density){
        this.density = indianStateCensesAnalyzer.getDensity();
    }

    public String getStateCode () {
        return stateCode;
    }

    public void setStateCode (String stateCode){
        this.stateCode = indianStateCode.getStateCode();
    }

    public int getSrNo () {
        return srNo;
    }

    public void setSrNo ( int srNo){
        this.srNo = indianStateCode.getSrNo();
    }

    public String getStateName () {
        return stateName;
    }

    public void setStateName (String stateName){
        this.stateName = indianStateCode.getStateName();
    }

    public int getTin () {
        return tin;
    }

    public void setTin ( int tin){
        this.tin = indianStateCode.getTin();
    }
}
