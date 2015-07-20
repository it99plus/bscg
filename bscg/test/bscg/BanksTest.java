package bscg;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class BanksTest {

	Banks banks;
	Card card;
	
	@Before
	public void setup() {
		banks = new Banks();
		card = new Card();
	}
	
	@Test
	public void test_addCard() {
		banks = new Banks();
		card.createNewCard("HSBC Canada", "5601-2345-3446-5678", "Nov-2017");
		banks.addCard(card);
		List<Card> cards = (ArrayList<Card>) banks.getCards();
		assertTrue(cards.contains(card));
		for (Card card : cards) {
			System.out.println(card.toString());
		}
	}
		
	@Test 
	public void test_sortOnExpiryDate() {
		banks.sortOnExpiryDate();
		for (Card card : banks.getCards()) {
			System.out.println(card.toString());
		}
	}		
	
	@Test 
	public void test_sortByBank() {
		banks.sortByBank();
	}		
	
		

}
