package bscg;

import java.util.Comparator;
import java.util.Date;

/**
 * <h1>Card class</h1> The Card class receives three parameters that are
 * formated according to specification the string date parameter is formated to
 * Date type. this enables sorting by Date. the output on the screen.
 * 
 * @author Jean Karkar
 * 
 */
public class Card implements Comparable<Card>{

	private String bank;
	private String cardNumber;
	private Date expiryDate;

	public void createNewCard(String bank, String cardNumber, String expiryDate) {
		this.bank = bank;
		this.cardNumber = FormatterUtil.formatCard(cardNumber);
		this.expiryDate = FormatterUtil.formatStringToSimpleDate(expiryDate);
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(bank);
		sb.append(" "); 
		sb.append(cardNumber);
		sb.append(" "); 
		sb.append(FormatterUtil.formatSimpleDateToString(this.expiryDate));
		return sb.toString();
		// return bank + " " + cardNumber + " " + FormatterUtil.formatSimpleDateToString(this.expiryDate);
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

	@Override
	public int compareTo(Card o) {
		// -1 if the first one ---- (this) is smaller than o
		//  0 if they are equal ---- (this equals o)
		// +1 if they are bigger ---- (this) is bigger
		return this.expiryDate.compareTo(o.expiryDate);
	}


	private static final Comparator<Card> bankComparator = new Comparator<Card>() {
		@Override
		public int compare(Card o1, Card o2) {
			return o1.getBank().compareTo(o2.getBank());
		}};
	
	public static Comparator<Card> getBankComparator() {
		return bankComparator;
		
	}
	
}
