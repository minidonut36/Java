/**
 * Models a 2-card poker hand
 */

package proj4;

import java.util.ArrayList;

public class StudPokerHand {

    private final int MAX_HAND = 2;
    private final int FIRST_CARD = 0;
    private final int START = 0;
    private final int MAX_CANDIDATE = 7;

    private CommunityCardSet collection;
    private ArrayList<Card> twoCardHand;

    /**
     * Non-default constructor for the stud poker hand
     * @param cc a CommunityCardSet object for the community card set
     * @param cardList an array list for the hand
     */
    public StudPokerHand(CommunityCardSet cc, ArrayList<Card> cardList) {
        collection = new CommunityCardSet(cc.getCollection());
        twoCardHand = new ArrayList<Card>(cardList);
    }

    /**
     * Adds the card to the hand if the hand does not have 2 cards
     * @param card a proj4.Card object that will be added to the hand
     */
    public void addCard(Card card) {
        if (getTwoCardHand().size() < MAX_HAND) {
            getTwoCardHand().add(card);
        }
    }

    /**
     * Getter for the card at the given index
     * @param index an integer greater or equal to 0
     * @return a card object at the given index or null if index is invalid
     */
    public Card getIthCard(int index){
        if (FIRST_CARD <= index && index < getTwoCardHand().size()) {
            return getTwoCardHand().get(index);
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

        for (Card card : getTwoCardHand()) {
            returnString += card + "\n";
        }

        return returnString;
    }

    /**
     * Determines how this hand compares to another hand, using the
     * community card set to determine the best 5-card hand it can
     * make. Returns positive, negative, or zero depending on the comparison.
     *
     * @param other The hand to compare this hand to
     * @return a negative number if this is worth LESS than other, zero
     * if they are worth the SAME, and a positive number if this is worth
     * MORE than other
     */
    public int compareTo(StudPokerHand other) {
        return getBestFiveCardHand().compareTo(other.getBestFiveCardHand());
    }

    /**
     * Gets the best poker hand among all poker hands
     * @return an array list for the best poker hand
     */
    private PokerHand getBestFiveCardHand() {
        ArrayList<PokerHand> hands = getAllFiveCardHands();
        PokerHand bestSoFar = hands.get(START);

        for (int i = 1; i < hands.size(); i++) {
            if (hands.get(i).compareTo(bestSoFar) > 0) {
                bestSoFar = hands.get(i);
            }
        }

        return bestSoFar;
    }

    /**
     * Gets all possible poker hands
     * @return an array list of poker hands
     */
    private ArrayList<PokerHand> getAllFiveCardHands() {
        ArrayList<Card> candidate = getCandidate();
        ArrayList<PokerHand> allFiveCardHands = new ArrayList<PokerHand>();

        for (int i = START; i < MAX_CANDIDATE; i++) {
            for (int j = i + 1; j < MAX_CANDIDATE; j++) {
                candidate.remove(j);
                candidate.remove(i);

                allFiveCardHands.add(new PokerHand(candidate));

                candidate = getCandidate();
            }
        }

        return allFiveCardHands;
    }

    /**
     * Gets the candidate for the poker hand
     * @return an array list for the candidate
     */
    private ArrayList<Card> getCandidate() {
        ArrayList<Card> candidate = new ArrayList<Card>();
        candidate.addAll(getCollection());
        candidate.addAll(getTwoCardHand());

        return candidate;
    }

    /**
     * Gets the collection of the community card set
     * @return an array list for the collection
     */
    private ArrayList<Card> getCollection() {
        return collection.getCollection();
    }

    /**
     * Gets two card hand
     * @return an array list for the two card hand
     */
    private ArrayList<Card> getTwoCardHand() {
        return twoCardHand;
    }

    /**
     * Gets the result according to the given value
     * @return a string according to the given value
     */
    public String getResult(StudPokerHand other) {
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