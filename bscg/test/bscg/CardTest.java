package bscg;

import static org.junit.Assert.*;

import org.junit.Test;

public class CardTest {

	Card card = new Card();
	
	@Test
	public void test_createNewCad() {
		card.createNewCard("bank","cardNumber","expiryDate");
		assertEquals("bank", card.getBank());
		assertEquals("cardNumber", card.getCardNumber());
		assertEquals("expiryDate", card.getExpiryDate());
	}
	


}
