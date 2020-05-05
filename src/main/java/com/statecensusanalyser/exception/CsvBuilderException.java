package com.statecensusanalyser.exception;

public class CsvBuilderException extends RuntimeException
{

    public enum ExceptionType
    {
        UNABLE_TO_PARSE;
    }
    public CsvBuilderException.ExceptionType type;
    public CsvBuilderException(CsvBuilderException.ExceptionType type, String message)
    {
        super(message);
        this.type=type;
        System.out.println(message);
    }

}
