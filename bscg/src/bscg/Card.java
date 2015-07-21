package bscg;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;


/**
 * Card creates a card with fields that represent a record in the csv file.
 * 
 * @author Jean Karkar
 */
public class Card implements Comparable<Card> {
	//@formatter:off
	private String bank;
	private String cardNumber;
	private Date   expiryDate;

	public void createNewCard(String bank, String cardNumber, String expiryDate) throws ParseException  {
		this.bank = bank;
		this.cardNumber = FormatterUtil.formatCard(cardNumber);
		this.expiryDate = FormatterUtil.formatStringToSimpleDate(expiryDate);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(bank + " " + cardNumber + " ");
		sb.append(FormatterUtil.formatSimpleDateToString(expiryDate));
		return sb.toString();
	}
	
	public String getBank() {return bank;}
	
	public String getCardNumber() {return cardNumber;}
	
	public Date getExpiryDate() {return expiryDate;}
	
	
	/** 
	 * comparTo is used by Bank object to sort cards list by Date + Bank 
	 */
	@Override
	public int compareTo(Card o) {
		
		int sComp = this.expiryDate.compareTo(o.expiryDate);
		if (sComp != 0)
			return sComp;
		
		String thisBank = this.getBank().trim();
		String oBank = o.getBank().trim();
		sComp = thisBank.compareTo(oBank);

		return sComp;
	}

	/** 
	 * bankComparator references an anonymous class of Comparator<Card> type.
	 * It compares to Card Objects on bank + date
	 * 
	 * references to Comparator<Card> is returned by getBankComparator().
	 */
	private static final Comparator<Card> bankComparator = new Comparator<Card>() {
		@Override
		public int compare(Card o1, Card o2) {
			String o1Bank = o1.getBank().trim();
			String o2Bank = o2.getBank().trim();

			int sComp = o1Bank.compareTo(o2Bank);
			if (sComp != 0)
				return sComp;

			Date o1ExpiDate = o1.getExpiryDate();
			Date o2expDate = o2.getExpiryDate();

			Calendar cal = Calendar.getInstance();
			cal.setTime(o1ExpiDate);
			int month1 = cal.get(Calendar.MONTH);
			int year1 = cal.get(Calendar.YEAR);

			cal.setTime(o2expDate);
			int month2 = cal.get(Calendar.MONTH);
			int year2 = cal.get(Calendar.YEAR);

			if (year1 > year2)
				return 1;
			if (year1 < year2)
				return -1;

			if (month1 > month2)
				return 1;
			if (month1 < month2)
				return -1;

			return -1;
		}
	};

	/** 
	 * getBankComparator() returns bankComparator reference to an anonymous Comparator<Card>() 
	 * object, used by Banks class to sort a a List<Card> by bank + date. 
	 * 
	 */
	public static Comparator<Card> getBankComparator() {
		return bankComparator;

	}
	//@formatter:on
}
