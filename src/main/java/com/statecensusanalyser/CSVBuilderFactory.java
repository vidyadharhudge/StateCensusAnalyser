package com.statecensusanalyser;

import com.statecensusanalyser.opencsv.OpenCsv;

public class CSVBuilderFactory
{

    public static ICSVBuilder createCSVBuilder()
    {
        return new OpenCsv();
    }
}
