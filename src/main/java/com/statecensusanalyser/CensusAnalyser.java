package com.statecensusanalyser;
import com.google.gson.Gson;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.statecensusanalyser.exception.CensusAnalyserException;
import com.statecensusanalyser.model.IndianStateCensusAnalyser;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.StreamSupport;

public class CensusAnalyser<E>
{

    // welcome message
    public static void main(String[] args)
    {
        System.out.println("Welcome To Indian State Censes Analyser");
    }
    ///Read State Census Data CSV file
    //Iterable is interface allow object to make use of for each loop it does internally by calling iterator methode object
    //spliterator() It helps in processing the collection data in parallel
    public Integer readFile(String filePath, Object E)
    {
        int noOfRecords = 0;
        try
        {
            BufferedReader reader = Files.newBufferedReader(Paths.get(filePath));
            Iterator<E> stateCensesAnalyzerIterator = (Iterator<E>)this.getCSVfile(reader, E.getClass());
            while (stateCensesAnalyzerIterator.hasNext())
            {
                stateCensesAnalyzerIterator.next();
                noOfRecords++;
            }
        }
        catch (IOException e)
        {
            throw new CensusAnalyserException(CensusAnalyserException.ExceptionType.FILE_NOT_FOUND, "Enter Correct File And Type For State Censes Data");
        }
        catch (RuntimeException e)
        {
            throw new CensusAnalyserException(CensusAnalyserException.ExceptionType.WRONG_DELIMITER, "Check Delimiter And Header For State Censes Data");
        }
        return noOfRecords;
    }
    // Open Csv Code
    private <E> Iterator<E> getCSVfile(BufferedReader reader, Class<E> csvClass)
    {
        CsvToBeanBuilder<E> csvToBeanBuilder = new CsvToBeanBuilder<E>(reader);
        csvToBeanBuilder.withType(csvClass);
        csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
        CsvToBean<E> csvToBean = csvToBeanBuilder.build();
        return csvToBean.iterator();


    }

}