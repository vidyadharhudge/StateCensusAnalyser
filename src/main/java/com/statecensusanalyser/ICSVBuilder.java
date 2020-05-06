package com.statecensusanalyser;

import com.statecensusanalyser.exception.CsvBuilderException;

import java.io.BufferedReader;
import java.util.Iterator;
import java.util.List;

public interface ICSVBuilder<E>
{
    public Iterator<E> getCSVfile(BufferedReader reader, Class<E> csvClass) throws CsvBuilderException;
}
