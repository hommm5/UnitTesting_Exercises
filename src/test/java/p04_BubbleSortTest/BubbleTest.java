package p04_BubbleSortTest;

import org.junit.Assert;
import org.junit.Test;

public class BubbleTest {

    @Test
    public void bubbleSortAlgorithmSortsAnArray() {
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8};

        int[] unSortedArray = {7, 6, 8, 3, 5, 4, 2, 1};

        Bubble.sort(unSortedArray);

        Assert.assertArrayEquals(sortedArray, unSortedArray);
    }

}