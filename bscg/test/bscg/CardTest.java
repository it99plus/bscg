package bscg;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import org.junit.Before;
import org.junit.Test;

public class CardTest {

	Card card = new Card();
	FormatterUtil formatterUtil;

	@Before
	public void setup() {
		card = new Card();
		formatterUtil = new FormatterUtil();
		FormatterUtil.addToStartWithList("56");
		FormatterUtil.addToStartWithList("4519");
		FormatterUtil.addToEndWithList("345");
	}

	@Test
	public void test_createNewCad() {
		Date expiryDate = FormatterUtil.formatStringToSimpleDate("Nov-2017");
		System.out.println(expiryDate);
		FormatterUtil.addToStartWithList("56");
		card.createNewCard("HSBC Canada", "5601-2345-3446-5678", "Nov-2017");
		// assertEquals(bank, card.getBank());
//		assertEquals("56xx-xxxx-xxxx-xxxx", card.getCardNumber());
//		assertEquals(expiryDate, card.getExpiryDate());
	}

	@Test
	public void test_toString() {
	//	assertEquals(card.getCardNumber() + " " + "56xx-xxxx-xxxx-xxxx" + " " + card.getExpiryDate(),card.toString());
	}
	
	@Test
	public void test_compareTo() {
		Card oCard = new Card();
		card.createNewCard("HSBC Canada", "5601-2345-3446-5678", "Nov-2017");
		oCard.createNewCard("HSBC Canada", "5601-2345-3446-5678", "Nov-2017");
		System.out.println(card.compareTo(oCard));
		assertEquals("return 0 if they are equal - test key is expiry date",0, card.compareTo(oCard));
		card.createNewCard("HSBC Canada", "5601-2345-3446-5678", "Nov-2017");
		oCard.createNewCard("HSBC Canada", "5601-2345-3446-5678", "Nov-2018");
		assertEquals("return -1 if they are not equal - test key is expiry date",-1, card.compareTo(oCard));
		
		// this.expiryDate.compareTo(o.expiryDate); testing on expiryDate
	}
}
