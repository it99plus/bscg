package bscg;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FormatterUtil {

	// @formatter:off
	public static ArrayList<String> startWithList = new ArrayList<String>();
	public static ArrayList<String> endWithList = new ArrayList<String>();

	public static final ArrayList<String> getEndWithList() {return endWithList;}
	public static final ArrayList<String> getStartWithList() {return startWithList;}
	//@formatter:on

	public static final void addToStartWithList(String startWith) {
		if (FormatterUtil.startWithList.contains(startWith) != true)
			FormatterUtil.startWithList.add(startWith);
	}

	public static final void addToEndWithList(String endtWith) {
		if (FormatterUtil.endWithList.contains(endtWith) != true)
			FormatterUtil.endWithList.add(endtWith);
	}

	// ///////////////////////////////////////////////////////////////////////////////
	// //////////////////////////////////////////////////////////////////////////////

	public static final Date formatStringToSimpleDate(String expiryDate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("MMM-yyyy");
		try {
			return sdf.parse(expiryDate);
		} catch (ParseException e) {
			// e.printStackTrace();
		}
		return null;
	}

	public static final String formatSimpleDateToString(Date expiryDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("MMM-yyyy");
		return sdf.format(expiryDate);
	}

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
