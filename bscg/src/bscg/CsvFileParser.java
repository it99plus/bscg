package bscg;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CsvFileParser {

	private String csvFileName;

	public CsvFileParser(String csvFileName) {
		this.csvFileName = csvFileName;
	}
	
	public String getCsvFileName() {
		return csvFileName;
	}

	public void loadDataFromCsvFile() throws FileNotFoundException {
		Scanner scanner = null;
		scanner = new Scanner(new File(this.csvFileName));
	}

}
