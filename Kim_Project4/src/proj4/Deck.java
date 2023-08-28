/**
 * Models a deck of cards
 */

package proj4;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Deck {

    private final int START = 0;
    private final int[] RANKS = new int[] {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
    private final int[] SUITS = new int[] {0, 1, 2, 3};
    private final int MAX_DECK = 52;
    private final int EMPTY = 0;

    private ArrayList<Card> deck;
    private int nextToDeal;

    /**
     * Default constructor for the deck
     */
    public Deck() {
        deck = new ArrayList<Card>();

        for (int rank : RANKS) {
            for (int suit : SUITS) {
                deck.add(new Card(rank, suit));
            }
        }

        nextToDeal = START;
    }

    /**
     * Shuffles the deck
     */
    public void shuffle() {
        for (int i = getNextToDeal(); i < MAX_DECK; i++) {
            int randomNumber = ThreadLocalRandom.current().nextInt(getNextToDeal(), MAX_DECK);
            Card currentCard = getDeck().get(i);
            Card randomCard = getDeck().get(randomNumber);

            getDeck().set(i, randomCard);
            getDeck().set(randomNumber, currentCard);
        }
    }

    /**
     * Returns the next undealt card or null if deck is empty
     * @return the next undealt card or null if deck is empty
     */
    public Card deal() {
        if (getDeck().isEmpty()) {
            return null;
        }

        else {
            Card currentCard = getDeck().get(getNextToDeal());

            nextToDeal++;

            return currentCard;
        }
    }

    /**
     * Resets the deck to a state where all cards are undealt in a shuffled state
     */
    public void gather() {nextToDeal = START;}

    /**
     * Returns the number of undealt cards in the deck
     * @return the number of undealt cards in the deck
     */
    public int size() {return MAX_DECK - getNextToDeal();}

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
     * Returns all the undealt cards in the deck as a string
     * @return all the undealt cards in the deck as a string
     */
    public String toString() {
        String returnString = "";

        for (int i = getNextToDeal(); i < MAX_DECK; i++) {
            returnString += getDeck().get(i) + "\n";
        }

        return returnString;
    }

    /**
     * Gets the deck
     * @return a Deck object for the deck
     */
    private ArrayList<Card> getDeck() {
        return deck;
    }

    /**
     * Gets the value of nextToDeal
     * @return an integer for the nextToDeal
     */
    private int getNextToDeal() {
        return nextToDeal;
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