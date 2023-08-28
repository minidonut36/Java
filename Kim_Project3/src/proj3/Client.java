/**
 * A simple poker game
 */

package proj3;

import java.util.Scanner;

public class Client {

    private final boolean CONTINUE = true;
    private final int MAX_HAND = 5;

    public static void main(String[] args) {
        Client client = new Client();
        Deck deck = new Deck();
        deck.shuffle();
        boolean continueGame = client.CONTINUE;
        int totalPoint = 0;

        while (continueGame && deck.size() > client.MAX_HAND * 2) {
            PokerHand myHand = new PokerHand(deck.dealITimes(client.MAX_HAND));
            PokerHand otherHand = new PokerHand(deck.dealITimes(client.MAX_HAND));
            String result = myHand.getResult(otherHand);

            System.out.println("my hand: " + myHand);
            System.out.println("other hand: " + otherHand);

            Scanner sc = new Scanner(System.in);
            System.out.println("Who is the winner? (Type my hand, other hand, or tie)");

            if (sc.nextLine().equals(result)) {
                totalPoint++;
            }

            else {
                continueGame = ! client.CONTINUE;
            }
        }

        System.out.println("Game is over, and your total point is " + totalPoint);
    }
}