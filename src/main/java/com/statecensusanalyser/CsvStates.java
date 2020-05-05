package com.statecensusanalyser;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class CsvStates
{
    public static int loadIndianStateCodes(String StateCodefilePath)
    {
        int count=0;
        try
        {
            BufferedReader reader= Files.newBufferedReader(Paths.get(StateCodefilePath));
            CsvToBean<IndianStateCode> csvToBean= new CsvToBeanBuilder(reader)
                    .withType(IndianStateCode.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            Iterator<IndianStateCode> indianStateCodeIterator=csvToBean.iterator();
            while (indianStateCodeIterator.hasNext())
            {
                IndianStateCode indianStateCode=indianStateCodeIterator.next();
                count++;
            }
        }
        catch ( IOException e)
        {
            throw new CensusAnalyserException(CensusAnalyserException.ExceptionType.FILE_NOT_FOUND,"Enter Correct File And Type For State Code");
        }
        catch ( RuntimeException e)
        {
            throw new CensusAnalyserException(CensusAnalyserException.ExceptionType.WRONG_DELIMITER,"Check Delimiter And Header For State Code");
        }
        return count;
    }

}
