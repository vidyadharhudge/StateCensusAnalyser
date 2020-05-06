package com.statecensusanalyser.model;

import com.opencsv.bean.CsvBindByName;

public class USCensusData
{
    @CsvBindByName(column = "State Id", required = true)
    public String StateId;

    @CsvBindByName(column = "State", required = true)
    private String State;

    @CsvBindByName(column = "Population", required = true)
    public String Population;

    @CsvBindByName(column = "Housing units", required = true)
    public String HousingUnits;

    @CsvBindByName(column = "Total area", required = true)
    public String TotalArea;

    @CsvBindByName(column = "Water area", required = true)
    public String WaterArea;

    @CsvBindByName(column = "Land area", required = true)
    public String LandArea;

    @CsvBindByName(column = "Population Density", required = true)
    public String PopulationDensity;

    @CsvBindByName(column = "Housing Density", required = true)
    private String HousingDensity;


    public String getStateId() {
        return StateId;
    }

    public void setStateId(String stateId) {
        StateId = stateId;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getPopulation() {
        return Population;
    }

    public void setPopulation(String population) {
        Population = population;
    }

    public String getHousingUnits() {
        return HousingUnits;
    }

    public void setHousingUnits(String housingUnits) {
        HousingUnits = housingUnits;
    }

    public String getTotalArea() {
        return TotalArea;
    }

    public void setTotalArea(String totalArea) {
        TotalArea = totalArea;
    }

    public String getWaterArea() {
        return WaterArea;
    }

    public void setWaterArea(String waterArea) {
        WaterArea = waterArea;
    }

    public String getLandArea() {
        return LandArea;
    }

    public void setLandArea(String landArea) {
        LandArea = landArea;
    }

    public String getPopulationDensity() {
        return PopulationDensity;
    }

    public void setPopulationDensity(String populationDensity) {
        PopulationDensity = populationDensity;
    }

    public String getHousingDensity() {
        return HousingDensity;
    }

    public void setHousingDensity(String housingDensity) {
        HousingDensity = housingDensity;
    }

    @Override
    public String toString() {
        return "USCensusData{" +
                "StateId='" + StateId + '\'' +
                ", State='" + State + '\'' +
                ", Population='" + Population + '\'' +
                ", HousingUnits='" + HousingUnits + '\'' +
                ", TotalArea='" + TotalArea + '\'' +
                ", WaterArea='" + WaterArea + '\'' +
                ", LandArea='" + LandArea + '\'' +
                ", PopulationDensity='" + PopulationDensity + '\'' +
                ", HousingDensity='" + HousingDensity + '\'' +
                '}';
    }
}
