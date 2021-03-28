package p03_IteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ListIteratorTests {
    private ListIterator listIterator;
    private String elements;
    private String names;

    @Before
    public void setUp() throws OperationNotSupportedException {
        elements = "elements";
        names = "names";
        listIterator = new ListIterator(elements, names);
    }

    @Test
    public void hasNextShouldCheckIfThereIsAnElementOnTheNextIndexAndIfSoReturnTrue (){
        boolean hasNext = listIterator.hasNext();

        Assert.assertTrue(hasNext);
    }

    @Test
    public void hasNextShouldCheckIfThereIsAnElementOnTheNextIndexAndIfNotReturnFalse (){
        boolean hasNext = listIterator.hasNext();

        boolean move = listIterator.move();

        boolean hasNextSecondTime = listIterator.hasNext();

        Assert.assertFalse(hasNextSecondTime);
    }

    @Test
    public void moveShouldIncreaseTheIndexIfPossible (){
        boolean move = listIterator.move();

        Assert.assertTrue(move);
    }

    @Test
    public void moveShouldNotIncreaseTheIndexIfNoMoreElements (){
        boolean move = listIterator.move();
        boolean secondMove = listIterator.move();

        Assert.assertFalse(secondMove);
    }

    @Test
    public void printShouldReturnTheElementOnTheCurrentIndex(){

        listIterator.move();

        String print = listIterator.print();

        Assert.assertEquals(names, print);
    }

    @Test(expected = IllegalStateException.class)
    public void printShouldReturnExceptionWhenCalledOnACollectionWithoutElements() throws OperationNotSupportedException {
        ListIterator iterator = new ListIterator();

        iterator.print();
    }
}
