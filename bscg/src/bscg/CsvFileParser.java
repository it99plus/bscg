package bscg;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static bscg.FormatterUtil.*;

public class CsvFileParser {

	private String csvFileName;

	public CsvFileParser(String csvFileName) {
		this.csvFileName = csvFileName;
	}
	
	public void addStartWith(String startWith) {
		FormatterUtil.addToStartWithList(startWith);
	}
	public void addEndWith(String endWith) {
		FormatterUtil.addToEndWithList(endWith);
	}
	
	public String getCsvFileName() {
		return csvFileName;
	}
	
	public Card createNewCardFromRow(String[] fields) {
		Card card = new Card();
		card.createNewCard(fields[0], fields[1], fields[2]);
		return card;	
	}
	
	public Banks loadDataFromCsvFile() throws FileNotFoundException {
		Scanner scanner = null;
		scanner = new Scanner(new File(this.csvFileName));
		
		Banks banks = new Banks();
		
		String[] nextLineStrings;
		
		while (scanner.hasNext()) {
			String nextLine = scanner.nextLine();
			nextLineStrings = nextLine.split(",");
			Card card = createNewCardFromRow(nextLineStrings);
			banks.addCard(card);
		}
		scanner.close();
		return banks;
	}

	

}
