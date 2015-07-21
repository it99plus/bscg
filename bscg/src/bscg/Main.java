package bscg;

import java.io.FileNotFoundException;
import java.text.ParseException;

public class Main {
	
	private static String FILE_NAME = "csvFiles/csvToRead.txt";
	
	public static void main(String[] args) throws ArrayIndexOutOfBoundsException, FileNotFoundException, ParseException  {
		try {
			// fixtures
			CsvFileParser csvFileParser = new CsvFileParser(FILE_NAME);
			FormatterUtil.addToStartWithList("56");
			FormatterUtil.addToStartWithList("4519");
			FormatterUtil.addToEndWithList("345");
			
			System.out.println("Starting with: "+ FormatterUtil.startWithList);
			System.out.println("Ending with  : "+ FormatterUtil.endWithList);
			System.out.println();
			System.out.println();
			
			Banks banks = csvFileParser.loadDataFromCsvFile();
			
			/////////////////////////////////////////////////////
			banks.sortByBank();
			/////////////////////////////////////////////////////
			System.out.println("Sorted by Bank + Date:");
			System.out.printf("%-22s %-10s %-20s\n","Banks","Expiry Date","Credit Cards");
			System.out.println("----------------------------------------------------------");
			// System.out.println(banks);
			for (Card card : banks.getCards()) {
				System.out.printf("%-22s %-10s %-20s\n",card.getBank(),FormatterUtil.formatSimpleDateToString(card.getExpiryDate()),card.getCardNumber());
			}
			System.out.println("\n\n");
			/////////////////////////////////////////////////////
			banks.sortOnExpiryDate();
			/////////////////////////////////////////////////////
			System.out.println("Sorted by Date + Bank (descending order):");
			System.out.printf("%-10s %-22s %-25s\n","Expiry Date", "Banks","Credit Cards");
			System.out.println("----------------------------------------------------------");
			for (Card card : banks.getCards()) {
				System.out.printf("%-10s %-22s %-25s\n",FormatterUtil.formatSimpleDateToString(card.getExpiryDate()),card.getBank(),card.getCardNumber());
			}
			// throw new FileNotFoundException();
		} catch (FileNotFoundException fnfe ) {
			System.out.println("File not found...");
		} catch (ArrayIndexOutOfBoundsException aioobe) {
			System.out.println("Data integrity failure...");
		} catch (IllegalStateException e) {
			System.out.println("Data integrity failure in csv file: check daate format in csv file...");
			e.printStackTrace();
		}
	}
}
