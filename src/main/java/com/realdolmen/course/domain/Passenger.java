/**
 * Created by brandonstark on 30/06/16.
 */
package com.realdolmen.course.domain;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Entity

public class Passenger {
    @Id
    private Integer id;

    @Column (length =50)
    private String firstName;

    @Column (length=50)
    private String lastName;

    @Column (nullable=false, updatable=false)
    private String ssn;

    private int frequentFlyerMiles;

    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @Transient
    private int age;

    @Column (nullable = false)
    @Enumerated(EnumType.STRING)
    private TypeOfPassenger type;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastFlight;

    public Passenger() {
    }


    public Passenger(Integer id, String firstName, String lastName, String ssn, int frequentFlyerMiles, Instant dateOfBirth, TypeOfPassenger type, Instant lastFlight) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.frequentFlyerMiles = frequentFlyerMiles;
        this.dateOfBirth = Date.from(dateOfBirth);
        this.age = (int)ChronoUnit.YEARS.between(LocalDateTime.ofInstant(dateOfBirth, ZoneId.of("GMT+2")), LocalDateTime.now());
        this.type = type;
        this.lastFlight = Date.from(lastFlight);

    }


    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public TypeOfPassenger getType() {
        return type;
    }

    public void setType(TypeOfPassenger type) {
        this.type = type;
    }

        public Date getLastFlight() {
        return lastFlight;
    }

    public void setLastFlight(Date lastFlight) {
        this.lastFlight = lastFlight;
    }







    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public int getFrequentFlyerMiles() {
        return frequentFlyerMiles;
    }

    public void setFrequentFlyerMiles(int frequentFlyerMiles) {
        this.frequentFlyerMiles = frequentFlyerMiles;
    }
}
