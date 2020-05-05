package com.statecensusanalyser;

import com.statecensusanalyser.model.IndianStateCensusAnalyser;
import com.statecensusanalyser.model.IndianStateCode;

public class IndiaCensusDAO
{
    public String state;
    public String population;
    public String area;
    public String density;
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
}
