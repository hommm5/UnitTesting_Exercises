package p02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTests {
    private Person person;
    private Person firstPerson;
    private Person secondPerson;
    private Database database;

    @Before
    public void setDatabase() throws OperationNotSupportedException {
        firstPerson = new Person(1, "Asd");
        secondPerson = new Person(2, "Wqa");
        database = new Database(firstPerson, secondPerson);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addShouldThrowExceptionIfPersonIsNull() throws OperationNotSupportedException {
        person = null;

        database.add(person);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addShouldThrowExceptionIfPersonIdIsNegative() throws OperationNotSupportedException {
        person = new Person(-1, "Dsa");

        database.add(person);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addShouldThrowExceptionIfIdAlreadyExists() throws OperationNotSupportedException {
        person = new Person(2, "Dsa");

        database.add(person);

    }

    @Test
    public void removeShouldRemoveTheLastElementOfTheArray() throws OperationNotSupportedException {
        Person thirdPerson = new Person(3, "Zlo");

        database.add(thirdPerson);

        database.remove();


        Person[] elements = database.getElements();

        Person lastPerson = elements[elements.length - 1];


        Assert.assertEquals(secondPerson, lastPerson);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void removeShouldThrowExceptionWhenDatabaseIsEmpty() throws OperationNotSupportedException {
        database.remove();
        database.remove();
        database.remove();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByUsernameShouldThrowExceptionIfNameDoesNotExist() throws OperationNotSupportedException {
        database.findByUsername("kkk");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByUsernameShouldThrowExceptionIfNameIsNull() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test
    public void findByUsernameShouldReturnPersonWithTheSameUserName() throws OperationNotSupportedException {

        Person asd = database.findByUsername("Asd");

        Assert.assertEquals(asd, firstPerson);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByIdShouldThrowExceptionIfIdDoesNotExist() throws OperationNotSupportedException {
        database.findById(3);
    }

    @Test
    public void findByIdShouldReturnPersonWithSameId() throws OperationNotSupportedException {
        Person byId = database.findById(2);

        Assert.assertEquals(byId, secondPerson);
    }

}
