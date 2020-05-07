import com.google.gson.Gson;
import com.statecensusanalyser.CensusAnalyser;
import com.statecensusanalyser.dao.IndiaCensusDAO;
import com.statecensusanalyser.exception.CensusAnalyserException;
import com.statecensusanalyser.model.IndianStateCensusAnalyser;
import com.statecensusanalyser.model.IndianStateCode;
import com.statecensusanalyser.model.USCensusData;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.statecensusanalyser.FilePath.*;

public class CensusAnalyserTest {

    CensusAnalyser censusAnalyser;

    @Before
    public void setup() {
        censusAnalyser = new CensusAnalyser();
    }

    /* Tc 1.1 :Given The State Census Csv File, Check To Ensure The Number Of Record Matches */
    @Test
    public void givenFilePath_WhenNoOfRecordMatches_ThenReturnTrue() {
        try {
            int noOfRecords = censusAnalyser.readFile(INDIA_CENSUS_CSV_FILE_PATH, IndianStateCensusAnalyser.class);
            Assert.assertEquals(29, noOfRecords);}
        catch (CensusAnalyserException e) {
            e.printStackTrace(); }
    }

    /* T.C 1.2 :Given State Censes Csv File Is Incorrect Then Returns Custom Exception */
    @Test
    public void givenStateCensusData_WhenWithWrongFile_ThenShouldThrowException() {
        try {
            censusAnalyser.readFile(WRONG_CSV_FILE_PATH, IndianStateCensusAnalyser.class);}
        catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.FILE_NOT_FOUND, e.type); }
    }

    /* T.C 1.3 :Given State Censes Csv Type Is Incorrect Then Returns Custom Exception */
    @Test
    public void givenStateCensusData_WhenWithWrongType_ThenShouldThrowException() {
        try {
            censusAnalyser.readFile(WRONG_CSV_FILE_TYPE, IndianStateCensusAnalyser.class);}
        catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.FILE_NOT_FOUND, e.type); }
    }

    /* T.C 1.4 :Given State Censes Csv file Is Correct But With Wrong Delimiter Should Rhrow Custom Exception */
    @Test
    public void givenStateCensusData_WhenWithWrongDelimiter_ThenShouldThrowException() {
        try {
            censusAnalyser.readFile(WRONG_DELIMITER_FILE, IndianStateCensusAnalyser.class);}
        catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.WRONG_DELIMITER, e.type); }
    }

    /* T.C 1.5 :Given State Censes Csv file Is Correct But With Wrong Header Should Rhrow Custom Exception */
    @Test
    public void givenStateCensusData_WhenWithWrongHeader_ThenShouldThrowException() {
        try {
            censusAnalyser.readFile(WRONG_DELIMITER_FILE, IndianStateCensusAnalyser.class);}
         catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.WRONG_DELIMITER, e.type); }
    }

    /* Tc 2.1 :Given The State code Csv File, Check To Ensure The Number Of Record Matches */
    @Test
    public void givenFilePathOfStateCode_WhenNoOfRecordMatches_ThenReturnTrue() {
        try {
            int noOfRecords = censusAnalyser.readFile(STATE_CODE_CSV_FILE, IndianStateCode.class);
            Assert.assertEquals(37, noOfRecords);}
        catch (CensusAnalyserException e) {
        }
    }

    /* T.C 2.2 :Given State Code Csv File Is Incorrect Then Returns Custom Exception */
    @Test
    public void givenStateCodeData_WhenWithWrongFile_ThenShouldThrowException() {
        try {
            censusAnalyser.readFile(WRONG_CSV_FILE_PATHS, IndianStateCode.class);}
         catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.FILE_NOT_FOUND, e.type); }
    }

    /* T.C 2.3 :Given State Code Csv Type Is Incorrect Then Returns Custom Exception */
    @Test
    public void givenStateCodeData_WhenWithWrongType_ThenShouldThrowException() {
        try {
            censusAnalyser.readFile(WRONG_CSV_FILE_TYPES, IndianStateCode.class);}
        catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.FILE_NOT_FOUND, e.type); }
    }

    /* T.C 2.4 :Given State Code Csv file Is Correct But With Wrong Delimiter Should Throw Custom Exception */
    @Test
    public void givenStateCodeData_WhenWithWrongDelimiter_ThenShouldThrowException() {
        try {
            censusAnalyser.readFile(WRONG_DELIMITER_FILES, IndianStateCode.class);}
        catch (CensusAnalyserException e){
            Assert.assertEquals(CensusAnalyserException.ExceptionType.WRONG_DELIMITER, e.type); }
    }

    /* T.C 2.5 :Given State Code Csv file Is Correct But With Wrong Header Should Rhrow Custom Exception */
    @Test
    public void givenStateCodeData_WhenWithWrongHeader_ThenShouldThrowException() {
        try {
            censusAnalyser.readFile(WRONG_DELIMITER_FILES, IndianStateCode.class);}
         catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.WRONG_DELIMITER, e.type); }
    }

    /* T.C 3 :Indian Census Data In Sorted Form  */
    @Test
    public void givenIndianCensusData_WhenSorted_ThenShouldReturnSortedDataStartStateAndEndStat() {
        try {
            censusAnalyser.readFile(INDIA_CENSUS_CSV_FILE_PATH, IndianStateCensusAnalyser.class);
            String sortedData = censusAnalyser.SortedCode(2,IndianStateCensusAnalyser.class);
            IndianStateCensusAnalyser[] indianStateCensesAnalyzers = new Gson().fromJson(sortedData, IndianStateCensusAnalyser[].class);
            Assert.assertEquals("Andhra Pradesh", indianStateCensesAnalyzers[0].getState());}
        catch (CensusAnalyserException e) {
        }
    }

    /* T.C 4 :Indian Code In Sorted Form  */
    @Test
    public void givenIndianCensusCode_WhenSorted_ThenShouldReturnSortedCodeStartCodeAndEndCode() {
        try {
            censusAnalyser.readFile(STATE_CODE_CSV_FILE, IndianStateCode.class);
            String sortedData = censusAnalyser.SortedCode(6,IndianStateCode.class);
            IndianStateCode[] indianStateCodes = new Gson().fromJson(sortedData, IndianStateCode[].class);
            Assert.assertEquals("AD", indianStateCodes[0].getStateCode());
            Assert.assertEquals("WB", indianStateCodes[36].getStateCode());}
        catch (CensusAnalyserException e) {
        }
    }

    /* T.C 5 :Indian Census Population In Sorted Form  */
    @Test
    public void givenIndianCensusCode_WhenSorted_ThenShouldReturnSortedPopulation() {
        try {
            censusAnalyser.readFile(INDIA_CENSUS_CSV_FILE_PATH, IndianStateCensusAnalyser.class);
            String sortedData = censusAnalyser.SortedCode(3,IndiaCensusDAO.class);
            IndianStateCensusAnalyser[] indianStateCensesAnalyzers = new Gson().fromJson(sortedData, IndianStateCensusAnalyser[].class);
            Assert.assertEquals(1980602, indianStateCensesAnalyzers[28].getPopulation());}
         catch (CensusAnalyserException e) {
        }
    }

    /* T.C 6 :Indian Census Density In Sorted Form  */
    @Test
    public void givenIndianCensusData_WhenSorted_ThenShouldReturnSortedDensity() {
        try {
            censusAnalyser.readFile(INDIA_CENSUS_CSV_FILE_PATH, IndianStateCensusAnalyser.class);
            String sortedData = censusAnalyser.SortedCode(7,IndiaCensusDAO.class);
            IndianStateCensusAnalyser[] indianStateCensesAnalyzers = new Gson().fromJson(sortedData, IndianStateCensusAnalyser[].class);
            Assert.assertEquals(119,indianStateCensesAnalyzers[28].getDensity());}
         catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }

    /* T.C 7 :Indian Census Area In Sorted Form  */
    @Test
    public void givenIndianCensusData_WhenSorted_ThenShouldReturnSortedArea() {
        try {
            censusAnalyser.readFile(INDIA_CENSUS_CSV_FILE_PATH,IndianStateCensusAnalyser.class);
            String sortedData = censusAnalyser.SortedCode(12,IndiaCensusDAO.class);
            IndianStateCensusAnalyser[] indianStateCensesAnalyzers = new Gson().fromJson(sortedData, IndianStateCensusAnalyser[].class);
            Assert.assertEquals(16579, indianStateCensesAnalyzers[28].getArea());}
        catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }

    /* Tc 8 :Given The US Census Csv File, Check To Ensure The Number Of Record Matches */
    @Test
    public void givenFilePathForUSCensus_WhenNoOfRecordMatches_ThenReturnTrue() {
        try {
            int noOfRecords = censusAnalyser.readFile(US_CENSUS_CSV_FILE_PATH, USCensusData.class);
            Assert.assertEquals(51, noOfRecords);}
        catch (CensusAnalyserException e) {
        }
    }

    /* Tc 9 :Given The US Census Csv File, Check To Sorted Population State */
    @Test
    public void givenUsCensusData_WhenSorted_ThenShouldReturnSortedPopulationState() {
        try {
            censusAnalyser.readFile(US_CENSUS_CSV_FILE_PATH, USCensusData.class);
            String sortedData = censusAnalyser.SortedCode(3,USCensusData.class);
            IndiaCensusDAO[] indianStateCensesAnalyzers = new Gson().fromJson(sortedData, IndiaCensusDAO[].class);
            Assert.assertEquals("Alabama", indianStateCensesAnalyzers[0].getState()); }
        catch (CensusAnalyserException e) {
        }
    }

    /* Tc 10.1 :Given The US Census Csv File, Check To Sorted Area State */
    @Test
    public void givenUsCensusData_WhenSorted_ThenShouldReturnSortedArea() {
        try {
            censusAnalyser.readFile(US_CENSUS_CSV_FILE_PATH, USCensusData.class);
            String sortedData = censusAnalyser.SortedCode(9,USCensusData.class);
            IndiaCensusDAO[] indianStateCensesAnalyzers = new Gson().fromJson(sortedData, IndiaCensusDAO[].class);
            Assert.assertEquals(1723338, indianStateCensesAnalyzers[50].getTotalArea()); }
        catch (CensusAnalyserException e) {
        }
    }

    /* Tc 10.2 :Given The US Census Csv File, Check To Sorted Area State */
    @Test
    public void givenUsCensusData_WhenSorted_ThenShouldReturnSortedDensity() {
        try {
            censusAnalyser.readFile(US_CENSUS_CSV_FILE_PATH, USCensusData.class);
            String sortedData = censusAnalyser.SortedCode(10,USCensusData.class);
            IndiaCensusDAO[] indianStateCensesAnalyzers = new Gson().fromJson(sortedData, IndiaCensusDAO[].class);
            Assert.assertEquals(3805, indianStateCensesAnalyzers[50].getPopulationDensity()); }
        catch (CensusAnalyserException e) {
        }
    }

    /* Tc 11 :Given The US And India Census Csv File Compare Whose Population Is Most*/
    @Test
    public void givenUsAndIndiaCensusData_WhenSorted_ThenShouldReturnSortedResult()
    {
        try {
            censusAnalyser.readFile(INDIA_CENSUS_CSV_FILE_PATH, IndianStateCensusAnalyser.class);
            String sortedData = censusAnalyser.SortedCode(3, IndiaCensusDAO.class);
            IndianStateCensusAnalyser[] indianStateCensesAnalyzers = new Gson().fromJson(sortedData, IndianStateCensusAnalyser[].class);
            Assert.assertEquals(1980602, indianStateCensesAnalyzers[28].getPopulation());
            censusAnalyser.readFile(US_CENSUS_CSV_FILE_PATH, USCensusData.class);
            String UssortedData = censusAnalyser.SortedCode(10, USCensusData.class);
            IndiaCensusDAO[] USStateCensesAnalyzers = new Gson().fromJson(UssortedData, IndiaCensusDAO[].class);
            Assert.assertEquals(3805, USStateCensesAnalyzers[50].getPopulationDensity()); }
        catch (CensusAnalyserException e) {
            e.printStackTrace(); }
    }
}



