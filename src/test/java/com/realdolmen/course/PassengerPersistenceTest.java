package com.realdolmen.course;

import com.realdolmen.course.domain.Book;
import com.realdolmen.course.domain.Passenger;
import org.junit.Ignore;
import org.junit.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import static com.realdolmen.course.domain.TypeOfPassenger.REGULAR;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by brandonstark on 30/06/16.
 */
public class PassengerPersistenceTest extends DataSetPersistenceTest{
    @Test
    public void passengercanbepersisted() throws Exception {

        Passenger Jean = new Passenger(1, "Jean", "Dupuis", "geenidee", 1000, LocalDate.of(2001,10,18), REGULAR, LocalDateTime.of(1990,11,30,5,5,5));
        entityManager().persist(Jean);
        assertNotNull(Jean.getId());

    }
    @Test
    public void passengerCanBeRetrievedById() throws Exception {
        assertEquals("Frank", entityManager().find(Passenger.class, 2).getFirstName());
    }

    @Test
    public void getLocalYear() throws Exception {
        assertEquals(2016, LocalDate.now().getYear());
    }

    @Test
    public void getYearFromBirthday() throws Exception {
        assertEquals(2001, entityManager().find(Passenger.class, 2).getDateOfBirth().getYear());
    }


    @Test
    public void ageCanBeCreatedFromDates() throws Exception {
        assertEquals(15, entityManager().find(Passenger.class, 2).getAge());
    }
    @Test
    public void passengerCanStoreEmails() throws Exception {
        Passenger passenger = new Passenger(1, "Jean", "Dupuis", "geenidee", 1000, LocalDate.of(2001,10,18), REGULAR, LocalDateTime.of(1990,11,30,5,5,5));
        passenger.addEmail("john.doe@gmail.com");
        passenger.addEmail("jdoe@hotmail.com");
        entityManager().persist(passenger);
    }
}
