package bscg;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class CardTest {

	final String bank = "HSBC Canada";
	final String cardNumber = "5601-2345-3446-5678";
	final String expiryDate = "Nov-2017";

	Card card = new Card();

	@Before
	public void setup() {
		card.createNewCard("HSBC Canada","5601-2345-3446-5678","Nov-2017");
	}

	@Test
	public void test_formatStringToSimpleDate() {
		Date expiryDate = card.formatStringToSimpleDate("Nov-2017");
		//System.out.println(expiryDate);
		assertEquals("Wed Nov 01 00:00:00 GMT 2017",expiryDate.toString());
	}
	
	@Test
	public void test_fromatSimpleDateToString() {
		Date expiryDate = card.formatStringToSimpleDate("Nov-2017");
		String stringExpirayDate = card.formatSimpleDateToString(expiryDate);
	//	System.out.println(stringExpirayDate);
	}
	
	@Test
	public void test_createNewCad() {
		Date expiryDate = card.formatStringToSimpleDate("Nov-2017");
		assertEquals(bank, card.getBank());
		assertEquals(cardNumber, card.getCardNumber());
		assertEquals(expiryDate, card.getExpiryDate());
	}

	@Test
	public void test_toString() {
		assertEquals(bank + " " + cardNumber + " " + expiryDate, card.toString());
		//System.out.println(card.toString());
	}

	@Test
	@Ignore
	public void test_formatCardNumber() {
		String formatedCardNumber = card.formatCardNumber("5601-2345-3446-345 ","","345 ");
		assertEquals("xxxx-xxxx-xxxx-345", formatedCardNumber);
		formatedCardNumber = card.formatCardNumber("5601-2345-3446-345","","345");
		assertEquals("xxxx-xxxx-xxxx-345", formatedCardNumber);
		formatedCardNumber = card.formatCardNumber("4519-2345-3446-345","4519",null);
		assertEquals("4519-xxxx-xxxx-xxx", formatedCardNumber);
		formatedCardNumber = card.formatCardNumber("5601-2345-3446-345","56","");
		// System.out.println(formatedCardNumber);
		assertEquals("56xx-xxxx-xxxx-xxx", formatedCardNumber);
	}
	
	@Test
	public void test_formatCard() {
		ArrayList<String> startWithList = new ArrayList<String>();
		startWithList.add("56");
		startWithList.add("4519");
		
		ArrayList<String> endWithList = new ArrayList<String>();
		endWithList.add("345");
		
		String formatedCard = card.formatCard("5601-2345-3446-345",startWithList, endWithList);
		assertEquals("56xx-xxxx-xxxx-xxx", formatedCard);
		
		formatedCard = card.formatCard("3301-2345-3446-345",startWithList, endWithList);
		assertEquals("xxxx-xxxx-xxxx-345", formatedCard);
		// System.out.println(formatedCard);
		
		formatedCard = card.formatCard("4519-2345-3446-3345",startWithList, endWithList);
		assertEquals("4519-xxxx-xxxx-xxxx", formatedCard);
//		System.out.println(formatedCard);
		
		formatedCard = card.formatCard("4519-2345-3446-335",startWithList, endWithList);
		// assertEquals("4519-xxxx-xxxx-xxx", formatedCard);
		System.out.println(formatedCard);
	}
	

}
