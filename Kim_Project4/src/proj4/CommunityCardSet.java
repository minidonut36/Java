/**
 * Models a collection of community cards
 */

package proj4;

import java.util.ArrayList;

public class CommunityCardSet {

    private final int MAX_COLLECTION = 5;
    private final int FIRST_CARD = 0;

    private ArrayList<Card> collection;

    /**
     * Non-default constructor for the community card set
     * @param cardList a list of cards that should be in the community card set
     */
    public CommunityCardSet(ArrayList<Card> cardList) {
        collection = new ArrayList<Card>(cardList);
    }

    /**
     * Adds the card to the community card set if it does not have 5 cards
     * @param card a Card object that will be added to the hand
     */
    public void addCard(Card card) {
        if (getCollection().size() < MAX_COLLECTION) {
            getCollection().add(card);
        }
    }

    /**
     * Getter for the card at the given index
     * @param index an integer greater or equal to 0
     * @return a Card object at the given index or null if index is invalid
     */
    public Card getIthCard(int index){
        if (FIRST_CARD <= index && index < getCollection().size()) {
            return getCollection().get(index);
        }

        else {
            return null;
        }
    }

    /**
     * Returns the readable version of the community card set
     * @return a string for the readable version of the community card set
     */
    public String toString(){
        String returnString = "";

        for (Card card : getCollection()) {
            returnString += card + "\n";
        }

        return returnString;
    }

    /**
     * Gets the collection of the community card set
     * @return an array list for the collection
     */
    public ArrayList<Card> getCollection() {
        return collection;
    }
}