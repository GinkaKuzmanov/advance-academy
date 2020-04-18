package cards;

public class Card implements Comparable<Card> {
    private final CardSuit cardSuit;
    private final CardRank cardRank;

    public Card(CardRank rank,CardSuit cardSuit){
        this.cardSuit = cardSuit;
        this.cardRank = rank;
    }

    //retrieve the power of the card
    public int getCardPower(){
        return this.cardRank.getPower() + this.cardSuit.getPower();
    }

    public CardSuit getCardSuit() {
        return this.cardSuit;
    }

    public CardRank getCardRank() {
        return this.cardRank;
    }

    @Override
    public String toString() {
        return String.format("%s of %s",
                cardRank.name(),cardSuit.name());
    }

    @Override
    public int compareTo(Card o) {
        return this.getCardPower() - o.getCardPower();
    }
}
