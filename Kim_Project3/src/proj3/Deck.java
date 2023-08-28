/**
 * Models a deck of cards
 */

package proj3; // do not erase. Gradescope expects this.

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Deck {

    private final int START = 0;
    private final int[] RANKS = new int[] {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
    private final String[] SUITS = new String[] {"Hearts", "Diamonds", "Spades", "Clubs"};
    private final int MAX_DECK = 52;
    private final int EMPTY = 0;
    private ArrayList<Card> deck = new ArrayList<Card>();
    private int nextToDeal;

    /**
     * Default constructor for the deck
     */
    public Deck() {
        for (int rank : RANKS) {
            for (String suit : SUITS) {
                deck.add(new Card(rank, suit));
            }
        }

        nextToDeal = START;
    }

    /**
     * Shuffles the deck
     */
    public void shuffle() {
        for (int i = nextToDeal; i < MAX_DECK; i++) {
            int randomNumber = ThreadLocalRandom.current().nextInt(nextToDeal, MAX_DECK);
            Card currentCard = deck.get(i);
            Card randomCard = deck.get(randomNumber);

            deck.set(i, randomCard);
            deck.set(randomNumber, currentCard);
        }
    }

    /**
     * Returns the next undealt card or null if deck is empty
     * @return the next undealt card or null if deck is empty
     */
    public Card deal(){
        if (deck.isEmpty()) {
            return null;
        }

        Card currentCard = deck.get(nextToDeal);

        nextToDeal++;

        return currentCard;
    }

    /**
     * Checks whether the deck is empty
     * @return true if there are still undealt cards in the deck
     */
    public boolean isEmpty() {
        if (size() == EMPTY){
            return true;
        }

        else {
            return false;
        }
    }

    /**
     * Returns the number of undealt cards in the deck
     * @return the number of undealt cards in the deck
     */
    public int size() {return MAX_DECK - nextToDeal;}

    /**
     * Returns the deck to a state where all cards are undealt in a shuffled state
     */
    public void gather() {nextToDeal = START;}

    /**
     * Returns all the undealt cards in the deck as a string
     * @return all the undealt cards in the deck as a string
     */
    public String toString() {
        String returnString = "";

        for (int i = nextToDeal; i < MAX_DECK; i++) {
            returnString += deck.get(i) + "\n";
        }

        return returnString;
    }

    /**
     * Deals the card i times
     * @return an array list for the card list
     */
    public ArrayList dealITimes(int i){
        ArrayList<Card> cardList = new ArrayList<Card>();

        for (int j = START; j < i; j++) {
            cardList.add(deal());
        }

        return cardList;
    }
}