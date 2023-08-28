/**
 * Models a 5-card poker hand
 */

package proj4;

import java.util.ArrayList;
import java.util.Comparator;

public class PokerHand {

    private final int MAX_HAND = 5;
    private final int TIE = 0;
    private final int START = 0;
    private final int FLUSH = 4;
    private final int TWO_PAIR = 3;
    private final int PAIR = 2;
    private final int HIGH_CARD = 1;
    private final int FIRST_CARD = 0;
    private final int LAST_CARD = 1;

    private ArrayList<Card> pokerHand;

    /**
     * Non-default constructor for the hand
     * @param cardList a list of cards that should be in the hand
     */
    public PokerHand(ArrayList<Card> cardList) {
        pokerHand = new ArrayList<Card>(cardList);
    }

    /**
     * Adds the card to the hand if the hand does not have 5 cards in it
     * @param card a proj4.Card object that will be added to the hand
     */
    public void addCard(Card card) {
        if (getPokerHand().size() < MAX_HAND) {
            getPokerHand().add(card);
        }
    }

    /**
     * Getter for the card at the given index
     * @param index an integer greater or equal to 0
     * @return a card object at the given index or null if index is invalid
     */
    public Card getIthCard(int index) {
        if (FIRST_CARD <= index && index < getPokerHand().size()) {
            return getPokerHand().get(index);
        }

        else {
            return null;
        }
    }

    /**
     * Returns the readable version of the hand
     * @return a string for the readable version of the hand
     */
    public String toString() {
        String returnString = "";

        for (Card card : getPokerHand()) {
            returnString += card + "\n";
        }

        return returnString;
    }

    /**
     * Determines how this hand compares to another hand, returns
     * positive, negative, or zero depending on the comparision.
     *
     * @param other The hand to compare this hand to
     * @return a negtive number if this is worth LESS than other, zero
     * if they are worth the SAME, and a positive number if this is worth
     * MORE than other
     */
    public int compareTo(PokerHand other) {
        int myPoint = getPoint();
        int otherPoint = other.getPoint();

        int result = myPoint - otherPoint;

        if (result == TIE) {
            if (myPoint == FLUSH || myPoint == HIGH_CARD) {
                return compareFlushHighCard(other);
            }

            else if (myPoint == TWO_PAIR || myPoint == PAIR) {
                return compareTwoPairPair(other);
            }

            else {
                System.out.println("These hands are invalid");
            }
        }

        return result;
    }

    /**
     * Gets the poker hand
     * @return an array list for the poker hand
     */
    private ArrayList<Card> getPokerHand() {
        return pokerHand;
    }

    /** Gets the point of the hand
     * @return an integer for the point of the hand
     */
    private int getPoint() {
        int handScore;

        if (isFlush()){
            handScore = FLUSH;
        }

        else if (isTwoPair()){
            handScore = TWO_PAIR;
        }

        else if (isPair()){
            handScore = PAIR;
        }

        else {
            handScore = HIGH_CARD;
        }

        return handScore;
    }

    /**
     * Compares two flush or high card hands
     * @param other a PokerHand object that is compared with this hand
     * @return an integer for the result
     */
    private int compareFlushHighCard (PokerHand other) {
        ArrayList<Integer> myFlushRankList = getFlushRankList();
        ArrayList<Integer> otherFlushRankList = other.getFlushRankList();

        for (int i = START; i < MAX_HAND; i++) {
            int result = getIthRank(i, myFlushRankList) - getIthRank(i, otherFlushRankList);

            if (result != TIE) {
                return result;
            }
        }

        return TIE;
    }

    /**
     * Compares two two pair or pair hands
     * @param other a PokerHand object that is compared with this hand
     * @return an integer for the result
     */
    private int compareTwoPairPair(PokerHand other) {
        ArrayList<Integer> myPairRankList = getPairRankList();
        ArrayList<Integer> otherPairRankList = other.getPairRankList();

        for (int i = START; i < myPairRankList.size(); i++) {
            int result = getIthRank(i, myPairRankList) - getIthRank(i, otherPairRankList);

            if (result != TIE) {
                return result;
            }
        }

        return TIE;
    }

