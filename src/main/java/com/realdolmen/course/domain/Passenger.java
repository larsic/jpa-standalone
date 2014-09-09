package com.realdolmen.course.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;
    private String lastName;

    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @PrePersist
    private void beforePersist() {
        creationDate = new Date();
    }

    public Passenger(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getCreationDate() {
        return creationDate;
    }
}
