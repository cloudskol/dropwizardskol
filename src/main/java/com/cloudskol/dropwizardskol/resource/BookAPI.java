package com.cloudskol.dropwizardskol.resource;

import com.cloudskol.dropwizardskol.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.PathParam;
import java.util.List;

/**
 * @author tham
 */

public class BookAPI implements IBookResource {
    private static final Logger logger = LoggerFactory.getLogger(BookAPI.class);

    public List<Book> all() {
        logger.info("Enters all()");
        return BookDataProvider.getInstance().getBooks();
    }

    public Book get(String id) {
        logger.info("Enters get() for {}", id);
        return BookDataProvider.getInstance().getBook(id);
    }

    public void create(Book book) {
        logger.info("Enters create() {} ", book);
        BookDataProvider.getInstance().addBook(book);
    }

    public Book update(String id, Book book) {
        logger.info("Enters update() for {}", id);
        return null;
    }

    public void delete(String id) {
        logger.info("Enters delete() for {}", id);
        BookDataProvider.getInstance().removeBook(id);
    }
}
