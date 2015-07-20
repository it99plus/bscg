package bscg;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Card {

	private String bank;
	private String cardNumber;
	private Date expiryDate;

	public void createNewCard(String bank, String cardNumber, String expiryDate) {
		this.bank = bank;
		this.cardNumber = cardNumber;
		this.expiryDate = formatStringToSimpleDate(expiryDate);
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

	public  String formatSimpleDateToString(Date expiryDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("MMM-yyyy");
		return sdf.format(expiryDate);
	}
	
	@Override
	public String toString() {
		return bank + " " + cardNumber + " " + formatSimpleDateToString(this.expiryDate);
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

	
}
