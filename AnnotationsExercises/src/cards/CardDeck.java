package cards;

import java.util.HashMap;
import java.util.Map;

public class CardDeck {

    private final Map<String, Card> deck;


    public CardDeck() {
        this.deck = new HashMap<>();
        this.generateDeck();
    }

    private void generateDeck() {
        for (CardSuit suit : CardSuit.values()) {
            for (CardRank rank : CardRank.values()) {
               Card card = new Card(rank, suit);
                deck.put(card.toString(), card);
            }
        }
    }

    public Card retrieveFromDeck(String cardInfo) {
        if (!this.deck.containsKey(cardInfo)) {
            throw new IllegalStateException("No such card exists.");
        }
        if(this.deck.get(cardInfo) == null){
            throw new IllegalArgumentException("Card is not in the deck.");
        }
        //save then set to null and delete from deck.
        Card card = this.deck.remove(cardInfo);
        this.deck.put(cardInfo,null);
        return card;
    }
}
