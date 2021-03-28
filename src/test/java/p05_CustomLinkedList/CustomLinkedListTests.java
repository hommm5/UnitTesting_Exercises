package p05_CustomLinkedList;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomLinkedListTests {
    private CustomLinkedList<String> list;

    private static final String NOTE = "name";
    private static final String NOTE_TEST = "test";

    @Before
    public void setUp() {
        this.list = new CustomLinkedList<>();

        this.list.add(NOTE);
    }


    @Test
    public void addShouldIncludeAElementAtTheLastIndex() {

        this.list.add(NOTE_TEST);

        assertEquals(NOTE_TEST, this.list.get(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getShouldReturnExceptionIfCountIsEqualToIndex() {

        this.list.get(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getShouldReturnExceptionIfCountIsLessThanIndex() {

        this.list.get(3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getShouldReturnExceptionIfIndexIsNegative() {

        this.list.get(-1);
    }

    @Test
    public void containsShouldReturnTrueIfElementIsPresent() {
        assertTrue(this.list.contains(NOTE));
    }

    @Test
    public void containsShouldReturnFalseIfElementIsNotPresent() {
        assertFalse(this.list.contains(NOTE_TEST));
    }

    @Test
    public void indexOfShouldReturnIndexOfTheFoundItem() {

        this.list.add(NOTE_TEST);

        int index = this.list.indexOf(NOTE_TEST);

        assertEquals(1, index);
    }

    @Test
    public void indexOfShouldReturnMinusOneIfItemIsNotFound() {

        int index = this.list.indexOf(NOTE_TEST);

        assertEquals(-1, index);
    }

    @Test
    public void removeShouldRemoveTheElementAndReturnItsIndex() {

        this.list.add(NOTE_TEST);

        int index = this.list.remove(NOTE_TEST);

        assertEquals(1, index);
    }

    @Test
    public void removeShouldNotRemoveTheElementIfTheElementDoesNotExistANdShouldReturnMinusOne() {

        int index = this.list.remove(NOTE_TEST);

        assertEquals(-1, index);
    }

    @Test
    public void removeAtShouldRemoveElementOnIndexAndReturnThatElement() {

        this.list.add(NOTE_TEST);

        String element = this.list.removeAt(1);

        assertEquals(NOTE_TEST, element);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeAtShouldThrowExceptionIfIndexIsMoreOrEqualToCount() {

        this.list.add(NOTE_TEST);

        String element = this.list.removeAt(2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeAtShouldThrowExceptionIfIndexIsNegative() {

        this.list.add(NOTE_TEST);

        String element = this.list.removeAt(-1);
    }

    @Test
    public void setShouldAddAnElementOnlyOnTheFirstIndex(){
        this.list.set(0, NOTE_TEST);

        assertEquals(NOTE_TEST, this.list.get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void setShouldThrowExceptionIfIndexIsEqualTGreater(){
        this.list.set(1, NOTE_TEST);

    }

    @Test(expected = IllegalArgumentException.class)
    public void setShouldThrowExceptionIfIndexIsNegative(){
        this.list.set(-1, NOTE_TEST);

    }
}
