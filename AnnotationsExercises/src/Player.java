import cards.Card;

import java.util.TreeSet;

public class Player {
    private String name;
    private TreeSet<Card> handOfCards;

    public Player(String name) {
        this.name = name;
        this.handOfCards = new TreeSet<>();
    }

    public String getName() {
        return name;
    }

    public boolean isNotReadyToPlay() {
        return this.handOfCards.size() != 5;
    }

    public Card getHighestCard() {
        return this.handOfCards.last();
    }

    public void giveCardToPlayer(Card card) {
        this.handOfCards.add(card);

    }

}
