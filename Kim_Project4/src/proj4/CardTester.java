package proj4;

public class CardTester {

    public static void main(String[] args) {
        CardTester cardTester = new CardTester();

        Testing.startTests();
        cardTester.testStringCardConstructor();
        cardTester.testIntCardConstructor();
        cardTester.testGetRank();
        cardTester.testGetSuit();
        Testing.finishTests();
    }

    private void testStringCardConstructor() {
        stringCardConstructor1();
        stringCardConstructor2();
        stringCardConstructor3();
        invalidStringCardConstructor1();
        invalidStringCardConstructor2();
    }
    private void stringCardConstructor1() {
        Card card = new Card("Two", "clubs");
        String msg = "Starts testing string card constructor1 and toString method";
        String expected = "2 of Clubs";
        String actual = card.toString();

        Testing.assertEquals(msg, expected, actual);
    }

    private void stringCardConstructor2() {
        Card card = new Card("2", "clubs");
        String msg = "Starts testing string card constructor2 and toString method";
        String expected = "2 of Clubs";
        String actual = card.toString();

        Testing.assertEquals(msg, expected, actual);
    }

    private void stringCardConstructor3() {
        Card card = new Card("jack", "clubs");
        String msg = "Starts testing string card constructor3 and toString method";
        String expected = "Jack of Clubs";
        String actual = card.toString();

        Testing.assertEquals(msg, expected, actual);
    }

    private void invalidStringCardConstructor1() {
        Card card = new Card("Invalid String", "clubs");
        String msg = "Starts testing invalid string card constructor1 and toString method";
        String expected = "Ace of Spades";
        String actual = card.toString();

        Testing.assertEquals(msg, expected, actual);
    }

    private void invalidStringCardConstructor2() {
        Card card = new Card("Two", "Invalid String");
        String msg = "Starts testing invalid string card constructor2 and toString method";
        String expected = "Ace of Spades";
        String actual = card.toString();

        Testing.assertEquals(msg, expected, actual);
    }

    private void testIntCardConstructor() {
        intCardConstructor();
        invalidIntCardConstructor1();
        invalidIntCardConstructor2();
    }

    private void intCardConstructor() {
        Card card = new Card(2, 2);
        String msg = "Starts testing int card constructor and toString method";
        String expected = "2 of Clubs";
        String actual = card.toString();

        Testing.assertEquals(msg, expected, actual);
    }

    private void invalidIntCardConstructor1() {
        Card card = new Card(15, 2);
        String msg = "Starts testing invalid int card constructor1 and toString method";
        String expected = "Ace of Spades";
        String actual = card.toString();

        Testing.assertEquals(msg, expected, actual);
    }

    private void invalidIntCardConstructor2() {
        Card card = new Card(2, 4);
        String msg = "Starts testing invalid int card constructor2 and toString method";
        String expected = "Ace of Spades";
        String actual = card.toString();

        Testing.assertEquals(msg, expected, actual);
    }

    private void testGetRank() {
        getRank1();
        getRank2();
    }
    private void getRank1() {
        Card card = new Card(2, 2);
        String msg = "Starts testing getRank1 method";
        int expected = 2;
        int actual = card.getRank();

        Testing.assertEquals(msg, expected, actual);
    }

    private void getRank2() {
        Card card = new Card("two", "Clubs");
        String msg = "Starts testing getRank2 method";
        int expected = 2;
        int actual = card.getRank();

        Testing.assertEquals(msg, expected, actual);
    }

    private void testGetSuit() {
       getSuit1();
       getSuit2();
    }

    private void getSuit1() {
        Card card = new Card(2, 2);
        String msg = "Starts testing getSuit1 method";
        String expected = "Clubs";
        String actual = card.getSuit();

        Testing.assertEquals(msg, expected, actual);
    }

    private void getSuit2() {
        Card card = new Card("two", "Clubs");
        String msg = "Starts testing getSuit2 method";
        String expected = "Clubs";
        String actual = card.getSuit();

        Testing.assertEquals(msg, expected, actual);
    }
}