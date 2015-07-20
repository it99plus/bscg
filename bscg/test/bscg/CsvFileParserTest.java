package bscg;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Before;
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
	public void test_loadDataFromCsvFile() throws FileNotFoundException {
		Banks banks = csvFileParser.loadDataFromCsvFile();
		assertEquals(csvFileName, csvFileParser.getCsvFileName());
	    assertNotNull(banks);
	}
	
	@Test 
	public void test_createNewCardFromRow() {
		// csvFileParser.createNewCardFromRow();
		String[] fields = {"HSBC Canada", "5601-2345-3446-5678", "Nov-2017"};
		Card card = csvFileParser.createNewCardFromRow(fields);
		// System.out.println(card);
		assertEquals("HSBC Canada 5601-2345-3446-5678 Nov-2017", card.toString());
	}

}
