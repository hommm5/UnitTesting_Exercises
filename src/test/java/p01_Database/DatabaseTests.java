package p01_Database;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTests {
    private Database database;
    public static final Integer[] numbers = {1, 2, 3, 4, 5, 6};

    @Before
    public void setDatabase() throws OperationNotSupportedException {
        this.database = new Database(numbers);
    }

    @Test
    public void constructorShouldAcceptOneOrMoreElements() throws OperationNotSupportedException {

        Integer[] elements = this.database.getElements();

        assertEquals(numbers.length, elements.length);

    }

    @Test(expected = OperationNotSupportedException.class)
    public void constructorShouldThrowExceptionWhenMoreThanSixteenIntegersAreReceived() throws OperationNotSupportedException {
        database = new Database(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void constructorShouldThrowExceptionWhenZero() throws OperationNotSupportedException {
        new Database();

    }


    @Test
    public void getElementsShouldReturnAllCorrectElements() throws OperationNotSupportedException {

        Integer[] elements = database.getElements();

        assertArrayEquals(numbers, elements);


    }

    @Test
    public void addShouldAddAnElementAtTheBackOfTheArray() throws OperationNotSupportedException {
        database = new Database(1);

        int numberTOAdd = 2;

        database.add(2);

        Integer[] elements = database.getElements();

        int addedElement  = elements[elements.length - 1];

        assertEquals(numberTOAdd, addedElement);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addShouldThrowExceptionIfElementIsNull() throws OperationNotSupportedException {

        Integer number = null;

        this.database.add(number);
    }

    @Test
    public void removeShouldRemoveTheLastElement() throws OperationNotSupportedException {
        database = new Database(3, 4);

        database.remove();

        Integer [] elements = database.getElements();

        int lastElement = elements[elements.length-1];

        assertEquals(3, lastElement);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void removeShouldThrowExceptionWhenArrayIsEmpty() throws OperationNotSupportedException {
        database = new Database(1);

        database.remove();
        database.remove();
    }

    @Test
    public void removeShouldRemoveTheLastElementInReverseOrder() throws OperationNotSupportedException {
        for (int i = numbers.length - 1; i >= 0; i--) {
            Integer current = numbers[i];
            Integer[] elements = this.database.getElements();
            Integer last = elements[i];
            assertEquals(current, last);
            database.remove();
        }
    }
}
