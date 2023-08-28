/**
 * Models a die
 *
 * :author: Chris Hegang Kim
 * :note: I affirm that I have carried out the attached academic
 * endeavors with full academic honesty,
 * in accordance with the Union College Honor Code and the course
 * syllabus.
 */

import java.util.Random;

public class Die {
    private final int MINIMUM_VALUE = 1;
    private final int DEFAULT_SIDES = 6;
    private final int TWICE = 2;

    private int numberOfSides;
    private int currentValue;

    /**
     * Non-default constructor for the die
     * @param numberOfSides int for the number of sides that this die should have
     */
    public Die(int numberOfSides) {
        this.numberOfSides = numberOfSides;
        currentValue = MINIMUM_VALUE;

    }
    /**
     * Default constructor for the die
     */
    public Die(){
        numberOfSides = DEFAULT_SIDES;
        currentValue = MINIMUM_VALUE;
    }

    /**
     * Rolls the die
     */
    public void roll(){
        Random random = new Random();
        currentValue = random.nextInt(numberOfSides) + 1;
    }

    /**
     * Gets the value currently showing on the die
     * @return the value currently showing on the die
     */
    private int getValue(){return currentValue;}

    /**
     * Checks whether one of the dice shows a value that is exactly twice the value of the other
     * @param otherDie a Die object for the other die for comparison
     * @return True if the value of other die is two times larger than the value of current die itself
     */
    public boolean isTwice(Die otherDie){
        if (this.getValue() == otherDie.getValue() * TWICE){
            return true;
        } else {return false;}
    }

    /**
     * Converts to human understandable String
     * @return a human understandable String for the current value of the die
     */
    public String toString(){return this.getValue() + "";}
}