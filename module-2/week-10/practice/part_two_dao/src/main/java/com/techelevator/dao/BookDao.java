package com.techelevator.dao;

import com.techelevator.model.Book;
import com.techelevator.exception.DaoException;

import java.math.BigDecimal;
import java.util.List;

public interface BookDao {

    /**
     * Returns all books from the datastore.
     *
     * @return List of all books
     */
    List<Book> getBooks();

    /**
     * Returns a specific book from the datastore.
     *
     * @param id the id of the book to retrieve
     * @return The Book object with the given id, or null if the book isn't found
     */
    Book getBookById(int id);

    /**
     * Sets the rating of the given book to the given rating.
     *
     * @param id the book to update
     * @param newRating the new rating for the book
     * @return the Book object with its updated rating
     * @throws DaoException when no book with given id exists
     */
    Book updateBookRating(int id, BigDecimal newRating);
}
