package com.rixon.lms_console.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * This class represents the book entity
 * User: rixon|Date: 8/17/12|Time: 6:01 PM
 */
@Entity
@Table(name = "BOOK")
@NamedQuery(name=Book.ALL_BOOKS_QUERY, query="select book from Book book")
public class Book {
    @Id
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    @Temporal(TemporalType.DATE)
    private Date releaseDate;
    public static final String ALL_BOOKS_QUERY = "all_books_query";

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

}
