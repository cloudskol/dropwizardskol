package com.cloudskol.dropwizardskol.resource;

import com.cloudskol.dropwizardskol.model.Book;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author tham
 */

public class BookDataProvider {
    private static final BookDataProvider instance = new BookDataProvider();
    private static final List<Book> books = new ArrayList<Book>(12);

    private BookDataProvider() {}

    public static synchronized BookDataProvider getInstance() {
        return instance;
    }

    public List<Book> getBooks() {
        return books;
    }

    public Book getBook(String id) {
        for (Book book: books) {
            if (book.getId().equals(id)) {
                return book;
            }
        }

        return null;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(String id) {
        final Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId().equals(id)) {
                iterator.remove();
                break;
            }
        }
    }

    static {
        books.add(new Book("1", "1416562605", "The White Tiger: A Novel"));
    }
}
