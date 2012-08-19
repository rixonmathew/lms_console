package com.rixon.lms_console.domain;

import java.util.Date;

/**
 * This class represents the book entity
 * User: 229921|Date: 8/17/12|Time: 6:01 PM
 */
public class Book {
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private Date releaseDate;

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
