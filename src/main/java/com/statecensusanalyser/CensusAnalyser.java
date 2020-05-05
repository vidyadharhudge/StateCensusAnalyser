package com.statecensusanalyser;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class CensusAnalyser {
    public static void main(String[] args) {
        System.out.println("Welcome To Indian State Censes Analyser");
    }

    public static Integer readFile(String filePath) throws CensusAnalyserException {
        int count = 0;
        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(filePath));

            CsvToBean<IndianStateCensesAnalyzer> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(IndianStateCensesAnalyzer.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            Iterator<IndianStateCensesAnalyzer> stateCensesAnalyzerClassIterator = csvToBean.iterator();
            while (stateCensesAnalyzerClassIterator.hasNext()) {
                IndianStateCensesAnalyzer indianStateCensesAnalyzer = stateCensesAnalyzerClassIterator.next();
                count++;
            }
        } catch (IOException e) {
            throw new CensusAnalyserException(CensusAnalyserException.ExceptionType.FILE_NOT_FOUND, "Enter Correct File And Type");
        } catch (RuntimeException e) {
            throw new CensusAnalyserException(CensusAnalyserException.ExceptionType.WRONG_DELIMITER, "Check Delimiter And Header");
        }
        return count;
    }

}