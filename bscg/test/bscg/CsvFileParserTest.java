package bscg;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.text.ParseException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class CsvFileParserTest {

	CsvFileParser csvFileParser;
	String csvFileName = "csvFiles/csvToRead.txt";

	@Before
	public void Setup() {
		csvFileParser = new CsvFileParser(csvFileName);
	}

	@Test
	public void test_setFileName() {
		assertEquals(csvFileName, csvFileParser.getCsvFileName());
	}

	@Test
	@Ignore
	public void test_loadDataFromCsvFile() throws FileNotFoundException,
			ArrayIndexOutOfBoundsException, ParseException {
		Banks banks = csvFileParser.loadDataFromCsvFile();
		assertEquals(csvFileName, csvFileParser.getCsvFileName());
		assertNotNull(banks);
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testExceptionIn_createNewCardFromRow()	throws ArrayIndexOutOfBoundsException, ParseException {
		String[] fields = { "HSBC Canada", "5601-2345-3446-5678Nov-2017" };
		Card card = csvFileParser.createNewCardFromRow(fields);
		assertEquals("HSBC Canada 5601-2345-3446-5678 Nov-2017",card.toString());
		System.out.println(card);
	}

	// @Test (expected = ParseException.class)
	@Test  
	public void test_csvFileDataIntegrity() throws ArrayIndexOutOfBoundsException, ParseException {
		// String[] fields = { "HSBC Canada", "5601234534465678", "xxxxx" };
		String[] fields = { "HSBC Canada", "5601-2345-3446-5678", "Nov-2017" };
		@SuppressWarnings("unused")
		Card card = csvFileParser.createNewCardFromRow(fields);
		// "Date format error - expected format 'MM-YYYY':  \"HSBC Canada\", \"5601234534465678\", \"xxxxx"
	}

	@Test
	public void test_createNewCardFromRow()
			throws ArrayIndexOutOfBoundsException, ParseException {
		String[] fields = { "HSBC Canada", "5601-2345-3446-5678", "Nov-2017" };
		Card card = csvFileParser.createNewCardFromRow(fields);
		assertEquals("HSBC Canada 5601-2345-3446-5678 Nov-2017",
				card.toString());
		System.out.println(card);

	}

}
