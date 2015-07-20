package bscg;

import java.util.ArrayList;
import java.util.List;


public class Banks {

	private List<Card> cards;  // List Type Interface

	

	//@formatter:off
	public Banks() {cards = new ArrayList<Card>();}
	//@formatter:on

	public void addCard(Card card) {
		cards.add(card);
	}
	
	public List<Card> getCards() {
		return cards;
	}
	
	

}
