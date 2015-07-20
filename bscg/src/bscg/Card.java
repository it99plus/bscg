package bscg;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Card {

	private String bank;
	private String cardNumber;
	private Date expiryDate;
	private ArrayList<String> startWithList = new ArrayList<String>();
	private ArrayList<String> endWithList = new ArrayList<String>();

	public void createNewCard(String bank, String cardNumber, String expiryDate) {
		this.bank = bank;
		this.cardNumber = cardNumber;
		this.expiryDate = formatStringToSimpleDate(expiryDate);
	}

	public ArrayList<String> getEndWithList() {
		return endWithList;
	}
	public ArrayList<String> getStartWithList() {
		return startWithList;
	}

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
					+ cardNumber.substring(startWith.length()).replaceAll(
							"[0-9]", "x");
		} else if (endWith != "" && cardNumber.trim().endsWith(endWith)) {
			cardNumber = cardNumber.substring(0,
					cardNumber.length() - (endWith.length())).replaceAll(
					"[0-9]", "x")
					+ endWith;
		}
		return cardNumber;
	}

	public String formatCard(String cardNumber,
			ArrayList<String> startWithList, 
			ArrayList<String> endWithList) {
		for (String startString : startWithList) {
			if (cardNumber.trim().startsWith(startString)) {
				cardNumber = formatCardNumber(cardNumber, startString, "");
				return cardNumber;
			}
		}
		for (String endString : endWithList) {
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
