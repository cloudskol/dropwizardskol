package com.cloudskol.dropwizardskol.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by tham on 12-02-2016.
 */
public class Book {
    private String isbn;
    private String title;

    //Expected by Jackson de-serialization
    public Book() {}

    public Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

    @JsonProperty
    public String getIsbn() {
        return isbn;
    }

    @JsonProperty
    public String getTitle() {
        return title;
    }
}
