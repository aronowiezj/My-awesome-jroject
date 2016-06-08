package ayou.view;

import java.util.List;

import ayou.model.Card;

public class Displayer {
	public static String putCard(Card card1, Card card2) {
		System.out.println("Cards on the ground : ");
		System.out.println("p1 : " + card1.toString());
		System.out.println("p2 : " + card2.toString());
		return "Cards on the ground : " + card1.toString() + " " + card2.toString();
	}

	public static void display(List<Card> cards) {
		int i = 1;
		for (Card card : cards)
			System.out.println(i++ + ". " + card);
	}

	public static String attackCard(Card cardAtt, Card cardDef) {
		String string;
		string = cardAtt.getName() + " attacked " + cardDef.getName();
		System.out.println(string);
		return string;
	}

	public static String die(Card card) {
		System.out.println(card.getName() + " died");
		return card.getName() + " died";
	}

}
