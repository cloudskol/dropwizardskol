package com.cloudskol.dropwizardskol.resource;

import com.cloudskol.dropwizardskol.core.DropwizardSkolException;
import com.cloudskol.dropwizardskol.model.Book;
import com.codahale.metrics.annotation.Timed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
    private static final Logger logger = LoggerFactory.getLogger(BookResource.class);

    @GET
    @Timed
    public List<Book> getBooks() {
        List<Book> books = new ArrayList<Book>(2);
        books.add(new Book("1416562605", "he White Tiger: A Novel"));
        books.add(new Book("1465438165", "Star Wars: The Force Awakens Visual Dictionary"));
        return books;
    }

    @GET
    @Path("{isbn}")
    @Timed
    public Book getBook(@PathParam("isbn") String isbn) {
        return new Book("1416562605", "he White Tiger: A Novel");
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createBook(Book book) {
        logger.info("Enters createBook() {} > {}", book.getIsbn(), book.getTitle());
    }

    @DELETE
    @Path("{isbn}")
    public Response delete(@PathParam("isbn") String isbn) {
        logger.info("Enters delete()");

        final DropwizardSkolException exception = new DropwizardSkolException("Book with mentioned isbn is NOT found");
        return Response.status(Response.Status.NOT_FOUND).entity(exception).build();
    }
}