package proj4;

import java.util.ArrayList;
import java.util.Arrays;

public class PokerHandTester {

    private final int MAX_HAND = 5;

    public static void main(String[] args) {
        PokerHandTester pokerHandTester = new PokerHandTester();

        Testing.startTests();
        pokerHandTester.testPokerHandConstructor();
        pokerHandTester.testAddCard();
        pokerHandTester.testGetIthCard();
        pokerHandTester.testCompareTo();
        Testing.finishTests();
    }

    private void testPokerHandConstructor() {
        Deck deck = new Deck();
        PokerHand hand = new PokerHand(deck.dealITimes(MAX_HAND));
        String msg = "Start testing PokerHand constructor and toString method";
        String expected = "2 of Spades\n" + "2 of Hearts\n" + "2 of Clubs\n" + "2 of Diamonds\n" + "3 of Spades\n";
        PokerHand actual = hand;

        Testing.assertEquals(msg,expected, actual.toString());
    }

    private void testAddCard() {
        testNotFullHand();
        testFullHand();
    }

    private void testNotFullHand() {
        Deck deck = new Deck();
        PokerHand hand = new PokerHand(deck.dealITimes(MAX_HAND - 1));
        String msg = "Start testing addCard method in the not full hand";
        String expected = "2 of Spades\n" + "2 of Hearts\n" + "2 of Clubs\n" + "2 of Diamonds\n" + "3 of Spades\n";
        hand.addCard(deck.deal());
        PokerHand actual = hand;

        Testing.assertEquals(msg,expected, actual.toString());
    }

    private void testFullHand() {
        Deck deck = new Deck();
        PokerHand hand = new PokerHand(deck.dealITimes(MAX_HAND));
        String msg = "Start testing addCard method in the full hand";
        String expected = "2 of Spades\n" + "2 of Hearts\n" + "2 of Clubs\n" + "2 of Diamonds\n" + "3 of Spades\n";
        hand.addCard(deck.deal());
        PokerHand actual = hand;

        Testing.assertEquals(msg,expected, actual.toString());
    }

    private void testGetIthCard() {
        Deck deck = new Deck();
        PokerHand hand = new PokerHand(deck.dealITimes(MAX_HAND));
        String msg = "Start testing getIthCard method";
        String expected = "2 of Hearts";
        Card actual = hand.getIthCard(1);

        Testing.assertEquals(msg,expected, actual.toString());
    }

    private void testCompareTo() {
        flushVsTwoPair();
        flushVsFlushHighCard1();
        flushVsFlushHighCard2();
        flushVsFlushHighCard3();
        flushVsFlushHighCard4();
        flushVsFlushHighCard5();
        flushVsFlushTie();

        twoPairVsPair();
        twoPairVsTwoPairHighCard1();
        twoPairVsTwoPairHighCard2();
        twoPairVsTwoPairHighCard3();
        twoPairVsTwoPairTie();

        pairVsHighCard();
        pairVsPairHighCard1();
        pairVsPairHighCard2();
        pairVsPairHighCard3();
        pairVsPairHighCard4();
        pairVsPairTie();

        highCardVsHighCard1();
        highCardVsHighCard2();
        highCardVsHighCard3();
        highCardVsHighCard4();
        highCardVsHighCard5();
        highCardVsHighCardTie();
    }

