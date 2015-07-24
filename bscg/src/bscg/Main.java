package bscg;

import java.io.FileNotFoundException;
import java.text.ParseException;


/**
 * Main demonstrate the usage of the Java csv parser test, producing the expected result.
 *
 * @author Jean Karkar
 */
public class Main {
	
	private static String FILE_NAME = "csvFiles/csvToRead.txt";
	
	public static void main(String[] args) throws ArrayIndexOutOfBoundsException, FileNotFoundException, ParseException  {
		try {
			/////////////////////////////////////////////////////////////////////////
			/////////////////////////////////////////////////////////////////////////
			CsvFileParser csvFileParser = new CsvFileParser(FILE_NAME);   // csv file
			// class FormatterUtil contains  static methods used across the application.
			// It has two static ArrayList fields - one is populated with the
			// "starting numbers" of bank cards to be masked, and the second
			// is populated with the "ending numbers" of cards to be masked.  
			// Cards that do not start or end with any of these numbers are ignored 
			// and will not be masked.
			csvFileParser.addStartWith("1234");		 
			csvFileParser.addStartWith("56");		 
			csvFileParser.addStartWith("4519");	 
			FormatterUtil.deleteEntryFromStartWithList("1234");
			
			csvFileParser.addEndWith("345");     
			csvFileParser.addEndWith("3456");    
			FormatterUtil.deleteEntryFromEndtWithList("3456");
			
			// FormatterUtil.addToStartWithList("56");
			// FormatterUtil.addToStartWithList("4519");
			// FormatterUtil.addToEndWithList("345");
			
			System.out.println("Starting with: "+ FormatterUtil.getStartWithList());
			System.out.println("Ending with  : "+ FormatterUtil.getEndWithList());
			System.out.println();
			System.out.println();
			/////////////////////////////////////////////////////////////////////////
			/////////////////////////////////////////////////////////////////////////
			
			//////////////////////////////////////////////////////////////////////// 
			Banks banks = csvFileParser.loadDataFromCsvFile();
			banks.sortByBank();
			////////////////////////////////////////////////////////////////////////
			
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
			System.out.println("Data integrity failure in csv file: check date format in csv file...");
			e.printStackTrace();
		}
	}
}
