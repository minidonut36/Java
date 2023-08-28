package proj4;

import java.util.ArrayList;
import java.util.Arrays;

public class StudPokerHandTester {

    private final int MAX_COLLECTION = 5;
    private final int MAX_HAND = 2;

    public static void main(String[] args) {
        StudPokerHandTester studPokerHandTester = new StudPokerHandTester();

        Testing.startTests();
        studPokerHandTester.testStudPokerHandConstructor();
        studPokerHandTester.testAddCard();
        studPokerHandTester.testGetIthCard();
        studPokerHandTester.testCompareTo();
        studPokerHandTester.testGetResult();
        Testing.finishTests();
    }

    private void testStudPokerHandConstructor() {
        Deck deck = new Deck();
        StudPokerHand hand = new StudPokerHand(new CommunityCardSet(deck.dealITimes(MAX_COLLECTION)), deck.dealITimes(MAX_HAND));
        String msg = "Start testing StudPokerHand constructor and toString method";
        String expected = "3 of Hearts\n" + "3 of Clubs\n";
        StudPokerHand actual = hand;

        Testing.assertEquals(msg, expected, actual.toString());
    }

    private void testAddCard() {
        testNotFullHand();
        testFullHand();
    }

    private void testNotFullHand() {
        Deck deck = new Deck();
        StudPokerHand hand = new StudPokerHand(new CommunityCardSet(deck.dealITimes(MAX_COLLECTION)), deck.dealITimes(MAX_HAND - 1));
        String msg = "Start testing addCard method in the full hand";
        String expected = "3 of Hearts\n" + "3 of Clubs\n";
        hand.addCard(deck.deal());
        StudPokerHand actual = hand;

        Testing.assertEquals(msg, expected, actual.toString());
    }

    private void testFullHand() {
        Deck deck = new Deck();
        StudPokerHand hand = new StudPokerHand(new CommunityCardSet(deck.dealITimes(MAX_COLLECTION)), deck.dealITimes(MAX_HAND - 1));
        String msg = "Start testing addCard method in the not full hand";
        String expected = "3 of Hearts\n" + "3 of Clubs\n";;
        hand.addCard(deck.deal());
        StudPokerHand actual = hand;

        Testing.assertEquals(msg, expected, actual.toString());
    }

