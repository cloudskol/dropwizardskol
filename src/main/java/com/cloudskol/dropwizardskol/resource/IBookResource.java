package com.cloudskol.dropwizardskol.resource;

import com.cloudskol.dropwizardskol.model.Book;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * @author tham
 *
 * Book API interface where all the JAX-RS annotation will be defined
 */

@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
public interface IBookResource {

    @GET
    List<Book> all();

    @GET
    @Path("{id}")
    Book get(@PathParam("id") String id);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    void create(Book book);

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    Book update(@PathParam("id") String id, Book book);

    @DELETE
    @Path("{id}")
    void delete(@PathParam("id") String id);
}
