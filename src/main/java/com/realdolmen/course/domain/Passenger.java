/**
 * Created by brandonstark on 30/06/16.
 */
package com.realdolmen.course.domain;

import org.hibernate.annotations.CollectionId;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.time.temporal.ChronoUnit.YEARS;

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


    private LocalDate dateOfBirth;

    @Transient
    private int age;

    @Column (nullable = false)
    @Enumerated(EnumType.STRING)
    private TypeOfPassenger type;


    private LocalDateTime lastFlight;

    @ElementCollection
    @CollectionTable(name = "passenger_emails", joinColumns = @JoinColumn(name="p_id"))
    @Column(name= "email")


    List<String> emails =  new ArrayList<>();

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public void addEmail(String newEmail){
        if (newEmail ==null || newEmail.trim().length()==0){
            throw new IllegalArgumentException("fout");
        }
        emails.add(newEmail);

    }

    public Passenger() {
    }


    public Passenger(Integer id, String firstName, String lastName, String ssn, int frequentFlyerMiles, LocalDate dateOfBirth, TypeOfPassenger type, LocalDateTime lastFlight) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.frequentFlyerMiles = frequentFlyerMiles;
        this.dateOfBirth = dateOfBirth;
        this.type = type;
        this.lastFlight = lastFlight;
        this.age = getAge();

    }


    public LocalDate getDateOfBirth(){  return dateOfBirth;


    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        int a = (LocalDate.now().getYear());
        int b = this.dateOfBirth.getYear();
        return a-b;
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

    public LocalDateTime getLastFlight() {
        return lastFlight;
    }

    public void setLastFlight(LocalDateTime lastFlight) {
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
