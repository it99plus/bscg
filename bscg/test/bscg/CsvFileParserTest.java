package bscg;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

public class CsvFileParserTest {

	
	
	@Before
	public void Setup() {
	}
	
	
	@Test
	public void test() {
		// fail("Not yet implemented");
	}
	
	@Test
	public void test_setFileName() {
		String csvFileName;
		csvFileName = "csvFiles/csvToRead.txt";
		CsvFileParser csvFileParser = new CsvFileParser(csvFileName);
		assertEquals(csvFileName, csvFileParser.getCsvFileName());
	}
	
	@Test
	public void test_loadDataFromCsvFile() throws FileNotFoundException {
		String csvFileName = "csvFiles/csvToRead.txt";
		CsvFileParser csvFileParser = new CsvFileParser(csvFileName);
		csvFileParser.loadDataFromCsvFile();
		assertEquals(csvFileName, csvFileParser.getCsvFileName());
	}

}
