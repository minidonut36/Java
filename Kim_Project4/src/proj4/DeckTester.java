package proj4;

import java.util.ArrayList;
import java.util.Random;

public class DeckTester {

    private final int START = 0;
    private final int MAX_DECK = 52;

    public static void main(String[] args) {
        DeckTester deckTester = new DeckTester();

        Testing.startTests();
        deckTester.testDeckConstructor();
        deckTester.testShuffle();
        deckTester.testDeal();
        deckTester.testGather();
        deckTester.testIsEmpty();
        deckTester.testSize();
        deckTester.testDealITimes();
        Testing.finishTests();
    }

    private void testDeckConstructor() {
        Deck deck = new Deck();
        String msg = "Starts testing deck constructor and toString method";
        String expected = "2 of Spades\n" + "2 of Hearts\n" + "2 of Clubs\n" + "2 of Diamonds\n" + "3 of Spades\n"
                + "3 of Hearts\n" + "3 of Clubs\n" + "3 of Diamonds\n" + "4 of Spades\n" + "4 of Hearts\n" + "4 of Clubs\n"
                + "4 of Diamonds\n" + "5 of Spades\n" + "5 of Hearts\n" + "5 of Clubs\n" + "5 of Diamonds\n" + "6 of Spades\n"
                + "6 of Hearts\n" + "6 of Clubs\n" + "6 of Diamonds\n" + "7 of Spades\n" + "7 of Hearts\n" + "7 of Clubs\n"
                + "7 of Diamonds\n" + "8 of Spades\n" + "8 of Hearts\n" + "8 of Clubs\n" + "8 of Diamonds\n" + "9 of Spades\n"
                + "9 of Hearts\n" + "9 of Clubs\n" + "9 of Diamonds\n" + "10 of Spades\n" + "10 of Hearts\n" + "10 of Clubs\n"
                + "10 of Diamonds\n" + "Jack of Spades\n" + "Jack of Hearts\n" + "Jack of Clubs\n" + "Jack of Diamonds\n"
                + "Queen of Spades\n" + "Queen of Hearts\n" + "Queen of Clubs\n" + "Queen of Diamonds\n" + "King of Spades\n"
                + "King of Hearts\n" + "King of Clubs\n" + "King of Diamonds\n" + "Ace of Spades\n" + "Ace of Hearts\n"
                + "Ace of Clubs\n" + "Ace of Diamonds\n";
        Deck actual = deck;

        Testing.assertEquals(msg, expected, actual.toString());
    }

    private void testShuffle() {
        Deck deck = new Deck();
        Deck shuffledDeck = new Deck();
        shuffledDeck.shuffle();
        String msg = "Start testing shuffle method";
        String expected = "Shuffled";
        String actual = "Shuffled";

        int totalMatch = 0;

        for (int i = START; i < MAX_DECK; i++) {
            if (deck.deal().toString().equals(shuffledDeck.deal().toString())) {
                totalMatch++;
            }
        }

        if (totalMatch > MAX_DECK / 2) {
            actual = "Not shuffled";
        }

        Testing.assertEquals(msg, expected, actual);
    }

    private void testDeal() {
        Deck deck = new Deck();
        String msg = "Starts testing deal method";
        Card expected = new Card(2, 0);
        Card actual = deck.deal();

        Testing.assertEquals(msg, expected.toString(), actual.toString());
    }

    private void testGather() {
        Deck deck = new Deck();

        deck.dealITimes(MAX_DECK);
        deck.gather();

        String msg = "Starts testing gather method";
        String expected = "2 of Spades\n" + "2 of Hearts\n" + "2 of Clubs\n" + "2 of Diamonds\n" + "3 of Spades\n"
                + "3 of Hearts\n" + "3 of Clubs\n" + "3 of Diamonds\n" + "4 of Spades\n" + "4 of Hearts\n" + "4 of Clubs\n"
                + "4 of Diamonds\n" + "5 of Spades\n" + "5 of Hearts\n" + "5 of Clubs\n" + "5 of Diamonds\n" + "6 of Spades\n"
                + "6 of Hearts\n" + "6 of Clubs\n" + "6 of Diamonds\n" + "7 of Spades\n" + "7 of Hearts\n" + "7 of Clubs\n"
                + "7 of Diamonds\n" + "8 of Spades\n" + "8 of Hearts\n" + "8 of Clubs\n" + "8 of Diamonds\n" + "9 of Spades\n"
                + "9 of Hearts\n" + "9 of Clubs\n" + "9 of Diamonds\n" + "10 of Spades\n" + "10 of Hearts\n" + "10 of Clubs\n"
                + "10 of Diamonds\n" + "Jack of Spades\n" + "Jack of Hearts\n" + "Jack of Clubs\n" + "Jack of Diamonds\n"
                + "Queen of Spades\n" + "Queen of Hearts\n" + "Queen of Clubs\n" + "Queen of Diamonds\n" + "King of Spades\n"
                + "King of Hearts\n" + "King of Clubs\n" + "King of Diamonds\n" + "Ace of Spades\n" + "Ace of Hearts\n"
                + "Ace of Clubs\n" + "Ace of Diamonds\n";
        Deck actual = deck;

        Testing.assertEquals(msg, expected, actual.toString());
    }

    private void testIsEmpty() {
        testNotEmptyDeck();
        testEmptyDeck();
    }

    private void testNotEmptyDeck() {
        Deck deck = new Deck();
        String msg = "Starts testing not empty deck";
        boolean expected = false;
        boolean actual = deck.isEmpty();

        Testing.assertEquals(msg, expected, actual);
    }

    private void testEmptyDeck() {
        Deck deck = new Deck();

        deck.dealITimes(MAX_DECK);

        String msg = "Starts testing empty deck";
        boolean expected = true;
        boolean actual = deck.isEmpty();

        Testing.assertEquals(msg, expected, actual);
    }

    private void testSize() {
        Deck deck = new Deck();
        String msg = "Starts testing size method";
        int expected = MAX_DECK;

        for (int i = START; i < MAX_DECK; i++) {
            deck.deal();
            expected--;

            int actual = deck.size();

            Testing.assertEquals(msg, expected, actual);
        }
    }

    private void testDealITimes() {
        Deck deck = new Deck();
        String msg = "Starts testing dealITimes method";
        ArrayList<Card> expected = new ArrayList<Card>();

        expected.add(new Card(2, 0));
        expected.add(new Card(2, 1));
        expected.add(new Card(2, 2));
        expected.add(new Card(2, 3));
        expected.add(new Card(3, 0));

        ArrayList<Card> actual = deck.dealITimes(5);

        Testing.assertEquals(msg, expected.toString(), actual.toString());
    }
}