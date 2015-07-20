package bscg;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class CardTest {

	Card card = new Card();
	final String bank = "HSBC Canada";
	final String cardNumber = "5601-2345-3446-5678";
	final String expiryDate = "Nov-2017";
	

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
		System.out.println(stringExpirayDate);
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
		System.out.println(card.toString());
	}

	@Test
	public void test_formatCardNumber() {
		String formatedCardNumber = card.formatCardNumber("5601-2345-3446-345 ","","345 ");
		assertEquals("xxxx-xxxx-xxxx-345", formatedCardNumber);
		formatedCardNumber = card.formatCardNumber("5601-2345-3446-345","","345");
		assertEquals("xxxx-xxxx-xxxx-345", formatedCardNumber);
		formatedCardNumber = card.formatCardNumber("4519-2345-3446-345","4519",null);
		System.out.println(formatedCardNumber);
		assertEquals("4519-xxxx-xxxx-xxx", formatedCardNumber);
		
	}

}
