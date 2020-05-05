package com.statecensusanalyser.exception;

public class CensusAnalyserException extends RuntimeException
{
    public enum ExceptionType
    {
        FILE_NOT_FOUND,WRONG_DELIMITER,NO_CENSUS_DATA;
    }
    public CensusAnalyserException.ExceptionType type;
    public CensusAnalyserException(CensusAnalyserException.ExceptionType type, String message)
    {
        super(message);
        this.type=type;
        System.out.println(message);
    }
}