    private void testGetIthCard() {
        Deck deck = new Deck();
        StudPokerHand hand = new StudPokerHand(new CommunityCardSet(deck.dealITimes(MAX_COLLECTION)), deck.dealITimes(MAX_HAND));
        String msg = "Start testing getIthCard method";
        String expected = "3 of Clubs";
        Card actual = hand.getIthCard(1);

        Testing.assertEquals(msg, expected, actual.toString());
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
        CommunityCardSet cc = new CommunityCardSet(new ArrayList<Card>(Arrays.asList(new Card(14, 1),
                new Card(14, 1), new Card(13, 1), new Card(13, 1),
                new Card(2, 0))));
        StudPokerHand hand = new StudPokerHand(cc, new ArrayList<Card>(Arrays.asList(new Card(12, 1),
                new Card(11, 0))));
        StudPokerHand other = new StudPokerHand(cc, new ArrayList<Card>(Arrays.asList(new Card(12, 0),
                new Card(11, 0))));
        String msg = "Start testing flush vs two pair";
        int expected = 1;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void flushVsFlushHighCard1() {
        CommunityCardSet cc = new CommunityCardSet(new ArrayList<Card>(Arrays.asList(new Card(11, 1),
                new Card(10, 1), new Card(12, 1), new Card(9, 1),
                new Card(2, 0))));
        StudPokerHand hand = new StudPokerHand(cc, new ArrayList<Card>(Arrays.asList(new Card(14, 1),
                new Card(2, 0))));
        StudPokerHand other = new StudPokerHand(cc, new ArrayList<Card>(Arrays.asList(new Card(13, 1),
                new Card(2, 0))));
        String msg = "Start testing flush vs flush (first high card)";
        int expected = 1;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void flushVsFlushHighCard2() {
        CommunityCardSet cc = new CommunityCardSet(new ArrayList<Card>(Arrays.asList(new Card(14, 1),
                new Card(10, 1), new Card(12, 1), new Card(9, 1),
                new Card(2, 0))));
        StudPokerHand hand = new StudPokerHand(cc, new ArrayList<Card>(Arrays.asList(new Card(13, 1),
                new Card(2, 0))));
        StudPokerHand other = new StudPokerHand(cc, new ArrayList<Card>(Arrays.asList(new Card(12, 1),
                new Card(2, 0))));
        String msg = "Start testing flush vs flush (second high card)";
        int expected = 1;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void flushVsFlushHighCard3() {
        CommunityCardSet cc = new CommunityCardSet(new ArrayList<Card>(Arrays.asList(new Card(14, 1),
                new Card(10, 1), new Card(12, 1), new Card(9, 1),
                new Card(2, 0))));
        StudPokerHand hand = new StudPokerHand(cc, new ArrayList<Card>(Arrays.asList(new Card(12, 1),
                new Card(2, 0))));
        StudPokerHand other = new StudPokerHand(cc, new ArrayList<Card>(Arrays.asList(new Card(11, 1),
                new Card(2, 0))));
        String msg = "Start testing flush vs flush (third high card)";
        int expected = 1;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void flushVsFlushHighCard4() {
        CommunityCardSet cc = new CommunityCardSet(new ArrayList<Card>(Arrays.asList(new Card(14, 1),
                new Card(13, 1), new Card(12, 1), new Card(9, 1),
                new Card(2, 0))));
        StudPokerHand hand = new StudPokerHand(cc, new ArrayList<Card>(Arrays.asList(new Card(12, 1),
                new Card(2, 0))));
        StudPokerHand other = new StudPokerHand(cc, new ArrayList<Card>(Arrays.asList(new Card(11, 1),
                new Card(2, 0))));
        String msg = "Start testing flush vs flush (fourth high card)";
        int expected = 1;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void flushVsFlushHighCard5() {
        CommunityCardSet cc = new CommunityCardSet(new ArrayList<Card>(Arrays.asList(new Card(14, 1),
                new Card(13, 1), new Card(12, 1), new Card(11, 1),
                new Card(2, 0))));
        StudPokerHand hand = new StudPokerHand(cc, new ArrayList<Card>(Arrays.asList(new Card(10, 1),
                new Card(2, 0))));
        StudPokerHand other = new StudPokerHand(cc, new ArrayList<Card>(Arrays.asList(new Card(9, 1),
                new Card(2, 0))));
        String msg = "Start testing flush vs flush (fifth high card)";
        int expected = 1;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void flushVsFlushTie() {
        CommunityCardSet cc = new CommunityCardSet(new ArrayList<Card>(Arrays.asList(new Card(14, 1),
                new Card(13, 1), new Card(12, 1), new Card(11, 1),
                new Card(2, 0))));
        StudPokerHand hand = new StudPokerHand(cc, new ArrayList<Card>(Arrays.asList(new Card(10, 1),
                new Card(2, 0))));
        StudPokerHand other = new StudPokerHand(cc, new ArrayList<Card>(Arrays.asList(new Card(10, 1),
                new Card(2, 0))));
        String msg = "Start testing flush vs flush (tie)";
        int expected = 0;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void twoPairVsPair() {
        CommunityCardSet cc = new CommunityCardSet(new ArrayList<Card>(Arrays.asList(new Card(14, 0),
                new Card(13, 1), new Card(12, 2), new Card(12, 1),
                new Card(2, 0))));
        StudPokerHand hand = new StudPokerHand(cc, new ArrayList<Card>(Arrays.asList(new Card(14, 1),
                new Card(3, 0))));
        StudPokerHand other = new StudPokerHand(cc, new ArrayList<Card>(Arrays.asList(new Card(10, 1),
                new Card(3, 0))));
        String msg = "Start testing two pair vs pair";
        int expected = 1;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void twoPairVsTwoPairHighCard1() {
        CommunityCardSet cc = new CommunityCardSet(new ArrayList<Card>(Arrays.asList(new Card(14, 0),
                new Card(13, 1), new Card(12, 2), new Card(12, 1),
                new Card(2, 0))));
        StudPokerHand hand = new StudPokerHand(cc, new ArrayList<Card>(Arrays.asList(new Card(14, 1),
                new Card(3, 0))));
        StudPokerHand other = new StudPokerHand(cc, new ArrayList<Card>(Arrays.asList(new Card(13, 1),
                new Card(3, 0))));
        String msg = "Start testing two pair vs two pair (first high card)";
        int expected = 1;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void twoPairVsTwoPairHighCard2() {
        CommunityCardSet cc = new CommunityCardSet(new ArrayList<Card>(Arrays.asList(new Card(14, 0),
                new Card(14, 1), new Card(13, 2), new Card(12, 1),
                new Card(2, 0))));
        StudPokerHand hand = new StudPokerHand(cc, new ArrayList<Card>(Arrays.asList(new Card(13, 1),
                new Card(3, 0))));
        StudPokerHand other = new StudPokerHand(cc, new ArrayList<Card>(Arrays.asList(new Card(12, 1),
                new Card(3, 0))));
        String msg = "Start testing two pair vs two pair (second high card)";
        int expected = 1;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void twoPairVsTwoPairHighCard3() {
        CommunityCardSet cc = new CommunityCardSet(new ArrayList<Card>(Arrays.asList(new Card(14, 0),
                new Card(14, 1), new Card(13, 2), new Card(3, 0),
                new Card(2, 0))));
        StudPokerHand hand = new StudPokerHand(cc, new ArrayList<Card>(Arrays.asList(new Card(13, 1),
                new Card(10, 0))));
        StudPokerHand other = new StudPokerHand(cc, new ArrayList<Card>(Arrays.asList(new Card(13, 1),
                new Card(9, 0))));
        String msg = "Start testing two pair vs two pair (third high card)";
        int expected = 1;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void twoPairVsTwoPairTie() {
        CommunityCardSet cc = new CommunityCardSet(new ArrayList<Card>(Arrays.asList(new Card(14, 0),
                new Card(14, 1), new Card(13, 2), new Card(12, 1),
                new Card(2, 0))));
        StudPokerHand hand = new StudPokerHand(cc, new ArrayList<Card>(Arrays.asList(new Card(13, 1),
                new Card(4, 0))));
        StudPokerHand other = new StudPokerHand(cc, new ArrayList<Card>(Arrays.asList(new Card(13, 1),
                new Card(4, 0))));
        String msg = "Start testing two pair vs two pair (tie)";
        int expected = 0;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void pairVsHighCard() {
        CommunityCardSet cc = new CommunityCardSet(new ArrayList<Card>(Arrays.asList(new Card(14, 0),
                new Card(13, 1), new Card(12, 2), new Card(11, 1),
                new Card(2, 0))));
        StudPokerHand hand = new StudPokerHand(cc, new ArrayList<Card>(Arrays.asList(new Card(14, 1),
                new Card(9, 0))));
        StudPokerHand other = new StudPokerHand(cc, new ArrayList<Card>(Arrays.asList(new Card(10, 1),
                new Card(9, 0))));
        String msg = "Start testing pair vs high card";
        int expected = 1;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void pairVsPairHighCard1() {
        CommunityCardSet cc = new CommunityCardSet(new ArrayList<Card>(Arrays.asList(new Card(14, 0),
                new Card(13, 1), new Card(12, 2), new Card(11, 1),
                new Card(2, 0))));
        StudPokerHand hand = new StudPokerHand(cc, new ArrayList<Card>(Arrays.asList(new Card(14, 1),
                new Card(9, 0))));
        StudPokerHand other = new StudPokerHand(cc, new ArrayList<Card>(Arrays.asList(new Card(13, 1),
                new Card(9, 0))));
        String msg = "Start testing pair vs pair (first high card)";
        int expected = 1;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void pairVsPairHighCard2() {
        CommunityCardSet cc = new CommunityCardSet(new ArrayList<Card>(Arrays.asList(new Card(10, 0),
                new Card(5, 1), new Card(4, 2), new Card(3, 1),
                new Card(2, 0))));
        StudPokerHand hand = new StudPokerHand(cc, new ArrayList<Card>(Arrays.asList(new Card(10, 1),
                new Card(9, 0))));
        StudPokerHand other = new StudPokerHand(cc, new ArrayList<Card>(Arrays.asList(new Card(10, 1),
                new Card(8, 0))));
        String msg = "Start testing pair vs pair (second high card)";
        int expected = 1;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void pairVsPairHighCard3() {
        CommunityCardSet cc = new CommunityCardSet(new ArrayList<Card>(Arrays.asList(new Card(10, 0),
                new Card(9, 1), new Card(5, 2), new Card(4, 1),
                new Card(2, 0))));
        StudPokerHand hand = new StudPokerHand(cc, new ArrayList<Card>(Arrays.asList(new Card(10, 1),
                new Card(8, 0))));
        StudPokerHand other = new StudPokerHand(cc, new ArrayList<Card>(Arrays.asList(new Card(10, 1),
                new Card(7, 0))));
        String msg = "Start testing pair vs pair (third high card)";
        int expected = 1;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void pairVsPairHighCard4() {
        CommunityCardSet cc = new CommunityCardSet(new ArrayList<Card>(Arrays.asList(new Card(10, 0),
                new Card(9, 1), new Card(7, 2), new Card(3, 1),
                new Card(2, 0))));
        StudPokerHand hand = new StudPokerHand(cc, new ArrayList<Card>(Arrays.asList(new Card(10, 1),
                new Card(5, 0))));
        StudPokerHand other = new StudPokerHand(cc, new ArrayList<Card>(Arrays.asList(new Card(10, 1),
                new Card(4, 0))));
        String msg = "Start testing pair vs pair (fourth high card)";
        int expected = 1;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void pairVsPairTie() {
        CommunityCardSet cc = new CommunityCardSet(new ArrayList<Card>(Arrays.asList(new Card(10, 0),
                new Card(9, 1), new Card(7, 2), new Card(5, 1),
                new Card(2, 0))));
        StudPokerHand hand = new StudPokerHand(cc, new ArrayList<Card>(Arrays.asList(new Card(10, 1),
                new Card(5, 0))));
        StudPokerHand other = new StudPokerHand(cc, new ArrayList<Card>(Arrays.asList(new Card(10, 1),
                new Card(5, 0))));
        String msg = "Start testing pair vs pair (tie)";
        int expected = 0;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void highCardVsHighCard1() {
        CommunityCardSet cc = new CommunityCardSet(new ArrayList<Card>(Arrays.asList(new Card(12, 0),
                new Card(10, 1), new Card(8, 2), new Card(6, 1),
                new Card(2, 0))));
        StudPokerHand hand = new StudPokerHand(cc, new ArrayList<Card>(Arrays.asList(new Card(14, 1),
                new Card(3, 0))));
        StudPokerHand other = new StudPokerHand(cc, new ArrayList<Card>(Arrays.asList(new Card(13, 1),
                new Card(3, 0))));
        String msg = "Start testing high card vs high card (first high card)";
        int expected = 1;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void highCardVsHighCard2() {
        CommunityCardSet cc = new CommunityCardSet(new ArrayList<Card>(Arrays.asList(new Card(12, 0),
                new Card(10, 1), new Card(8, 2), new Card(6, 1),
                new Card(2, 0))));
        StudPokerHand hand = new StudPokerHand(cc, new ArrayList<Card>(Arrays.asList(new Card(11, 1),
                new Card(3, 0))));
        StudPokerHand other = new StudPokerHand(cc, new ArrayList<Card>(Arrays.asList(new Card(9, 1),
                new Card(3, 0))));
        String msg = "Start testing high card vs high card (second high card)";
        int expected = 1;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void highCardVsHighCard3() {
        CommunityCardSet cc = new CommunityCardSet(new ArrayList<Card>(Arrays.asList(new Card(12, 0),
                new Card(10, 1), new Card(8, 2), new Card(6, 1),
                new Card(2, 0))));
        StudPokerHand hand = new StudPokerHand(cc, new ArrayList<Card>(Arrays.asList(new Card(9, 1),
                new Card(3, 0))));
        StudPokerHand other = new StudPokerHand(cc, new ArrayList<Card>(Arrays.asList(new Card(7, 1),
                new Card(3, 0))));
        String msg = "Start testing high card vs high card (third high card)";
        int expected = 1;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void highCardVsHighCard4() {
        CommunityCardSet cc = new CommunityCardSet(new ArrayList<Card>(Arrays.asList(new Card(12, 0),
                new Card(10, 1), new Card(8, 2), new Card(6, 1),
                new Card(2, 0))));
        StudPokerHand hand = new StudPokerHand(cc, new ArrayList<Card>(Arrays.asList(new Card(7, 1),
                new Card(3, 0))));
        StudPokerHand other = new StudPokerHand(cc, new ArrayList<Card>(Arrays.asList(new Card(5, 1),
                new Card(3, 0))));
        String msg = "Start testing high card vs high card (fourth high card)";
        int expected = 1;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void highCardVsHighCard5() {
        CommunityCardSet cc = new CommunityCardSet(new ArrayList<Card>(Arrays.asList(new Card(12, 0),
                new Card(10, 1), new Card(8, 2), new Card(6, 1),
                new Card(2, 0))));
        StudPokerHand hand = new StudPokerHand(cc, new ArrayList<Card>(Arrays.asList(new Card(5, 1),
                new Card(3, 0))));
        StudPokerHand other = new StudPokerHand(cc, new ArrayList<Card>(Arrays.asList(new Card(4, 1),
                new Card(3, 0))));
        String msg = "Start testing high card vs high card (fifth high card)";
        int expected = 1;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void highCardVsHighCardTie() {
        CommunityCardSet cc = new CommunityCardSet(new ArrayList<Card>(Arrays.asList(new Card(12, 0),
                new Card(10, 1), new Card(8, 2), new Card(6, 1),
                new Card(2, 0))));
        StudPokerHand hand = new StudPokerHand(cc, new ArrayList<Card>(Arrays.asList(new Card(5, 1),
                new Card(3, 0))));
        StudPokerHand other = new StudPokerHand(cc, new ArrayList<Card>(Arrays.asList(new Card(5, 1),
                new Card(3, 0))));
        String msg = "Start testing high card vs high card (tie)";
        int expected = 0;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void testGetResult() {
        testHandWinResult();
        testOtherWinResult();
        testTieResult();
    }

    private void testHandWinResult() {
        CommunityCardSet cc = new CommunityCardSet(new ArrayList<Card>(Arrays.asList(new Card(12, 0),
                new Card(10, 1), new Card(8, 2), new Card(6, 1),
                new Card(2, 0))));
        StudPokerHand hand = new StudPokerHand(cc, new ArrayList<Card>(Arrays.asList(new Card(14, 1),
                new Card(3, 0))));
        StudPokerHand other = new StudPokerHand(cc, new ArrayList<Card>(Arrays.asList(new Card(13, 1),
                new Card(3, 0))));
        String msg = "Start testing hand winning scenario";
        String expected = "my hand";
        String actual = hand.getResult(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void testOtherWinResult() {
        CommunityCardSet cc = new CommunityCardSet(new ArrayList<Card>(Arrays.asList(new Card(12, 0),
                new Card(10, 1), new Card(8, 2), new Card(6, 1),
                new Card(2, 0))));
        StudPokerHand hand = new StudPokerHand(cc, new ArrayList<Card>(Arrays.asList(new Card(13, 1),
                new Card(3, 0))));
        StudPokerHand other = new StudPokerHand(cc, new ArrayList<Card>(Arrays.asList(new Card(14, 1),
                new Card(3, 0))));
        String msg = "Start testing other winning scenario";
        String expected = "other hand";
        String actual = hand.getResult(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void testTieResult() {
        CommunityCardSet cc = new CommunityCardSet(new ArrayList<Card>(Arrays.asList(new Card(12, 0),
                new Card(10, 1), new Card(8, 2), new Card(6, 1),
                new Card(2, 0))));
        StudPokerHand hand = new StudPokerHand(cc, new ArrayList<Card>(Arrays.asList(new Card(14, 1),
                new Card(3, 0))));
        StudPokerHand other = new StudPokerHand(cc, new ArrayList<Card>(Arrays.asList(new Card(14, 1),
                new Card(3, 0))));
        String msg = "Start testing other winning scenario";
        String expected = "tie";
        String actual = hand.getResult(other);

        Testing.assertEquals(msg, expected, actual);
    }
}