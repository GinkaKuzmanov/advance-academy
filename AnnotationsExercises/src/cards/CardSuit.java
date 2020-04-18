package cards;

@CardInfo(type = "Enumeration",category = "Suit",
description = "Provides suit constants for a cards.Card class.")
public enum CardSuit {
    CLUBS(0),DIAMONDS(13),HEARTS(26),SPADES(39);

    private final int power;

    CardSuit(int power){
        this.power = power;
    }

    public int getPower() {
        return this.power;
    }


}
