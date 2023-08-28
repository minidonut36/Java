/**
 * Models a 5-card hand of cards
 */

package proj3; // do not erase. Gradescope expects this.

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

    private ArrayList<Card> hand;
    private ArrayList<Integer> rankList;

    /**
     * Non-default constructor for the hand
     * @param cardList a list of cards that should be in the hand
     */
    public PokerHand(ArrayList<Card> cardList) {
        hand = new ArrayList<Card>(cardList);
    }

    /**
     * Adds the card to the hand if the hand does not have 5 cards in it
     * @param card a Card object that will be added to the hand
     */
    public void addCard(Card card) {
        if (hand.size() < MAX_HAND) {
            hand.add(card);
        }
    }

    /**
     * Getter for the card at the given index
     * @param index an integer greater or equal to 0
     * @return a card object at the given index or null if index is invalid
     */
    public Card getIthCard(int index){
        if (index < hand.size()) {
            return hand.get(index);
        }

        else {
            return null;
        }
    }

    /**
     * Returns the readable version of the hand
     * @return a string for the readable version of the hand
     */
    public String toString(){
        String returnString = "";

        for (Card card : hand) {
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
    public int compareTo(PokerHand other){
        int myPoint = getPoint();
        int otherPoint = other.getPoint();

        int result = myPoint - otherPoint;

        if (result == TIE) {
            if (myPoint == FLUSH || myPoint == HIGH_CARD) {
                getRankList();
                other.getRankList();

                for (int i = START; i < MAX_HAND; i++) {
                    result = getIthRank(i) - other.getIthRank(i);

                    if (result != TIE) {
                        return result;
                    }
                }
            }

            else if (myPoint == TWO_PAIR || myPoint == PAIR) {
                for (int i = START; i < rankListSize(); i++) {
                    result = getIthRank(i) - other.getIthRank(i);

                    if (result != TIE) {
                        return result;
                    }
                }
            }

            else {
                System.out.println("These hands are invalid");
            }
        }

        return result;
    }

    /** Gets the point of the hand
     * @return an integer for the point of the hand
     */
    private int getPoint(){
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
     * Gets the list with ranks in the descending order
     */
    private void getRankList() {
        ArrayList<Integer> rankList = new ArrayList<Integer>();

        for (Card card : hand) {
            rankList.add(card.getRank());
        }

        rankList.sort(Comparator.reverseOrder());

        this.rankList = rankList;
    }

    /**
     * Getter for the rank at the given index
     * @param index an integer for the index of the rank
     * @rank an integer at the given index
     */
    private int getIthRank(int index){return rankList.get(index);}

    /**
     * Returns the size of the rank list
     * @return an integer for the size of the rank list
     */
    private int rankListSize(){return rankList.size();}

    /**
     * Returns the number of cards left in the hand
     * @return an integer for cards left in the hand
     */
    private int size(){return hand.size();}

    /**
     * Removes the card with the given index
     * @param index an integer for the index of the card
     */
    private void removeIthCard(int index) {
        if (index < hand.size()) {
            hand.remove(index);
        }
    }

    /**
     * Checks whether the hand is flush
     * @return true if all cards have the same suit
     */
    private boolean isFlush(){
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
    private boolean isTwoPair(){
        PokerHand currentHand = new PokerHand(hand);

        int i = 1;
        int totalPair = 0;
        ArrayList<Integer> pairRankList = new ArrayList<Integer>();
        ArrayList<Integer> otherRankList = new ArrayList<Integer>();

        while (currentHand.size() > i) {
            if (currentHand.getIthCard(FIRST_CARD).getRank() == currentHand.getIthCard(i).getRank()) {
                totalPair++;

                pairRankList.add(currentHand.getIthCard(FIRST_CARD).getRank());

                currentHand.removeIthCard(i);
                currentHand.removeIthCard(FIRST_CARD);

                i = 1;
            }

            else {
                i++;
            }

            if (currentHand.size() == i) {
                otherRankList.add(currentHand.getIthCard(FIRST_CARD).getRank());

                currentHand.removeIthCard(FIRST_CARD);

                i = 1;
            }

            if (currentHand.size() == LAST_CARD) {
                otherRankList.add(currentHand.getIthCard(FIRST_CARD).getRank());

                currentHand.removeIthCard(FIRST_CARD);
            }
        }
        if (totalPair == 2) {
            pairRankList.sort(Comparator.reverseOrder());
            otherRankList.sort(Comparator.reverseOrder());

            pairRankList.addAll(otherRankList);

            this.rankList = pairRankList;

            return true;
        }

        return false;
    }
    /**
     * Checks whether the hand is a pair
     * @return true if the hand has a pair of the same rank
     */
    private boolean isPair(){
        PokerHand currentHand = new PokerHand(hand);

        int i = 1;
        int totalPair = 0;
        ArrayList<Integer> pairRankList = new ArrayList<Integer>();
        ArrayList<Integer> otherRankList = new ArrayList<Integer>();

        while (currentHand.size() > i) {
            if (currentHand.getIthCard(FIRST_CARD).getRank() == currentHand.getIthCard(i).getRank()) {
                totalPair++;

                pairRankList.add(currentHand.getIthCard(FIRST_CARD).getRank());

                currentHand.removeIthCard(i);
                currentHand.removeIthCard(FIRST_CARD);

                i = 1;
            }

            else {
                i++;
            }

            if (currentHand.size() == i) {
                otherRankList.add(currentHand.getIthCard(FIRST_CARD).getRank());

                currentHand.removeIthCard(FIRST_CARD);

                i = 1;
            }

            if (currentHand.size() == LAST_CARD) {
                otherRankList.add(currentHand.getIthCard(FIRST_CARD).getRank());

                currentHand.removeIthCard(FIRST_CARD);
            }
        }

        if (totalPair == 1) {
            pairRankList.sort(Comparator.reverseOrder());
            otherRankList.sort(Comparator.reverseOrder());

            pairRankList.addAll(otherRankList);

            this.rankList = pairRankList;

            return true;
        }

        return false;
    }

    /**
     * Gets the result according to the given value
     * @return a string according to the given value
     */
    public String getResult(PokerHand other) {
        int result = compareTo(other);

        if (result > 0) {
            return "my hand";
        }

        else if (result < 0) {
            return "other hand";
        }

        else {
            return "tie";
        }
    }
}