package com.cloudskol.dropwizardskol.resource;

import com.cloudskol.dropwizardskol.model.Book;
import com.codahale.metrics.annotation.Metered;
import com.codahale.metrics.annotation.Timed;
import io.dropwizard.jersey.PATCH;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tham
 *
 * Simple Book resource file
 */

@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

    @GET
    @Metered
    public List<Book> getBooks() {
        List<Book> books = new ArrayList<Book>(2);
        books.add(new Book("1416562605", "he White Tiger: A Novel"));
        books.add(new Book("1465438165", "Star Wars: The Force Awakens Visual Dictionary"));
        return books;
    }

    @GET
    @Path("{isbn}")
    @Metered
    public Book getBook(@PathParam("isbn") String isbn) {
        return new Book("1416562605", "he White Tiger: A Novel");
    }
}
