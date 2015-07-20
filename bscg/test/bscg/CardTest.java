package bscg;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
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
	public void test_createNewCad() {
		assertEquals(bank, card.getBank());
		assertEquals(cardNumber, card.getCardNumber());
		assertEquals(expiryDate, card.getExpiryDate());
	}

	@Test
	public void test_formatStringToSimpleDate() {
		Date expiryDate = card.formatStringToSimpleData("Nov-2017");
		System.out.println(expiryDate);
		assertEquals("Wed Nov 01 00:00:00 GMT 2017",expiryDate.toString());
	}

}
