/**
 * A simple texas hold'em poker game
 */

package proj4;

import java.util.Scanner;
import java.util.Arrays;

public class Client {

    private final boolean CONTINUE = true;
    private final int MAX_COLLECTION = 5;
    private final int MAX_HAND = 2;
    private final String[] VALID_ANSWERS = new String[] {"my hand", "other hand", "tie"};

    /**
     * @author Chris Hegang Kim
     * @note I affirm that I have carried out the attached academic endeavors with full academic honesty,
     * in accordance with the Union College Honor Code and the course syllabus.
     */
    public static void main(String[] args) {
        Client client = new Client();
        Deck deck = new Deck();
        deck.shuffle();
        CommunityCardSet communityCardSet = new CommunityCardSet(deck.dealITimes(client.MAX_COLLECTION));
        boolean continueGame = client.CONTINUE;
        int totalPoint = 0;

        while (continueGame && deck.size() >= client.MAX_HAND * 2) {
            StudPokerHand myHand = new StudPokerHand(communityCardSet, deck.dealITimes(client.MAX_HAND));
            StudPokerHand otherHand = new StudPokerHand(communityCardSet, deck.dealITimes(client.MAX_HAND));
            String result = myHand.getResult(otherHand);

            client.printInstruction(communityCardSet, myHand, otherHand);

            if (client.getValidAnswer().equals(result)) {
                System.out.println("CORRECT\n--------------------------------------------------");
                totalPoint++;
            }

            else {
                continueGame = ! client.CONTINUE;
            }
        }

        System.out.println("Game is over, and your total point is " + totalPoint);
    }

    /**
     * Prints the instruction
     * @param communityCardSet CommunityCardSet object for the community card set
     * @param myHand StudPokerHand object for the hand
     * @param otherHand StudPokerHand object for another hand
     */
    private void printInstruction(CommunityCardSet communityCardSet, StudPokerHand myHand, StudPokerHand otherHand) {
        System.out.println("community card set: " + communityCardSet);
        System.out.println("Who is the winner?");
        System.out.println("my hand: " + myHand);
        System.out.println("other hand: " + otherHand);
    }

    /**
     * Gets the valid answer from the user
     * @return a string for the valid answer
     */
    private String getValidAnswer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type my hand, other hand, or tie");

        String userInput = sc.nextLine();

        while (! Arrays.asList(VALID_ANSWERS).contains(userInput)) {
            System.out.println("Your answer is invalid. Type my hand, other hand, or tie");
            userInput = sc.nextLine();
        }
        return userInput;
    }
}