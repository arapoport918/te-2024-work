package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Book;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class JdbcBookDao implements BookDao {

    private final JdbcTemplate jdbcTemplate;
    private String SQL_BASE = "SELECT book_id, book_title, star_rating, out_of_print, foreword_by, publisher_id, published_date ";

    public JdbcBookDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Book> getBooks() {
        String sql = SQL_BASE + "FROM book;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            return listBooks(results);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Cannot connect to database or server.", e);
        }

    }

    @Override
    public Book getBookById(int bookId) {
        String sql = SQL_BASE + "FROM book " +
                "WHERE book_id = ?;";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, bookId);
            if (results.next()) {
                return mapRowToBook(results);
            } else {
                return null;
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Cannot connect to database or server.", e);
        }

    }

    @Override
    public Book updateBookRating(int bookId, BigDecimal newRating) {
        String sql = "UPDATE book SET star_rating = ? " +
                "WHERE book_id = ?;";
        try {
            int rows = jdbcTemplate.update(sql, newRating, bookId);

            if (rows == 0) {
                throw new DaoException("Zero rows affected, expected at least one; invalid book id.");
            }

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Cannot connect to database or server.", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data Integrity Violation.", e);
        }

        return getBookById(bookId);
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

    private List<Book> listBooks(SqlRowSet results) {
        List<Book> books = new ArrayList<>();

        while (results.next()) {
            books.add(mapRowToBook(results));
        }

        return books;
    }
}
