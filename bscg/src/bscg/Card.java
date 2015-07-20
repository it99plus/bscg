package bscg;

public class Card {

	private String bank;
	private String cardNumber;
	private String expiryDate;

	
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


	public void createNewCard(String bank, String cardNumber, String expiryDate) {
		this.bank = bank;
		this.cardNumber = cardNumber;
		this.expiryDate = expiryDate;
	}
	
	
	

}