    /**
     * Gets the flush rank list
     * @return an array list for the flush rank list
     */
    private ArrayList<Integer> getFlushRankList() {
        ArrayList<Integer> rankFlushList = new ArrayList<Integer>();

        for (Card card : getPokerHand()) {
            rankFlushList.add(card.getRank());
        }

        rankFlushList.sort(Comparator.reverseOrder());

        return rankFlushList;
    }

    /**
     * Gets the pair rank list
     * @return an array list for the pair rank list
     */
    private ArrayList<Integer> getPairRankList() {
        PokerHand currentHand = new PokerHand(getPokerHand());

        int i = 1;
        ArrayList<Integer> pairRankList = new ArrayList<Integer>();
        ArrayList<Integer> otherRankList = new ArrayList<Integer>();

        while (currentHand.getPokerHand().size() > i) {
            if (currentHand.getIthCard(FIRST_CARD).getRank() == currentHand.getIthCard(i).getRank()) {
                pairRankList.add(currentHand.getIthCard(FIRST_CARD).getRank());

                currentHand.removeIthCard(i);
                currentHand.removeIthCard(FIRST_CARD);

                i = 1;
            } else {
                i++;
            }

            if (currentHand.getPokerHand().size() == i) {
                otherRankList.add(currentHand.getIthCard(FIRST_CARD).getRank());

                currentHand.removeIthCard(FIRST_CARD);

                i = 1;
            }

            if (currentHand.getPokerHand().size() == LAST_CARD) {
                otherRankList.add(currentHand.getIthCard(FIRST_CARD).getRank());

                currentHand.removeIthCard(FIRST_CARD);
            }
        }

        pairRankList.sort(Comparator.reverseOrder());
        otherRankList.sort(Comparator.reverseOrder());

        pairRankList.addAll(otherRankList);

        return pairRankList;
    }

    /**
     * Getter for the rank at the given index
     * @param index an integer for the index of the rank
     * @rank an integer at the given index
     */
    private int getIthRank(int index, ArrayList<Integer> rankList) {return rankList.get(index);}

    /**
     * Removes the card with the given index
     * @param index an integer for the index of the card
     */
    private void removeIthCard(int index) {
        if (index < getPokerHand().size()) {
            getPokerHand().remove(index);
        }
    }

    /**
     * Checks whether the hand is flush
     * @return true if all cards have the same suit
     */
    private boolean isFlush() {
        for (int i = 1; i < MAX_HAND; i++) {
            if (getIthCard(i).getSuit() != getIthCard(i - 1).getSuit()) {
                return false;
            }
        }

        return true;
    }

    /**
     * Checks whether the hand is two pair
     * @return true if the hand has 2 pairs of the same rank
     */
    private boolean isTwoPair() {
        PokerHand currentHand = new PokerHand(getPokerHand());

        int i = 1;
        int totalPair = 0;

        while (currentHand.getPokerHand().size() > i) {
            if (currentHand.getIthCard(FIRST_CARD).getRank() == currentHand.getIthCard(i).getRank()) {
                totalPair++;

                currentHand.removeIthCard(i);
                currentHand.removeIthCard(FIRST_CARD);

                i = 1;
            }

            else {
                i++;
            }

            if (currentHand.getPokerHand().size() == i) {
                currentHand.removeIthCard(FIRST_CARD);

                i = 1;
            }

            if (currentHand.getPokerHand().size() == LAST_CARD) {
                currentHand.removeIthCard(FIRST_CARD);
            }
        }
        if (totalPair == 2) {
            return true;
        }

        return false;
    }
    /**
     * Checks whether the hand is a pair
     * @return true if the hand has a pair of the same rank
     */
    private boolean isPair() {
        PokerHand currentHand = new PokerHand(getPokerHand());

        int i = 1;
        int totalPair = 0;

        while (currentHand.getPokerHand().size() > i) {
            if (currentHand.getIthCard(FIRST_CARD).getRank() == currentHand.getIthCard(i).getRank()) {
                totalPair++;

                currentHand.removeIthCard(i);
                currentHand.removeIthCard(FIRST_CARD);

                i = 1;
            }

            else {
                i++;
            }

            if (currentHand.getPokerHand().size() == i) {
                currentHand.removeIthCard(FIRST_CARD);

                i = 1;
            }

            if (currentHand.getPokerHand().size() == LAST_CARD) {
                currentHand.removeIthCard(FIRST_CARD);
            }
        }

        if (totalPair == 1) {
            return true;
        }

        return false;
    }
}