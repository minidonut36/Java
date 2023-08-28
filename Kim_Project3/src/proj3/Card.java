/**
 * Models a single playing card
 */

package proj3; // do not erase. Gradescope expects this.

public class Card {

    private final int JACK = 11;
    private final int QUEEN = 12;
    private final int KING = 13;
    private final int ACE = 14;
    private int rank;
    private String suit;

    /**
     * Non-default constructor for Card
     * @param rank an integer for the rank
     * @param suit a string for the suit
     */
    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * Getter for the rank
     * @return an integer for the rank
     */
    public int getRank() {return rank;}

    /**
     * Getter for the suit
     * @return a string for the suit
     */
    public String getSuit() {return suit;}

    /**
     * Gets the string version of the rank
     * @return a string for the rank
     */
    public String getStringRank() {
        int currentRank = getRank();
        String stringRank;

        if (currentRank == JACK) {
            stringRank = "Jack";
        }

        else if (currentRank == QUEEN) {
            stringRank = "Queen";
        }

        else if (currentRank == KING) {
            stringRank = "King";
        }

        else if (currentRank == ACE) {
            stringRank = "Ace";
        }

        else {
            stringRank = String.valueOf(currentRank);
        }

        return stringRank;
    }

    /**
     * Returns the readable version of the card
     * @return a string for the readable version of the card
     */
    public String toString() {
        return getStringRank() + " of " + getSuit();
    }
}