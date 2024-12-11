package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Book;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;

public class JdbcBookDao implements BookDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcBookDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Book getBookById(int bookId) {
        Book book = null;
        String sql = "SELECT book_id, book_title, star_rating, out_of_print, foreword_by, publisher_id, published_date" +
                " FROM book WHERE book_id = ?;";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, bookId);
            if (results.next()) {
                book = mapRowToBook(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Cannot connect to server or database.", e);
        }

        return book;
    }

    @Override
    public Book createBook(Book newBook) {
        String sql = "INSERT INTO book (book_title, star_rating, out_of_print, foreword_by, publisher_id, published_date) " +
                "VALUES (?, ?, ?, ?, ?, ?) RETURNING book_id;";
        try {
            int newBookId = jdbcTemplate.queryForObject(sql,
                    int.class,
                    newBook.getBookTitle(),
                    newBook.getStarRating(),
                    newBook.isOutOfPrint(),
                    newBook.getForewordBy(),
                    newBook.getPublisherId(),
                    newBook.getPublishedDate());
            return getBookById(newBookId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Cannot connect to server or database.", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data Integrity Violation.", e);
        }

    }

    @Override
    public int deleteBookById(int bookId) {
        String sqlBookAuthor = "DELETE FROM book_author WHERE book_id = ?;";
        String sqlBook = "DELETE FROM book WHERE book_id = ?;";

        try {
            jdbcTemplate.update(sqlBookAuthor, bookId);
            return jdbcTemplate.update(sqlBook, bookId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Cannot connect to server or database.", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data Integrity Violation.", e);
        }
    }

    private Book mapRowToBook(SqlRowSet results) {
        Book book = new Book();
        book.setBookId(results.getInt("book_id"));
        book.setBookTitle(results.getString("book_title"));
        book.setStarRating(results.getBigDecimal("star_rating"));
        book.setOutOfPrint(results.getBoolean("out_of_print"));
        book.setForewordBy((Integer) results.getObject("foreword_by"));
        book.setPublisherId(results.getInt("publisher_id"));
        book.setPublishedDate(results.getDate("published_date").toLocalDate());
        return book;
    }
}
