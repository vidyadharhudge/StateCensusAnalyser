package com.statecensusanalyser.opencsv;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.BufferedReader;
import java.util.Iterator;

public class OpenCsv
{
    public static <E> Iterator<E> getCSVfile(BufferedReader reader, Class<E> csvClass)
    {
        return getcsvToBean(reader, csvClass).iterator();
    }
    public static <E> CsvToBean<E> getcsvToBean(BufferedReader reader, Class<E> csvClass)
    {
        CsvToBeanBuilder<E> csvToBeanBuilder = new CsvToBeanBuilder<E>(reader);
        csvToBeanBuilder.withType(csvClass);
        csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
        CsvToBean<E> csvToBean = csvToBeanBuilder.build();
        return csvToBean;
    }
}
