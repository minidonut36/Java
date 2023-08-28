/**
 * @author Chris Hegang Kim
 * @note I affirm that I have carried out the attached academic endeavors with full academic honesty,
 * in accordance with the Union College Honor Code and the course syllabus.
 */

package proj3;

import java.util.ArrayList;
import java.util.Arrays;

public class PokerComparisionTests {

    public static void main(String[] args) {
        PokerComparisionTests handTester = new PokerComparisionTests();

        Testing.startTests();
        handTester.testCompareTo();
        Testing.finishTests();
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
        PokerHand hand = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, "Hearts"),
                new Card(14, "Hearts"), new Card(8, "Hearts"), new Card(7, "Hearts"),
                new Card(10, "Hearts"))));
        PokerHand other = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, "Hearts"),
                new Card(14, "Diamonds"), new Card(8, "Spades"), new Card(8, "Clubs"),
                new Card(9, "Hearts"))));
        String msg = "Start testing flush vs two pair";
        int expected = 1;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void flushVsFlushHighCard1() {
        PokerHand hand = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, "Hearts"),
                new Card(13, "Hearts"), new Card(12, "Hearts"), new Card(11, "Hearts"),
                new Card(10, "Hearts"))));
        PokerHand other = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(9, "Hearts"),
                new Card(13, "Hearts"), new Card(12, "Hearts"), new Card(11, "Hearts"),
                new Card(10, "Hearts"))));
        String msg = "Start testing flush vs flush (first high card)";
        int expected = 1;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void flushVsFlushHighCard2() {
        PokerHand hand = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, "Hearts"),
                new Card(13, "Hearts"), new Card(12, "Hearts"), new Card(11, "Hearts"),
                new Card(10, "Hearts"))));
        PokerHand other = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(9, "Hearts"),
                new Card(14, "Hearts"), new Card(12, "Hearts"), new Card(11, "Hearts"),
                new Card(10, "Hearts"))));
        String msg = "Start testing flush vs flush (second high card)";
        int expected = 1;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void flushVsFlushHighCard3() {
        PokerHand hand = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, "Hearts"),
                new Card(13, "Hearts"), new Card(12, "Hearts"), new Card(11, "Hearts"),
                new Card(10, "Hearts"))));
        PokerHand other = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(9, "Hearts"),
                new Card(14, "Hearts"), new Card(13, "Hearts"), new Card(11, "Hearts"),
                new Card(10, "Hearts"))));
        String msg = "Start testing flush vs flush (third high card)";
        int expected = 1;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void flushVsFlushHighCard4() {
        PokerHand hand = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, "Hearts"),
                new Card(13, "Hearts"), new Card(12, "Hearts"), new Card(11, "Hearts"),
                new Card(10, "Hearts"))));
        PokerHand other = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(9, "Hearts"),
                new Card(14, "Hearts"), new Card(13, "Hearts"), new Card(12, "Hearts"),
                new Card(10, "Hearts"))));
        String msg = "Start testing flush vs flush (fourth high card)";
        int expected = 1;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void flushVsFlushHighCard5() {
        PokerHand hand = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, "Hearts"),
                new Card(13, "Hearts"), new Card(12, "Hearts"), new Card(11, "Hearts"),
                new Card(10, "Hearts"))));
        PokerHand other = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(9, "Hearts"),
                new Card(14, "Hearts"), new Card(13, "Hearts"), new Card(12, "Hearts"),
                new Card(11, "Hearts"))));
        String msg = "Start testing flush vs flush (fifth high card)";
        int expected = 1;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void flushVsFlushTie() {
        PokerHand hand = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, "Hearts"),
                new Card(13, "Hearts"), new Card(12, "Hearts"), new Card(11, "Hearts"),
                new Card(10, "Hearts"))));
        PokerHand other = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(10, "Hearts"),
                new Card(14, "Hearts"), new Card(13, "Hearts"), new Card(12, "Hearts"),
                new Card(11, "Hearts"))));
        String msg = "Start testing flush vs flush (tie)";
        int expected = 0;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void twoPairVsPair() {
        PokerHand hand = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, "Hearts"),
                new Card(14, "Diamonds"), new Card(8, "Spades"), new Card(8, "Clubs"),
                new Card(10, "Hearts"))));
        PokerHand other = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, "Hearts"),
                new Card(14, "Diamonds"), new Card(8, "Spades"), new Card(9, "Clubs"),
                new Card(10, "Hearts"))));
        String msg = "Start testing two pair vs pair";
        int expected = 1;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void twoPairVsTwoPairHighCard1() {
        PokerHand hand = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, "Hearts"),
                new Card(14, "Diamonds"), new Card(8, "Hearts"), new Card(8, "Hearts"),
                new Card(9, "Hearts"))));
        PokerHand other = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(13, "Hearts"),
                new Card(13, "Diamonds"), new Card(11, "Hearts"), new Card(11, "Hearts"),
                new Card(9, "Hearts"))));
        String msg = "Start testing two pair vs two pair (first high pair card)";
        int expected = 1;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void twoPairVsTwoPairHighCard2() {
        PokerHand hand = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, "Hearts"),
                new Card(14, "Diamonds"), new Card(8, "Hearts"), new Card(8, "Hearts"),
                new Card(9, "Hearts"))));
        PokerHand other = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, "Hearts"),
                new Card(14, "Diamonds"), new Card(7, "Hearts"), new Card(7, "Hearts"),
                new Card(9, "Hearts"))));
        String msg = "Start testing two pair vs two pair (second high pair card)";
        int expected = 1;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void twoPairVsTwoPairHighCard3() {
        PokerHand hand = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, "Hearts"),
                new Card(14, "Diamonds"), new Card(8, "Hearts"), new Card(8, "Hearts"),
                new Card(10, "Hearts"))));
        PokerHand other = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, "Hearts"),
                new Card(14, "Diamonds"), new Card(8, "Hearts"), new Card(8, "Hearts"),
                new Card(9, "Hearts"))));
        String msg = "Start testing two pair vs two pair (third high card)";
        int expected = 1;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void twoPairVsTwoPairTie() {
        PokerHand hand = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, "Hearts"),
                new Card(14, "Diamonds"), new Card(8, "Hearts"), new Card(8, "Hearts"),
                new Card(10, "Hearts"))));
        PokerHand other = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, "Hearts"),
                new Card(14, "Diamonds"), new Card(8, "Hearts"), new Card(8, "Hearts"),
                new Card(10, "Hearts"))));
        String msg = "Start testing two pair vs two pair (tie)";
        int expected = 0;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void pairVsHighCard() {
        PokerHand hand = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, "Hearts"),
                new Card(14, "Diamonds"), new Card(8, "Hearts"), new Card(9, "Hearts"),
                new Card(10, "Hearts"))));
        PokerHand other = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, "Hearts"),
                new Card(13, "Diamonds"), new Card(8, "Hearts"), new Card(9, "Hearts"),
                new Card(10, "Hearts"))));
        String msg = "Start testing pair vs high card";
        int expected = 1;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void pairVsPairHighCard1() {
        PokerHand hand = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, "Hearts"),
                new Card(14, "Diamonds"), new Card(8, "Hearts"), new Card(9, "Hearts"),
                new Card(11, "Hearts"))));
        PokerHand other = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(13, "Hearts"),
                new Card(13, "Diamonds"), new Card(8, "Hearts"), new Card(9, "Hearts"),
                new Card(10, "Hearts"))));
        String msg = "Start testing pair vs pair (first high pair card)";
        int expected = 1;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void pairVsPairHighCard2() {
        PokerHand hand = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, "Hearts"),
                new Card(14, "Diamonds"), new Card(8, "Hearts"), new Card(9, "Hearts"),
                new Card(11, "Hearts"))));
        PokerHand other = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, "Hearts"),
                new Card(14, "Diamonds"), new Card(8, "Hearts"), new Card(9, "Hearts"),
                new Card(10, "Hearts"))));
        String msg = "Start testing pair vs pair (second pair card)";
        int expected = 1;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void pairVsPairHighCard3() {
        PokerHand hand = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, "Hearts"),
                new Card(14, "Diamonds"), new Card(8, "Hearts"), new Card(10, "Hearts"),
                new Card(11, "Hearts"))));
        PokerHand other = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, "Hearts"),
                new Card(14, "Diamonds"), new Card(8, "Hearts"), new Card(9, "Hearts"),
                new Card(11, "Hearts"))));
        String msg = "Start testing pair vs pair (third pair card)";
        int expected = 1;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void pairVsPairHighCard4() {
        PokerHand hand = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, "Hearts"),
                new Card(14, "Diamonds"), new Card(9, "Hearts"), new Card(10, "Hearts"),
                new Card(11, "Hearts"))));
        PokerHand other = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, "Hearts"),
                new Card(14, "Diamonds"), new Card(8, "Hearts"), new Card(10, "Hearts"),
                new Card(11, "Hearts"))));
        String msg = "Start testing pair vs pair (fourth pair card)";
        int expected = 1;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void pairVsPairTie() {
        PokerHand hand = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, "Hearts"),
                new Card(14, "Diamonds"), new Card(9, "Hearts"), new Card(10, "Hearts"),
                new Card(11, "Hearts"))));
        PokerHand other = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, "Hearts"),
                new Card(14, "Diamonds"), new Card(9, "Hearts"), new Card(10, "Hearts"),
                new Card(11, "Hearts"))));
        String msg = "Start testing pair vs pair (tie)";
        int expected = 0;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void highCardVsHighCard1() {
        PokerHand hand = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, "Hearts"),
                new Card(13, "Diamonds"), new Card(12, "Hearts"), new Card(11, "Hearts"),
                new Card(10, "Hearts"))));
        PokerHand other = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(13, "Hearts"),
                new Card(12, "Diamonds"), new Card(11, "Hearts"), new Card(10, "Hearts"),
                new Card(9, "Hearts"))));
        String msg = "Start testing high card vs high card (first high card)";
        int expected = 1;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void highCardVsHighCard2() {
        PokerHand hand = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, "Hearts"),
                new Card(13, "Diamonds"), new Card(12, "Hearts"), new Card(11, "Hearts"),
                new Card(10, "Hearts"))));
        PokerHand other = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, "Hearts"),
                new Card(12, "Diamonds"), new Card(11, "Hearts"), new Card(10, "Hearts"),
                new Card(9, "Hearts"))));
        String msg = "Start testing high card vs high card (second high card)";
        int expected = 1;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void highCardVsHighCard3() {
        PokerHand hand = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, "Hearts"),
                new Card(13, "Diamonds"), new Card(12, "Hearts"), new Card(11, "Hearts"),
                new Card(10, "Hearts"))));
        PokerHand other = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, "Hearts"),
                new Card(13, "Diamonds"), new Card(11, "Hearts"), new Card(10, "Hearts"),
                new Card(9, "Hearts"))));
        String msg = "Start testing high card vs high card (third high card)";
        int expected = 1;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void highCardVsHighCard4() {
        PokerHand hand = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, "Hearts"),
                new Card(13, "Diamonds"), new Card(12, "Hearts"), new Card(11, "Hearts"),
                new Card(10, "Hearts"))));
        PokerHand other = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, "Hearts"),
                new Card(13, "Diamonds"), new Card(12, "Hearts"), new Card(10, "Hearts"),
                new Card(9, "Hearts"))));
        String msg = "Start testing high card vs high card (fourth high card)";
        int expected = 1;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void highCardVsHighCard5() {
        PokerHand hand = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, "Hearts"),
                new Card(13, "Diamonds"), new Card(12, "Hearts"), new Card(11, "Hearts"),
                new Card(10, "Hearts"))));
        PokerHand other = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, "Hearts"),
                new Card(13, "Diamonds"), new Card(12, "Hearts"), new Card(11, "Hearts"),
                new Card(9, "Hearts"))));
        String msg = "Start testing high card vs high card (fifth high card)";
        int expected = 1;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }

    private void highCardVsHighCardTie() {
        PokerHand hand = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, "Hearts"),
                new Card(13, "Diamonds"), new Card(12, "Hearts"), new Card(11, "Hearts"),
                new Card(10, "Hearts"))));
        PokerHand other = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, "Hearts"),
                new Card(13, "Diamonds"), new Card(12, "Hearts"), new Card(11, "Hearts"),
                new Card(10, "Hearts"))));
        String msg = "Start testing high card vs high card (tie)";
        int expected = 0;
        int actual = hand.compareTo(other);

        Testing.assertEquals(msg, expected, actual);
    }
}