package proj4;

import java.util.ArrayList;
import java.util.Arrays;

public class CommunityCardSetTester {

    private final int MAX_COLLECTION = 5;

    public static void main(String[] args) {
        CommunityCardSetTester communityCardSetTester = new CommunityCardSetTester();

        Testing.startTests();
        communityCardSetTester.testCommunityCardSetConstructor();
        communityCardSetTester.testAddCard();
        communityCardSetTester.testGetIthCard();
        communityCardSetTester.testGetCollection();
        Testing.finishTests();
    }

    private void testCommunityCardSetConstructor() {
        Deck deck = new Deck();
        CommunityCardSet communityCardSet = new CommunityCardSet(deck.dealITimes(MAX_COLLECTION));
        String msg = "Start testing CommunityCardSet constructor and toString method";
        String expected = "2 of Spades\n" + "2 of Hearts\n" + "2 of Clubs\n" + "2 of Diamonds\n" + "3 of Spades\n";
        CommunityCardSet actual = communityCardSet;

        Testing.assertEquals(msg, expected, actual.toString());
    }

    private void testAddCard() {
        testNotFullCollection();
        testFullCollection();
    }

    private void testNotFullCollection() {
        Deck deck = new Deck();
        CommunityCardSet communityCardSet = new CommunityCardSet(deck.dealITimes(MAX_COLLECTION - 1));
        String msg = "Start testing addCard method in the not full collection";
        String expected = "2 of Spades\n" + "2 of Hearts\n" + "2 of Clubs\n" + "2 of Diamonds\n" + "3 of Spades\n";
        communityCardSet.addCard(deck.deal());
        CommunityCardSet actual = communityCardSet;

        Testing.assertEquals(msg,expected, actual.toString());
    }

    private void testFullCollection() {
        Deck deck = new Deck();
        CommunityCardSet communityCardSet = new CommunityCardSet(deck.dealITimes(MAX_COLLECTION));
        String msg = "Start testing addCard method in the full collection";
        String expected = "2 of Spades\n" + "2 of Hearts\n" + "2 of Clubs\n" + "2 of Diamonds\n" + "3 of Spades\n";
        communityCardSet.addCard(deck.deal());
        CommunityCardSet actual = communityCardSet;

        Testing.assertEquals(msg,expected, actual.toString());
    }

    private void testGetIthCard() {
        Deck deck = new Deck();
        CommunityCardSet communityCardSet = new CommunityCardSet(deck.dealITimes(MAX_COLLECTION));
        String msg = "Start testing getIthCard method";
        String expected = "2 of Hearts";
        Card actual = communityCardSet.getIthCard(1);

        Testing.assertEquals(msg,expected, actual.toString());
    }

    private void testGetCollection() {
        Deck deck = new Deck();
        CommunityCardSet communityCardSet = new CommunityCardSet(deck.dealITimes(MAX_COLLECTION));
        String msg = "Start testing getCollection method";
        ArrayList<Card> expected = new ArrayList<Card>(Arrays.asList(new Card(2, 0),
                new Card(2, 1), new Card(2, 2), new Card(2, 3),
                new Card(3, 0)));
        ArrayList<Card> actual = communityCardSet.getCollection();

        Testing.assertEquals(msg, expected.toString(), actual.toString());
    }
}