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
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class CensusAnalyser<E>
{

    List<E>censusCSVlist=null;
    Map<String,E> censusMap;
    public static void main(String[] args)
    {
        System.out.println("Welcome To Indian State Censes Analyser");
    }
    public CensusAnalyser()
    {
        censusMap=new HashMap<>();
    }
    public int readFile(String filePath, Class<E>csvClass)
    {
        try
        {
            BufferedReader reader = Files.newBufferedReader(Paths.get(filePath));
            ICSVBuilder icsvBuilder=CSVBuilderFactory.createCSVBuilder();
            Iterator<E>censusCsvIterator=icsvBuilder.getCSVfile(reader,csvClass);
            Iterable<E>iterable=()->censusCsvIterator;
            while (censusCsvIterator.hasNext())
            {
                IndiaCensusDAO value=new IndiaCensusDAO((IndianStateCensusAnalyser) censusCsvIterator.next());
                this.censusMap.put(value.state,(E)value);
                censusCSVlist=censusMap.values().stream().collect(Collectors.toList());
            }
            int noOfRecords=censusMap.size();
            return noOfRecords;
        } catch (IOException e)
        {
            throw new CensusAnalyserException(CensusAnalyserException.ExceptionType.FILE_NOT_FOUND, "Enter Correct File And Type For State Censes Data");
        }
        catch (RuntimeException  e)
        {
            throw new CensusAnalyserException(CensusAnalyserException.ExceptionType.WRONG_DELIMITER, "Check Delimiter And Header For State Censes Data");
        }
    }
    // no of entries in Csv File
    private <E> int getCount(Iterator<E> iterator)
    {
        Iterable<E> csviterable=()->iterator;
        int numberOfEntries=(int)StreamSupport.stream(csviterable.spliterator(),false).count();
        return numberOfEntries;
    }
    // State Wise Sorted Code
    public String SortedCode(Object E)
    {
        if (censusCSVlist.size()==0 || censusCSVlist==null)
        {
            throw new CensusAnalyserException(CensusAnalyserException.ExceptionType.NO_CENSUS_DATA,"No Data Is Prsent");
        }
        Comparator<E>indianStateCodeComparator=Comparator.comparing(censusCsv->E.toString());
        this.sort(indianStateCodeComparator,censusCSVlist);
        String sortedCensusJson=new Gson().toJson(censusCSVlist);
        return sortedCensusJson;
    }
    // Sorting Methode
    public void sort(Comparator<E>indianStateCodeComparator,List<E>censusCSVlist)
    {
        for (int i = 0; i<censusCSVlist.size()-1; i++)
        {
            for (int j=0;j<censusCSVlist.size()-i-1; j++)
            {
                E censesAnalyzer1=censusCSVlist.get(j);
                E censesAnalyzer2=censusCSVlist.get(j+1);
                if(indianStateCodeComparator.compare(censesAnalyzer1,censesAnalyzer2)>0)
                {
                    censusCSVlist.set(j,censesAnalyzer2);
                    censusCSVlist.set(j+1,censesAnalyzer1);
                }
            }
        }
    }
}

