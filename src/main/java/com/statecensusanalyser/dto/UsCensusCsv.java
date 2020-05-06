package com.statecensusanalyser.dto;

import com.opencsv.bean.CsvBindByName;

public class UsCensusCsv
{

    @CsvBindByName(column = "State Id", required = true)
    public String StateId;

    @CsvBindByName(column = "State", required = true)
    private String State;

    @CsvBindByName(column = "Population", required = true)
    public String Population;

    @CsvBindByName(column = "Total area", required = true)
    public String TotalArea;

    @CsvBindByName(column = "Population Density", required = true)
    public String PopulationDensity;

    @Override
    public String toString() {
        return "UsCensusCsv{" +
                "StateId='" + StateId + '\'' +
                ", State='" + State + '\'' +
                ", Population='" + Population + '\'' +
                ", TotalArea='" + TotalArea + '\'' +
                ", PopulationDensity='" + PopulationDensity + '\'' +
                '}';
    }
}
