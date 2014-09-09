package com.realdolmen.course.domain;

import javax.persistence.*;

@Entity
public class Book {
    public static enum Genre {
        BIOGRAPHY, FANTASY, THRILLER
    }

    @Id
    @GeneratedValue
    private Integer id

    @Basic(optional = false)
    private String title;
    private String author;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    /**
     * Used by JPA.
     */
    protected Book() {
    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}
