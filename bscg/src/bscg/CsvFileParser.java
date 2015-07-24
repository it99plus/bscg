package bscg;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;


/**
 * CsvFileParser loads fields from a csv file. Populates ArrayList field, in 
 * Banks, with Card objects. Card object represents a record in the csv file.
 *
 * @author Jean Karkar
 */
public class CsvFileParser {
	//@formatter:off
	private String csvFileName;

	public CsvFileParser(String csvFileName) {this.csvFileName = csvFileName;}

	public void addStartWith(String startWith) {FormatterUtil.addToStartWithList(startWith);}

	public void addEndWith(String endWith) {FormatterUtil.addToEndWithList(endWith);}

	public void deleteEntryFromEndtWithList(String startWith) {FormatterUtil.deleteEntryFromEndtWithList(startWith);}

	public void deleteEntryFromStartWithList(String endWith) {FormatterUtil.deleteEntryFromStartWithList(endWith);}
	
	
	
	public String getCsvFileName() {return csvFileName;}

	public Card createNewCardFromRow(String[] fields) throws ArrayIndexOutOfBoundsException, ParseException {
		Card card = new Card();
		card.createNewCard(fields[0], fields[1], fields[2]);
		return card;
	}

	public Banks loadDataFromCsvFile() throws FileNotFoundException, ArrayIndexOutOfBoundsException {
		Scanner scanner = null;
		scanner = new Scanner(new File(this.csvFileName));

		Banks banks = new Banks();

		String[] nextLineStrings;

		while (scanner.hasNext()) {
			String nextLine = scanner.nextLine();
			nextLineStrings = nextLine.split(",");
			Card card;
			try {
				card = createNewCardFromRow(nextLineStrings);
			} catch (ParseException pe) {
				System.out.println("csv file: Data integrity failure parssing Date...");
				if (scanner != null) scanner.close(); 
				return banks;
			} 
			
			banks.addCard(card);
		} 
		
		scanner.close();
		return banks;
	}
	//@formatter:on
}
