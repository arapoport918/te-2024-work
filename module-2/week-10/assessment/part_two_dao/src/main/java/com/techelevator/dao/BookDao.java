package com.techelevator.dao;

import com.techelevator.model.Book;

public interface BookDao {

    /**
     * Returns a specific book from the datastore.
     *
     * @param id the id of the book to retrieve
     * @return The Book object with the given id, or null if the book isn't found
     */
    Book getBookById(int id);

    /**
     * Adds a new Book into the datastore.
     *
     * @param newBook the Book object to add
     * @return the Book object with its new id filled in
     */
    Book createBook(Book newBook);

    /**
     * Removes a Book from the datastore.
     *
     * @param id the book to remove
     * @return The number of Books removed
     */
    int deleteBookById(int id);
}
