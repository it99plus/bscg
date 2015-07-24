package bscg;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


/**
 * FormatterUtil contains several static methods shared among all Objects in this 
 * application (package)
 * The static class also hold two public static ArrayList that are parsed for all the starting 
 * and ending of cards that must be masked.
 * All other card will not me masked.
 *
 * @author Jean Karkar
 */
public class FormatterUtil {

	// @formatter:off
	
	/* holds the list off numbers cards start with, and to be omitted  when masking the card */
	private static ArrayList<String> startWithList = new ArrayList<String>();
	
	/* holds the list off numbers cards end with, and to be omitted  when masking the card */
	private static ArrayList<String> endWithList = new ArrayList<String>();

	public static final ArrayList<String> getEndWithList() {return endWithList;}
	public static final ArrayList<String> getStartWithList() {return startWithList;}
	//@formatter:on

	/** 
	 * adds a card staring number to the ArryList of cards to be masked. 
	 */
	public static final void addToStartWithList(String startWith) {
		if (FormatterUtil.startWithList.contains(startWith) != true)
			FormatterUtil.startWithList.add(startWith);
	}

	/** 
	 * adds a card ending  number to the ArryList of cards to be masked. 
	 */
	public static final void addToEndWithList(String endtWith) {
		if (FormatterUtil.endWithList.contains(endtWith) != true)
			FormatterUtil.endWithList.add(endtWith);
	}
	
	/** 
	 * adds a card staring number to the ArryList of cards to be masked. 
	 */


	// ///////////////////////////////////////////////////////////////////////////////
	// //////////////////////////////////////////////////////////////////////////////

	/** 
	 *  format String Date to SimpleDateFormat "MMM-YYY"
	 */
	public static final Date formatStringToSimpleDate(String expiryDate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("MMM-yyyy");
		try {
			return sdf.parse(expiryDate);
		} catch (ParseException e) {
		}
		return null;
	}

	/** 
	 *  format Date to SimpleDateFormat "MMM-YYY"
	 */
	public static final String formatSimpleDateToString(Date expiryDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("MMM-yyyy");
		return sdf.format(expiryDate);
	}

	/** 
	 *  checks if the card number start with a number in the startWithList.
	 *  checks if the card number ends  with a number in the endWithList.
	 *  
	 *  calls formatCardNumber(..) to mask the card number if found in a List.
	 */
	public static final String formatCard(String cardNumber) {
		for (String startString : FormatterUtil.startWithList) {
			if (cardNumber.trim().startsWith(startString)) {
				cardNumber = formatCardNumber(cardNumber, startString, "");
				return cardNumber;
			}
		}
		for (String endString : FormatterUtil.endWithList) {
			if (cardNumber.trim().endsWith(endString)) {
				cardNumber = formatCardNumber(cardNumber, "", endString);
				return cardNumber;
			}
		}
		return cardNumber;
	}

	// @formatter:off
	/** 
	 *  masks a card number. sratWith and endWith characters are not masked.
	 */
	public static String formatCardNumber(String cardNumber, String startWith,	String endWith) {
		
		if (startWith == null)	startWith = "";
		if (endWith == null)	endWith = "";

		cardNumber = cardNumber.trim();
		startWith = startWith.trim();
		endWith = endWith.trim();

		if (startWith != "" && cardNumber.trim().startsWith(startWith)) {
			cardNumber = cardNumber.substring(0, startWith.length())+ cardNumber.substring(startWith.length())
												.replaceAll("[0-9]", "x");
		} else if (endWith != "" && cardNumber.trim().endsWith(endWith)) {
			cardNumber = cardNumber.substring(0,cardNumber.length() - (endWith.length()))
												.replaceAll("[0-9]", "x")+ endWith;
		}
		return cardNumber;
	}
	// @formatter:on
}
