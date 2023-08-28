/**
 * Models a single playing card
 */

package proj4;

import java.util.ArrayList;
import java.util.Arrays;

public class Card {

    private final String[] STRING_RANKS = new String[] {"two", "three", "four", "five", "six", "seven", "eight", "nine",
            "ten", "jack", "queen", "king", "ace"};
    private final String[] STRING_SUITS = new String[] {"Spades", "Hearts", "Clubs", "Diamonds"};
    private final int DEFAULT_RANK = 14;
    private final String DEFAULT_SUIT = "Spades";
    private final String[] STRING_NUMERIC_RANKS = new String[] {"2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12",
            "13", "14"};
    private final int[] INT_RANKS = new int[] {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
    private final int[] INT_SUITS = new int[] {0, 1, 2, 3};

    private int rank;
    private String suit;


    /**
     * Constructor
     * @param stringRank String: whole cards (2-10) can either be spelled
     * out like "two" or numeric like "2". Face cards will always be
     * spelled out like "Jack". Case insensitive.
     * @param stringSuit String: "Spades", "Hearts", "Clubs", or "Diamonds"
     */
    public Card(String stringRank, String stringSuit) {
        stringRank = stringRank.toLowerCase();
        stringSuit = getStandard(stringSuit);

        if (isIn(stringRank, STRING_RANKS) && isIn(stringSuit, STRING_SUITS)) {
            rank = toNumericRank(stringRank);
            suit = stringSuit;
        }

        else if (isIn(stringRank, STRING_NUMERIC_RANKS) && isIn(stringSuit, STRING_SUITS)) {
            rank = Integer.valueOf(stringRank);
            suit = stringSuit;
        }

        else {
            rank = DEFAULT_RANK;
            suit = DEFAULT_SUIT;

        }
    }

    /**
     * Constructor
     * @param intRank integer between 2-14
     * @param intSuit integer: 0=Spades, 1=Hearts, 2=Clubs, or 3=Diamonds
     */
    public Card(int intRank, int intSuit) {
        if (isIn(intRank, INT_RANKS) && isIn(intSuit, INT_SUITS)) {
            rank = intRank;
            suit = STRING_SUITS[intSuit];
        }

        else {
            rank = DEFAULT_RANK;
            suit = DEFAULT_SUIT;
        }
    }

    /**
     * Getter for the rank
     * @retrun an integer for the rank
     */
    public int getRank() {
        return rank;
    }

    /**
     * Getter for the suit
     * @retrun an integer for the suit
     */
    public String getSuit() {
        return suit;
    }

    /**
     * Returns the readable version of the card
     * @return a string for the readable version of the card
     */
    public String toString() {
        return getStringRank() + " of " + getSuit();
    }

    /**
     * Gets the standard version of the given string
     * @param myString a string for the non-standard version
     * @return a string for the standard version
     */
    private String getStandard(String myString) {
        return myString.substring(0, 1).toUpperCase() + myString.substring(1).toLowerCase();
    }

    /**
     * Checks whether the value is in the array
     * @param value a string to check
     * @param array a string array to check
     * @return true if the value is in the array
     */
    private boolean isIn(String value, String[] array) {
        return Arrays.asList(array).contains(value);
    }

    /**
     * Gets the numeric version of the rank
     * @param stringRank a string for the rank
     * @return a string for the numeric version of the rank
     */
    private int toNumericRank(String stringRank) {
        return INT_RANKS[Arrays.asList(STRING_RANKS).indexOf(stringRank)];
    }

    /**
     * Checks whether the value is in the array
     * @param value an integer to check
     * @param array an integer array to check
     * @return true if the value is in the array
     */
    private boolean isIn(int value, int[] array) {
        ArrayList<Integer> intArrayList = new ArrayList<Integer>();

        for (int i : array) {
            intArrayList.add(i);
        }

        return intArrayList.contains(value);
    }

        /**
         * Gets the string version of the rank
         * @return a string for the string version of the rank
         */
        private String getStringRank() {
            int currentRank = getRank();
            if (currentRank > 10) {
                return getStandard(STRING_RANKS[currentRank - 2]);
            }

            else {
                return currentRank + "";
            }
        }
}