    private void flushVsTwoPair() {
        PokerHand hand = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, 1),
                new Card(14, 1), new Card(8, 1), new Card(7, 1),
                new Card(10, 1))));
        PokerHand other = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, 1),
                new Card(14, 1), new Card(8, 0), new Card(8, 1),
                new Card(9, 0))));
        String msg = "Start testing flush vs two pair";
        int expected = 1;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void flushVsFlushHighCard1() {
        PokerHand hand = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, 1),
                new Card(13, 1), new Card(12, 1), new Card(11, 1),
                new Card(10, 1))));
        PokerHand other = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(9, 1),
                new Card(13, 1), new Card(12, 1), new Card(11, 1),
                new Card(10, 1))));
        String msg = "Start testing flush vs flush (first high card)";
        int expected = 1;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void flushVsFlushHighCard2() {
        PokerHand hand = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, 1),
                new Card(13, 1), new Card(12, 1), new Card(11, 1),
                new Card(10, 1))));
        PokerHand other = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(9, 1),
                new Card(14, 1), new Card(12, 1), new Card(11, 1),
                new Card(10, 1))));
        String msg = "Start testing flush vs flush (second high card)";
        int expected = 1;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void flushVsFlushHighCard3() {
        PokerHand hand = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, 1),
                new Card(13, 1), new Card(12, 1), new Card(11, 1),
                new Card(10, 1))));
        PokerHand other = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(9, 1),
                new Card(14, 1), new Card(13, 1), new Card(11, 1),
                new Card(10, 1))));
        String msg = "Start testing flush vs flush (third high card)";
        int expected = 1;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void flushVsFlushHighCard4() {
        PokerHand hand = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, 1),
                new Card(13, 1), new Card(12, 1), new Card(11, 1),
                new Card(10, 1))));
        PokerHand other = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(9, 1),
                new Card(14, 1), new Card(13, 1), new Card(12, 1),
                new Card(10, 1))));
        String msg = "Start testing flush vs flush (fourth high card)";
        int expected = 1;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void flushVsFlushHighCard5() {
        PokerHand hand = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, 1),
                new Card(13, 1), new Card(12, 1), new Card(11, 1),
                new Card(10, 1))));
        PokerHand other = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(9, 1),
                new Card(14, 1), new Card(13, 1), new Card(12, 1),
                new Card(11, 1))));
        String msg = "Start testing flush vs flush (fifth high card)";
        int expected = 1;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void flushVsFlushTie() {
        PokerHand hand = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, 1),
                new Card(13, 1), new Card(12, 1), new Card(11, 1),
                new Card(10, 1))));
        PokerHand other = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(10, 1),
                new Card(14, 1), new Card(13, 1), new Card(12, 1),
                new Card(11, 1))));
        String msg = "Start testing flush vs flush (tie)";
        int expected = 0;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void twoPairVsPair() {
        PokerHand hand = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, 0),
                new Card(14, 1), new Card(8, 2), new Card(8, 0),
                new Card(10, 1))));
        PokerHand other = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, 0),
                new Card(14, 1), new Card(8, 2), new Card(9, 0),
                new Card(10, 1))));
        String msg = "Start testing two pair vs pair";
        int expected = 1;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void twoPairVsTwoPairHighCard1() {
        PokerHand hand = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, 0),
                new Card(14, 1), new Card(8, 2), new Card(8, 0),
                new Card(9, 1))));
        PokerHand other = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(13, 0),
                new Card(13, 1), new Card(11, 2), new Card(11, 0),
                new Card(9, 1))));
        String msg = "Start testing two pair vs two pair (first high pair card)";
        int expected = 1;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void twoPairVsTwoPairHighCard2() {
        PokerHand hand = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, 0),
                new Card(14, 1), new Card(8, 2), new Card(8, 0),
                new Card(9, 1))));
        PokerHand other = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, 1),
                new Card(14, 0), new Card(7, 1), new Card(7, 2),
                new Card(9, 1))));
        String msg = "Start testing two pair vs two pair (second high pair card)";
        int expected = 1;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void twoPairVsTwoPairHighCard3() {
        PokerHand hand = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, 1),
                new Card(14, 0), new Card(8, 2), new Card(8, 1),
                new Card(10, 0))));
        PokerHand other = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, 1),
                new Card(14, 0), new Card(8, 1), new Card(8, 2),
                new Card(9, 0))));
        String msg = "Start testing two pair vs two pair (third high card)";
        int expected = 1;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void twoPairVsTwoPairTie() {
        PokerHand hand = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, 0),
                new Card(14, 1), new Card(8, 0), new Card(8, 1),
                new Card(10, 0))));
        PokerHand other = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, 0),
                new Card(14, 0), new Card(8, 1), new Card(8, 0),
                new Card(10, 1))));
        String msg = "Start testing two pair vs two pair (tie)";
        int expected = 0;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void pairVsHighCard() {
        PokerHand hand = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, 1),
                new Card(14, 0), new Card(8, 0), new Card(9, 1),
                new Card(10, 0))));
        PokerHand other = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, 1),
                new Card(13, 0), new Card(8, 0), new Card(9, 1),
                new Card(10, 0))));
        String msg = "Start testing pair vs high card";
        int expected = 1;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void pairVsPairHighCard1() {
        PokerHand hand = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, 0),
                new Card(14, 1), new Card(8, 0), new Card(9, 1),
                new Card(11, 0))));
        PokerHand other = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(13, 1),
                new Card(13, 0), new Card(8, 1), new Card(9, 1),
                new Card(10, 0))));
        String msg = "Start testing pair vs pair (first high pair card)";
        int expected = 1;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void pairVsPairHighCard2() {
        PokerHand hand = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, 0),
                new Card(14, 0), new Card(8, 1), new Card(9, 1),
                new Card(11, 1))));
        PokerHand other = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, 0),
                new Card(14, 0), new Card(8, 1), new Card(9, 0),
                new Card(10, 1))));
        String msg = "Start testing pair vs pair (second pair card)";
        int expected = 1;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void pairVsPairHighCard3() {
        PokerHand hand = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, 0),
                new Card(14, 0), new Card(8, 1), new Card(10, 0),
                new Card(11, 1))));
        PokerHand other = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, 1),
                new Card(14, 1), new Card(8, 0), new Card(9, 0),
                new Card(11, 1))));
        String msg = "Start testing pair vs pair (third pair card)";
        int expected = 1;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void pairVsPairHighCard4() {
        PokerHand hand = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, 0),
                new Card(14, 1), new Card(9, 0), new Card(10, 0),
                new Card(11, 1))));
        PokerHand other = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, 0),
                new Card(14, 1), new Card(8, 0), new Card(10, 1),
                new Card(11, 0))));
        String msg = "Start testing pair vs pair (fourth pair card)";
        int expected = 1;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void pairVsPairTie() {
        PokerHand hand = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, 0),
                new Card(14, 1), new Card(9, 1), new Card(10, 0),
                new Card(11, 0))));
        PokerHand other = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, 0),
                new Card(14, 0), new Card(9, 1), new Card(10, 0),
                new Card(11, 1))));
        String msg = "Start testing pair vs pair (tie)";
        int expected = 0;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void highCardVsHighCard1() {
        PokerHand hand = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, 1),
                new Card(13, 0), new Card(12,0), new Card(11, 1),
                new Card(10, 2))));
        PokerHand other = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(13, 1),
                new Card(12, 2), new Card(11, 1), new Card(10, 1),
                new Card(9, 2))));
        String msg = "Start testing high card vs high card (first high card)";
        int expected = 1;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void highCardVsHighCard2() {
        PokerHand hand = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, 0),
                new Card(13, 1), new Card(12, 2), new Card(11, 0),
                new Card(10, 1))));
        PokerHand other = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, 0),
                new Card(12, 1), new Card(11, 2), new Card(10, 0),
                new Card(9, 1))));
        String msg = "Start testing high card vs high card (second high card)";
        int expected = 1;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void highCardVsHighCard3() {
        PokerHand hand = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, 0),
                new Card(13, 1), new Card(12, 2), new Card(11, 0),
                new Card(10, 1))));
        PokerHand other = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, 0),
                new Card(13, 1), new Card(11, 2), new Card(10, 0),
                new Card(9, 1))));
        String msg = "Start testing high card vs high card (third high card)";
        int expected = 1;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void highCardVsHighCard4() {
        PokerHand hand = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14,0),
                new Card(13, 2), new Card(12, 1), new Card(11, 0),
                new Card(10, 2))));
        PokerHand other = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, 0),
                new Card(13, 2), new Card(12, 1), new Card(10, 0),
                new Card(9, 2))));
        String msg = "Start testing high card vs high card (fourth high card)";
        int expected = 1;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void highCardVsHighCard5() {
        PokerHand hand = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, 0),
                new Card(13, 2), new Card(12, 1), new Card(11, 0),
                new Card(10, 2))));
        PokerHand other = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, 0),
                new Card(13, 2), new Card(12, 1), new Card(11, 0),
                new Card(9, 2))));
        String msg = "Start testing high card vs high card (fifth high card)";
        int expected = 1;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void highCardVsHighCardTie() {
        PokerHand hand = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, 0),
                new Card(13, 2), new Card(12, 1), new Card(11, 0),
                new Card(10, 2))));
        PokerHand other = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, 0),
                new Card(13, 2), new Card(12, 1), new Card(11, 0),
                new Card(10, 2))));
        String msg = "Start testing high card vs high card (tie)";
        int expected = 0;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }
}