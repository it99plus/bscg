package bscg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Banks {

	private List<Card> cards;  // List Type Interface

	//@formatter:off
	public Banks() {cards = new ArrayList<Card>();}
	
	public void addCard(Card card) {cards.add(card);}
	
	public List<Card> getCards() {return cards;}
	
	@Override
	public String toString() {
		StringBuilder resultSb = new StringBuilder();
		for (Card card : cards) {
			resultSb.append(card.toString() + "\n");
		}
		return resultSb .toString();
	}
	
	public void sortOnExpiryDate() {Collections.sort(cards);}
	
	public void sortByBank() {Collections.sort(cards, Card.getBankComparator());}
	//@formatter:on

}
