package bscg;

import java.io.FileNotFoundException;

public class Main {
	
	private final static String FILE_NAME = "csvFiles/csvToRead.txt";
	
	public static void main(String[] args)   {
		try {
			CsvFileParser csvFileParser = new CsvFileParser(FILE_NAME);
			FormatterUtil.addToStartWithList("56");
			FormatterUtil.addToStartWithList("4519");
			FormatterUtil.addToEndWithList("345");
			System.out.println("Starting with: "+ FormatterUtil.startWithList);
			System.out.println("Ending with  : "+ FormatterUtil.endWithList);
			System.out.println();
			System.out.println();
			
			Banks banks = csvFileParser.loadDataFromCsvFile();
			
			banks.sortByBank();
			System.out.println("Sorted by Banks");
			System.out.println("----------------------------------------");
			System.out.println(banks);
			
			banks.sortOnExpiryDate();
			System.out.println("Sorted on ExpiryDate (descending order");
			System.out.println("----------------------------------------");
			System.out.println(banks);
			// throw new FileNotFoundException();
		} catch (FileNotFoundException fnfe) {
			System.out.println(fnfe);
		}
	}
}
