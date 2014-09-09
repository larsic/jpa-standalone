package com.realdolmen.course;

import com.realdolmen.course.domain.Passenger;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class PassengerTest extends PersistenceTest {
    @Test
    public void passengerCanBePersisted() throws Exception {
        Passenger passenger = new Passenger("Jimi", "Hendrix");
        entityManager().persist(passenger);
        assertNotNull(passenger.getId());
    }

    @Test
    public void passengerCreationDateIsSetCorrectlyUponPersist() throws Exception {
        Passenger passenger = new Passenger("Janis", "Joplin");
        assertNull(passenger.getCreationDate());
        entityManager().persist(passenger);
        assertNotNull(passenger.getCreationDate());
    }
}
