package pl.sda.exercises;

import org.junit.Test;
import pl.jwrabel.trainings.javasemiadvanced.exercises.Customer;
import pl.jwrabel.trainings.javasemiadvanced.exercises.exceptions.WrongStringFormatException;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * Created by jakubwrabel on 18.01.2017.
 */
public class CustomerTest {

    @Test
    public void constructor_simpleTest() throws WrongStringFormatException {
        // given
        String text = "Adam,Kowalski,1980,123";

        // when
        Customer customer = null;
        customer = new Customer(text);

        // then
        assertEquals("Adam", customer.getFirstName());
        assertEquals("Kowalski", customer.getLastName());
        assertEquals(1980, customer.getBirthYear());
        assertEquals("123", customer.getIdNumber());
    }

    @Test(expected = WrongStringFormatException.class)
    public void constructor_nullCase() throws WrongStringFormatException {
        // given
        String text = null;

        // when
        Customer customer = new Customer(text);
    }

    @Test(expected = WrongStringFormatException.class)
    public void constructor_wrongInput() throws WrongStringFormatException {
        // given
        String text = "ABC";

        // when
        Customer customer = new Customer(text);
    }

    @Test(expected = WrongStringFormatException.class)
    public void constructor_wrongBirthYear() throws WrongStringFormatException {
        // given
        String text = "Adam,Kowalski,ABC,123";
        ;

        // when
        Customer customer = new Customer(text);
    }

    @Test
    public void equals_shouldReturnTrueForEqualCustomers() {
        Customer customer1 = new Customer("Adam", "Kowalski", 1980, "ABC");
        Customer customer2 = new Customer("Adam", "Kowalski", 1980, "ABC");

//        final boolean equals = customer1.equals(customer2);
//
//        assertTrue(equals);

//        assertTrue(customer1.equals(customer2));

        assertEquals(customer1, customer2);
    }

    @Test
    public void equals_shouldReturnTrueForNotEqualCustomers() {
        Customer customer1 = new Customer("Adam", "Kowalski", 1980, "ABC");
        Customer customer2 = new Customer("Adam", "Kowalski", 1980, "CDE");

//        final boolean equals = customer1.equals(customer2);
//
//        assertFalse(equals);

//        assertFalse(customer1.equals(customer2));

        assertNotEquals(customer1, customer2);
    }

    @Test
    public void equals_shouldReturnFalseForNull() {
        Customer customer1 = new Customer("Adam", "Kowalski", 1980, "ABC");


        boolean equals = customer1.equals(null);

        assertFalse(equals);

//        assertNotEquals(customer1, null);
    }

    @Test
    public void equals_shouldReturnFalseForOtherClass() {
        Customer customer1 = new Customer("Adam", "Kowalski", 1980, "ABC");
        Point point = new Point();

        boolean equals = customer1.equals(point);

        assertFalse(equals);
    }

    @Test
    public void equals_nullIdNumber() {
        Customer customer1 = new Customer("Adam", "Kowalski", 1980, "ABC");
        Customer customer2 = new Customer("Adam", "Kowalski", 1980, null);

        boolean equals = customer1.equals(customer2);

        assertFalse(equals);
    }

    @Test
    public void equals_nullIdNumber2() {
        Customer customer1 = new Customer("Adam", "Kowalski", 1980, null);
        Customer customer2 = new Customer("Adam", "Kowalski", 1980, "ABC)");

        boolean equals = customer1.equals(customer2);

        assertFalse(equals);
    }


}