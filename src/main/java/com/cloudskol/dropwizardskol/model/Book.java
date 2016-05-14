package com.cloudskol.dropwizardskol.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by tham on 12-02-2016.
 */
public class Book {
    private String id;
    private String isbn;
    private String title;

    //Expected by Jackson de-serialization
    public Book() {}

    public Book(String id, String isbn, String title) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
    }

    @JsonProperty
    public String getId() {
        return id;
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
