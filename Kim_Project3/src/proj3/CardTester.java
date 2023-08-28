package proj3;

import java.lang.reflect.Array;

public class CardTester {

    private final int START = 0;
    private final int[] INTEGER_RANKS = new int[] {11, 12, 13, 14};
    private final String[] STRING_RANKS = new String[] {"Jack", "Queen", "King", "Ace"};

    public static void main(String[] args) {
        CardTester cardTester = new CardTester();

        Testing.startTests();
        cardTester.testCardConstructor();
        cardTester.testGetRank();
        cardTester.testGetSuit();
        cardTester.testGetStringRank();
        Testing.finishTests();
    }

    private void testCardConstructor() {
        Card card = new Card(2, "Hearts");
        String msg = "Starts testing card constructor and toString method";
        String expected = "2 of Hearts";
        String actual = card.toString();

        Testing.assertEquals(msg, expected, actual);
    }

    private void testGetRank() {
        Card card = new Card(2, "Hearts");
        String msg = "Starts testing getRank method";
        int expected = 2;
        int actual = card.getRank();

        Testing.assertEquals(msg, expected, actual);
    }

    private void testGetSuit() {
        Card card = new Card(2, "Hearts");
        String msg = "Starts testing getSuit method";
        String expected = "Hearts";
        String actual = card.getSuit();

        Testing.assertEquals(msg, expected, actual);
    }

    private void testGetStringRank() {
        for (int i = START; i < INTEGER_RANKS.length; i++) {
            Card card = new Card((int) Array.get(INTEGER_RANKS, i), "Hearts");
            String expected = Array.get(STRING_RANKS, i).toString();
            String msg = "Start testing string rank " + expected;
            String actual = card.getStringRank();

            Testing.assertEquals(msg, expected, actual);
        }
    }
}