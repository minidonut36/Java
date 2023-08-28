import java.util.ArrayList;

/**
 * List Processor
 *
 * @author Chris Hegang Kim
 * @note I affirm that I have carried out the attached academic endeavors with full academic honesty,
 * in accordance with the Union College Honor Code and the course syllabus.
 */

public class ListProcessor
{
    /**
     * Swaps elements i and j in the given list.
     */
    private void swap(ArrayList<String> aList, int i, int j)
    {
        String tmp = aList.get(i);
        aList.set(i, aList.get(j));
        aList.set(j, tmp);
    }

    /**
     * Finds the minimum element of a list and returns it.
     * Non-destructive (That means this method should not change aList.)
     *
     * @param aList the list in which to find the minimum element.
     * @return the minimum element of the list.
     */
    public String getMin(ArrayList<String> aList) {
        return getMin(aList, 0);
    }


    /**
     * Finds the minimum element of a list from the startingIndex to the end and returns it.
     *
     * @param aList the list in which to find the minimum element.
     * @param startingIndex the integer for the starting index.
     * @return the minimum element of the list.
     */
    private String getMin(ArrayList<String> aList, int startingIndex) {
       if (isEnd(aList, startingIndex)) {
           return aList.get(startingIndex);
       }

       else {
           String restOfTheList = getMin(aList, startingIndex + 1);

           if (aList.get(startingIndex).compareTo(restOfTheList) > 0) {
               return restOfTheList;
           }

           else {
               return aList.get(startingIndex);
           }
       }
    }


    /**
     * Finds the minimum element of a list and returns the index of that
     * element. If there is more than one instance of the minimum, then
     * the lowest index will be returned.  Non-destructive.
     *
     * @param aList the list in which to find the minimum element.
     * @return the index of the minimum element in the list.
     */
    public int getMinIndex(ArrayList<String> aList) {
        return getMinIndex(aList, 0);
    }


    /**
     * Finds the minimum element of a list from the startingIndex to the end
     * and returns the index of that element.
     * If there is more than one instance of the minimum,
     * then the lowest index will be returned.  Non-destructive.
     *
     * @param aList the list in which to find the minimum element.
     * @param startingIndex the integer for the starting index.
     * @return the index of the minimum element in the list.
     */
    private int getMinIndex(ArrayList<String> aList, int startingIndex) {
        if (isEnd(aList, startingIndex)) {
            return startingIndex;
        }

        else {
            if (aList.get(startingIndex).compareTo(getMin(aList, startingIndex + 1)) > 0) {
                return getMinIndex(aList, startingIndex + 1);
            }

            else {
                return startingIndex;
            }
        }
    }


    /**
     * Sorts a list in place. I.E. the list is modified so that it is in order.
     *
     * @param aList: the list to sort.
     */
    public void sort(ArrayList<String> aList) {
        sort(aList, 0);
    }


    /**
     * Sorts a list in place. I.E. the list is modified so that it is in order.
     *
     * @param aList the list in which to find the minimum element.
     * @param startingIndex the integer for the starting index.
     */
    private void sort(ArrayList<String> aList, int startingIndex) {
        if (! isEnd(aList, startingIndex)) {
            int minIndex = getMinIndex(aList, startingIndex);

            swap(aList, minIndex, startingIndex);
            sort(aList, startingIndex + 1);
        }
    }


    /**
     * Checks whether the index is at the end.
     *
     * @param aList the list to check
     * @prarm index the integer for the index
     */
    private boolean isEnd(ArrayList<String> aList, int index) {
        if (index == (aList.size() - 1)) {
            return true;
        }

        else {
            return false;
        }
    }
}