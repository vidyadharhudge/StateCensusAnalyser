package com.statecensusanalyser.dto;

import com.opencsv.bean.CsvBindByName;

public class IndiaCensesCsv
{
    @CsvBindByName(column="State")
    public String state;

    @CsvBindByName (column ="Population")
    public int population;

    @CsvBindByName(column = "AreaInSqKm")
    public int area;

    @CsvBindByName(column = "DensityPerSqKm")
    public int density;

    @Override
    public String toString() {
        return "IndiaCensesCsv{" +
                "state='" + state + '\'' +
                ", population=" + population +
                ", area=" + area +
                ", density=" + density +
                '}';
    }
}
