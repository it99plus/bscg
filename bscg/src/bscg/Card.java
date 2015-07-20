package bscg;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


/**
* <h1>Card class</h1>
* The Card class receives three parameters 
* that are formated according to specification
* the string date parameter is formated to Date type. 
* this enables sorting by Date. 
* the output on the screen.

* @author  Jean Karkar
* 
*/
public class Card {

	private String bank;
	private String cardNumber;
	private Date expiryDate;
	private ArrayList<String> startWithList = new ArrayList<String>();
	private ArrayList<String> endWithList = new ArrayList<String>();

	
	/**  
	 * createNewCard: 
	 * sets and format fields retrieved from csv file.
	 * @param: String parameter representing fields in the csv file
	 * 
	 */
	public void createNewCard(String bank, String cardNumber, String expiryDate) {
		this.bank = bank;
		this.cardNumber = formatCard(cardNumber);
		this.expiryDate = formatStringToSimpleDate(expiryDate);
	}

	public ArrayList<String> getEndWithList() {
		return endWithList;
	}
	public ArrayList<String> getStartWithList() {
		return startWithList;
	}

	/**  
	 * formatCardNumber: 
	 * formats a credit card number, replacing values with x.
	 * @param: cardNumber represents a credit card
	 * @param: startWith represents cards starting number
	 * @param: endWith represents cards ending number
	 * 
	 */	
	public String formatCardNumber(String cardNumber, String startWith,
			String endWith) {
		if (startWith == null)
			startWith = "";
		if (endWith == null)
			endWith = "";

		cardNumber = cardNumber.trim();
		startWith = startWith.trim();
		endWith = endWith.trim();

		if (startWith != "" && cardNumber.trim().startsWith(startWith)) {
			cardNumber = cardNumber.substring(0, startWith.length())
					+ cardNumber.substring(startWith.length()).replaceAll("[0-9]", "x");
		} else if (endWith != "" && cardNumber.trim().endsWith(endWith)) {
			cardNumber = cardNumber.substring(0,cardNumber.length() - (endWith.length())).replaceAll(
					"[0-9]", "x")
					+ endWith;
		}
		return cardNumber;
	}

	
	public String formatCard(String cardNumber) {
		for (String startString : this.startWithList) {
			if (cardNumber.trim().startsWith(startString)) {
				cardNumber = formatCardNumber(cardNumber, startString, "");
				return cardNumber;
			}
		}
		for (String endString : this.endWithList) {
			if (cardNumber.trim().endsWith(endString)) {
				cardNumber = formatCardNumber(cardNumber, "", endString);
				return cardNumber;
			}
		}
		return cardNumber;
	}

	public Date formatStringToSimpleDate(String expiryDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("MMM-yyyy");
		try {
			return sdf.parse(expiryDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String formatSimpleDateToString(Date expiryDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("MMM-yyyy");
		return sdf.format(expiryDate);
	}

	@Override
	public String toString() {
		return bank + " " + cardNumber + " "
				+ formatSimpleDateToString(this.expiryDate);
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public void addToStartWithList(String startWith) {
		if (this.startWithList.contains(startWith)!= true) 
			this.startWithList.add(startWith);
	}

	public void addToEndWithList(String endtWith) {
		if (this.endWithList.contains(endtWith)!= true) 
			this.endWithList.add(endtWith); 
		
	}

}
