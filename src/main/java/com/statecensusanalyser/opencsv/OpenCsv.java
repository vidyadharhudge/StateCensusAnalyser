package com.statecensusanalyser.opencsv;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.statecensusanalyser.ICSVBuilder;
import com.statecensusanalyser.exception.CsvBuilderException;

import java.io.BufferedReader;
import java.util.Iterator;
import java.util.List;

public class OpenCsv implements ICSVBuilder

{
    public Iterator<ICSVBuilder> getCSVfile(BufferedReader reader, Class csvClass) throws CsvBuilderException
    {
        return getcsvToBean(reader, csvClass).iterator();
    }

    @Override
    public List<ICSVBuilder> getCSVFileList(BufferedReader reader, Class csvClass) throws CsvBuilderException
    {
        return getcsvToBean(reader, csvClass).parse();
    }

    public static <E> CsvToBean<E> getcsvToBean(BufferedReader reader, Class<E> csvClass) throws CsvBuilderException
    {
        try
        {
            CsvToBeanBuilder<E> csvToBeanBuilder = new CsvToBeanBuilder<E>(reader);
            csvToBeanBuilder.withType(csvClass);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<E> csvToBean = csvToBeanBuilder.build();
            return csvToBean;
        }
        catch (IllegalStateException e)
        {
            throw new CsvBuilderException(CsvBuilderException.ExceptionType.UNABLE_TO_PARSE,e.getMessage());
        }
    }
}
