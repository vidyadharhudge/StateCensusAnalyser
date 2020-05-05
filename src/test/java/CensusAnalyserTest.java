import com.statecensusanalyser.CensusAnalyser;
import com.statecensusanalyser.CensusAnalyserException;
import com.statecensusanalyser.CsvStates;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CensusAnalyserTest
{
    private static final String INDIA_CENSUS_CSV_FILE_PATH="./src/test/resources/StateCensusData.csv";
    private static final String WRONG_CSV_FILE_PATH="./src/test/resources/StateCensusData1.csv";
    private static final String WRONG_CSV_FILE_TYPE="./src/test/resources/StateCensusData.tx";
    private static final String WRONG_DELIMITER_FILE="./src/test/resources/StateCensusDataWithWrongDelimiter.csv";
    public static final String STATE_CODE_CSV_FILE="./src/test/resources/StateCode.csv";
    public static final String WRONG_CSV_FILE_PATHS="./src/test/resources/StateCode1.csv";
    public static final String WRONG_CSV_FILE_TYPES="./src/test/resources/StateCode.csv.cs";
    public static final String WRONG_DELIMITER_FILES="./src/test/resources/StateCodeDataWithWrongDelimiter.csv";
    CensusAnalyser censusAnalyser;
    @Before
    public void setup()
    {
        censusAnalyser=new CensusAnalyser();
    }
    /* Tc 1.1 :Given The State Census Csv File, Check To Ensure The Number Of Record Matches */
    @Test
    public void givenFilePath_WhenNoOfRecordMatches_ThenReturnTrue()
    {
        try
        {
            int noOfRecords=censusAnalyser.readFile(INDIA_CENSUS_CSV_FILE_PATH);
            Assert.assertEquals(29,noOfRecords);

        }
        catch (CensusAnalyserException e)
        {
            e.printStackTrace();
        }
    }
    /* T.C 1.2 :Given State Censes Csv File Is Incorrect Then Returns Custom Exception */
    @Test
    public void givenStateCensusData_WhenWithWrongFile_ThenShouldThrowException()
    {
        try
        {
            CensusAnalyser.readFile(WRONG_CSV_FILE_PATH);
        }
        // Handling Exception "Enter Correct File And Type" ;
        //e.type=FILE_NOT_FOUND;
        catch (CensusAnalyserException e) // Handling Exception "Enter Correct File And Type"
        {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.FILE_NOT_FOUND,e.type);
        }
    }
    /* T.C 1.3 :Given State Censes Csv Type Is Incorrect Then Returns Custom Exception */
    @Test
    public void givenStateCensusData_WhenWithWrongType_ThenShouldThrowException()
    {
        try
        {
            CensusAnalyser.readFile(WRONG_CSV_FILE_TYPE);
        }
        // Handling Exception "Enter Correct File And Type" ;
        //e.type=FILE_NOT_FOUND;
        catch (CensusAnalyserException e) // Handling Exception "Enter Correct File And Type"
        {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.FILE_NOT_FOUND,e.type);
        }
    }
    /* T.C 1.4 :Given State Censes Csv file Is Correct But With Wrong Delimiter Should Rhrow Custom Exception */
    @Test
    public void givenStateCensusData_WhenWithWrongDelimiter_ThenShouldThrowException()
    {
        try
        {
            CensusAnalyser.readFile(WRONG_DELIMITER_FILE);
        }
        // Handling Exception "Check Delimiter And Header" ;
        //e.type=WRONG_DELIMITER;
        catch (CensusAnalyserException e)
        {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.WRONG_DELIMITER,e.type);
        }
    }
    /* T.C 1.5 :Given State Censes Csv file Is Correct But With Wrong Header Should Rhrow Custom Exception */
    @Test
    public void givenStateCensusData_WhenWithWrongHeader_ThenShouldThrowException()
    {
        try
        {
            CensusAnalyser.readFile(WRONG_DELIMITER_FILE);
        }
        // Handling Exception "Check Delimiter And Header" ;
        //e.type=WRONG_DELIMITER;
        catch (CensusAnalyserException e)
        {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.WRONG_DELIMITER,e.type);
        }
    }

    /* Tc 2.1 :Given The State code Csv File, Check To Ensure The Number Of Record Matches */
    @Test
    public void givenFilePathOfStateCode_WhenNoOfRecordMatches_ThenReturnTrue()
    {
        try
        {
            int counts=CsvStates.loadIndianStateCodes(STATE_CODE_CSV_FILE);
            Assert.assertEquals(37,counts);
        }
        catch (CensusAnalyserException e)
        {
            e.printStackTrace();
        }
        // e.printStackTrace(); it is methode of java Throwable class
    }
    /* T.C 2.2 :Given State Code Csv File Is Incorrect Then Returns Custom Exception */
    @Test
    public void givenStateCodeData_WhenWithWrongFile_ThenShouldThrowException()
    {
        try
        {
            CsvStates.loadIndianStateCodes(WRONG_CSV_FILE_PATHS);
        }
        // Handling Exception "Enter Correct File And Type" ;
        //e.type=FILE_NOT_FOUND;
        catch (CensusAnalyserException e) // Handling Exception "Enter Correct File And Type"
        {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.FILE_NOT_FOUND,e.type);
        }
    }
    /* T.C 2.3 :Given State Code Csv Type Is Incorrect Then Returns Custom Exception */
    @Test
    public void givenStateCodeData_WhenWithWrongType_ThenShouldThrowException()
    {
        try
        {
            CsvStates.loadIndianStateCodes(WRONG_CSV_FILE_TYPES);
        }
        // Handling Exception "Enter Correct File And Type" ;
        //e.type=FILE_NOT_FOUND;
        catch (CensusAnalyserException e) // Handling Exception "Enter Correct File And Type"
        {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.FILE_NOT_FOUND,e.type);
        }
    }

    /* T.C 2.4 :Given State Code Csv file Is Correct But With Wrong Delimiter Should Throw Custom Exception */
    @Test
    public void givenStateCodeData_WhenWithWrongDelimiter_ThenShouldThrowException()
    {
        try
        {
            CsvStates.loadIndianStateCodes(WRONG_DELIMITER_FILES);
        }
        // Handling Exception "Check Delimiter And Header" ;
        //e.type=WRONG_DELIMITER;
        catch (CensusAnalyserException e)
        {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.WRONG_DELIMITER,e.type);
        }
    }
    /* T.C 2.5 :Given State Code Csv file Is Correct But With Wrong Header Should Rhrow Custom Exception */
    @Test
    public void givenStateCodeData_WhenWithWrongHeader_ThenShouldThrowException()
    {
        try
        {
            CsvStates.loadIndianStateCodes(WRONG_DELIMITER_FILES);
        }
        // Handling Exception "Check Delimiter And Header" ;
        //e.type=WRONG_DELIMITER;
        catch (CensusAnalyserException e)
        {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.WRONG_DELIMITER,e.type);
        }
    }


}
