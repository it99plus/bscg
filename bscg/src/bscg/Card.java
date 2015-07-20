package bscg;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Card {

	private String bank;
	private String cardNumber;
	private String expiryDate;

	public void createNewCard(String bank, String cardNumber, String expiryDate) {
		this.bank = bank;
		this.cardNumber = cardNumber;
		this.expiryDate = expiryDate;
	}

	public Date formatStringToSimpleData(String expiryDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("MMM-yyyy");
		try {
			return sdf.parse(expiryDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public  String formatSimpleDateToStringDate(Date expiryDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("MMM-yyyy");
		return sdf.format(expiryDate);
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

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String formatSimpleDateToString() {
		// TODO Auto-generated method stub
		return null;
	}

}
