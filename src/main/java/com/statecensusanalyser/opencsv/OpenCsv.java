package com.statecensusanalyser.opencsv;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.statecensusanalyser.ICSVBuilder;

import java.io.BufferedReader;
import java.util.Iterator;

public class OpenCsv implements ICSVBuilder
{
    @Override
    public Iterator<ICSVBuilder> getCSVfile(BufferedReader reader, Class csvClass)
    {
        CsvToBeanBuilder<ICSVBuilder> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
        csvToBeanBuilder.withType(csvClass);
        csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
        CsvToBean<ICSVBuilder> csvToBean = csvToBeanBuilder.build();
        return csvToBean.iterator();
    }
}
