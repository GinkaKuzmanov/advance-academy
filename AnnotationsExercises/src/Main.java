
import cards.Card;
import cards.CardDeck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


//Exercises:Enumeration and Annotations from SoftUni
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Player p1 = new Player(reader.readLine());
        Player p2 = new Player(reader.readLine());

        CardDeck deck = new CardDeck();

        while (p1.isNotReadyToPlay()) {
            //vzimame ot testeto i davame na igracha
            try {
                Card card = deck.retrieveFromDeck(reader.readLine());
                p1.giveCardToPlayer(card);
            } catch (IllegalStateException | IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }

        while (p2.isNotReadyToPlay()) {
            try {
                Card card = deck.retrieveFromDeck(reader.readLine());
                p2.giveCardToPlayer(card);
            } catch (IllegalStateException | IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }

        Player winner = getWinner(p1,p2);
        System.out.printf("%s wins with %s.",winner.getName(),winner.getHighestCard().toString());

    }

    private static Player getWinner(Player one, Player two) {
        if (one.getHighestCard().compareTo(two.getHighestCard()) > 0) {
            return one;
        }
        return two;
    }
}
