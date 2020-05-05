package com.statecensusanalyser;

import com.opencsv.bean.CsvBindByName;

public class IndianStateCode
{
    @CsvBindByName(column="SrNo",required = true)
    public String srNo;

    @CsvBindByName (column ="StateName",required = true)
    public String stateName;

    @CsvBindByName(column = "TIN",required = true)
    public String tin;

    @CsvBindByName(column = "StateCode",required = true)
    public String stateCode;

    @Override
    public String toString()
    {
        return "IndianStateCode{" +
                "srNo='" + srNo + '\'' +
                ", stateName='" + stateName + '\'' +
                ", tin='" + tin + '\'' +
                ", stateCode='" + stateCode + '\'' +
                '}';
    }
}
