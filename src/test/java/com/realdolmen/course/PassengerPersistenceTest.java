package com.realdolmen.course;

import com.realdolmen.course.domain.Book;
import com.realdolmen.course.domain.Passenger;
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

        Passenger Jean = new Passenger(1, "Jean", "Dupuis", "geenidee", 1000, Instant.parse("1987-07-31T00:00:00.00Z"), REGULAR, Instant.parse("1975-03-12T14:15:32.00Z"));
        entityManager().persist(Jean);
        assertNotNull(Jean.getId());

    }
    @Test
    public void passengerCanBeRetrievedById() throws Exception {
        assertEquals("Frank", entityManager().find(Passenger.class, 2).getFirstName());
    }
}
