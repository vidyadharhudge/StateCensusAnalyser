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

    List<E>censusCSVlist=null;

    public static void main(String[] args)
    {
        System.out.println("Welcome To Indian State Censes Analyser");
    }

    public int readFile(String filePath, Object E)
    {
        try
        {
            BufferedReader reader = Files.newBufferedReader(Paths.get(filePath));
            ICSVBuilder icsvBuilder=CSVBuilderFactory.createCSVBuilder();
            List<E>censusCSVlist=icsvBuilder.getCSVFileList(reader,E.getClass());
            return censusCSVlist.size();
        }
        catch (IOException e)
        {
            throw new CensusAnalyserException(CensusAnalyserException.ExceptionType.FILE_NOT_FOUND, "Enter Correct File And Type For State Censes Data");
        }
        catch (RuntimeException  e)
        {
            throw new CensusAnalyserException(CensusAnalyserException.ExceptionType.WRONG_DELIMITER, "Check Delimiter And Header For State Censes Data");
        }
    }

    private <E> int getCount(Iterator<E> iterator)
    {
        Iterable<E> csviterable=()->iterator;
        int numberOfEntries=(int)StreamSupport.stream(csviterable.spliterator(),false).count();
        return numberOfEntries;
    }

    public String getStateWiseSortedData(Object E)
    {
        if (censusCSVlist.size()==0 || censusCSVlist==null)
        {
            throw new CensusAnalyserException(CensusAnalyserException.ExceptionType.NO_CENSUS_DATA,"No Data Is Prsent");
        }
        Comparator<E>indianStateCensesAnalyzerComparator=Comparator.comparing(IndianStateCensesAnalyzer->IndianStateCensesAnalyzer.toString());
        this.sort(indianStateCensesAnalyzerComparator);
        String sortedCensusJson=new Gson().toJson(censusCSVlist);
        return sortedCensusJson;
    }

    public String getStateWiseSortedCode(Object E)
    {
        if (censusCSVlist.size()==0 || censusCSVlist==null)
        {
            throw new CensusAnalyserException(CensusAnalyserException.ExceptionType.NO_CENSUS_DATA,"No Data Is Prsent");
        }
        Comparator<E>indianStateCodeComparator=Comparator.comparing(IndianStateCode->IndianStateCode.toString());
        this.sort(indianStateCodeComparator);
        String sortedCensusJson=new Gson().toJson(censusCSVlist);
        return sortedCensusJson;
    }

    public void sort(Comparator<E>indianStatComparator)
    {
        for (int i = 0; i<censusCSVlist.size()-1; i++)
        {
            for (int j=0;j<censusCSVlist.size()-i-1; j++)
            {
                E censesAnalyzer1=censusCSVlist.get(j);
                E censesAnalyzer2=censusCSVlist.get(j+1);
                if(indianStatComparator.compare(censesAnalyzer1,censesAnalyzer2)>0)
                {
                    censusCSVlist.set(j,censesAnalyzer2);
                    censusCSVlist.set(j+1,censesAnalyzer1);
                }

            }
        }
    }

}
