package bscg;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class CardTest {

	final String bank       = "HSBC Canada";
	final String cardNumber = "5601-2345-3446-5678";
	final String expiryDate = "Nov-2017";

	Card card = new Card();

	@Before
	public void setup() {
		card.addToStartWithList("56");    // method ignores duplicates
		card.addToStartWithList("4519");  // method ignores duplicates
		card.addToEndWithList("345");
		card.createNewCard("HSBC Canada", "5601-2345-3446-5678", "Nov-2017");
	}

	@Test
	public void test_createNewCad() {
		Date expiryDate = card.formatStringToSimpleDate("Nov-2017");
		card.addToStartWithList("56");
		card.createNewCard("HSBC Canada", "5601-2345-3446-5678", "Nov-2017");
		System.out.println(card.getCardNumber());
		assertEquals(bank, card.getBank());
		assertEquals("56xx-xxxx-xxxx-xxxx", card.getCardNumber());
		assertEquals(expiryDate, card.getExpiryDate());
	}

	@Test
	public void test_addToStartWithList() {
		ArrayList<String> startWithList = card.getStartWithList();
		assertTrue(startWithList.contains("56"));
	}

	@Test
	public void test_addToEndWithList() {
		ArrayList<String> endWithList = card.getEndWithList();
		System.out.println(endWithList);
		assertTrue(endWithList.contains("345"));
	}

	@Test
	public void test_formatStringToSimpleDate() {
		Date expiryDate = card.formatStringToSimpleDate("Nov-2017");
		assertEquals("Wed Nov 01 00:00:00 GMT 2017", expiryDate.toString());
	}

	@Test
	public void test_fromatSimpleDateToString() {
		Date expiryDate = card.formatStringToSimpleDate("Nov-2017");
		String stringExpirayDate = card.formatSimpleDateToString(expiryDate);
		System.out.println(stringExpirayDate);
	}

	@Test
	public void test_toString() {
		assertEquals(bank + " " + "56xx-xxxx-xxxx-xxxx" + " " + expiryDate,card.toString());
	}

	@Test
	@Ignore
	public void test_formatCardNumber() {
		String formatedCardNumber = card.formatCardNumber("5601-2345-3446-345 ", "", "345 ");
		assertEquals("xxxx-xxxx-xxxx-345", formatedCardNumber);
		formatedCardNumber = card.formatCardNumber("5601-2345-3446-345", "","345");
		assertEquals("xxxx-xxxx-xxxx-345", formatedCardNumber);
		formatedCardNumber = card.formatCardNumber("4519-2345-3446-345","4519", null);
		assertEquals("4519-xxxx-xxxx-xxx", formatedCardNumber);
		formatedCardNumber = card.formatCardNumber("5601-2345-3446-345", "56","");
		assertEquals("56xx-xxxx-xxxx-xxx", formatedCardNumber);
	}

	@Test
	public void test_formatCard() {
		card.addToStartWithList("4519"); // method ignores duplicates
		String formatedCard = card.formatCard("5601-2345-3446-345");
		System.out.println(formatedCard);
		formatedCard = card.formatCard("4519-2345-3446-3345");
		System.out.println(formatedCard);
		assertEquals("4519-xxxx-xxxx-xxxx", formatedCard);

		card.addToEndWithList("345"); // method ignores duplicates
		formatedCard = card.formatCard("3301-2345-3446-345");
		System.out.println(formatedCard);
		assertEquals("xxxx-xxxx-xxxx-345", formatedCard);
		
	}

}
