package bscg;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Util {

	private ArrayList<String> startWithList = new ArrayList<String>();
	private ArrayList<String> endWithList = new ArrayList<String>();

	public ArrayList<String> getEndWithList() {
		return endWithList;
	}

	public ArrayList<String> getStartWithList() {
		return startWithList;
	}

	public void addToStartWithList(String startWith) {
		if (this.startWithList.contains(startWith) != true)
			this.startWithList.add(startWith);
	}

	public void addToEndWithList(String endtWith) {
		if (this.endWithList.contains(endtWith) != true)
			this.endWithList.add(endtWith);

	}
	
	/////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////
	
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

}
