package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Book;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JdbcBookDaoTests extends BaseDaoTests {
    
    private static final Book BOOK_1 = new Book(1, "BOOK 1", new BigDecimal("5.0"), false, 2, 1, LocalDate.parse("2022-01-01"));
    private static final Book BOOK_2 = new Book(2, "BOOK 2", new BigDecimal("4.9"), false, 1, 2, LocalDate.parse("2022-02-02"));
    private static final Book BOOK_3 = new Book(3, "BOOK 3", new BigDecimal("2.5"), true, null, 1, LocalDate.parse("2022-03-03"));
    private static final Book BOOK_4 = new Book(4, "BOOK 4", new BigDecimal("0.0"), true, null, 2, LocalDate.parse("2022-04-04"));

    private JdbcBookDao dao;
    private JdbcBookDao invalidConnectionDao;

    private final int INVALID_BOOK_ID = 999;

    private final List<Book> testBooks = new ArrayList<>(Arrays.asList(BOOK_1, BOOK_2, BOOK_3, BOOK_4));
    private Book testBook;
    
    @Before
    public void setup() {
        dao = new JdbcBookDao(dataSource);
        invalidConnectionDao = new JdbcBookDao(invalidDataSource);
        testBook = null;
    }

    @Test
    public void getBooks_returns_all_books() {
        List<Book> books = dao.getBooks();
        Assert.assertEquals("getBooks returned wrong number of books", testBooks.size(), books.size());
        assertBooksMatch("getBooks returned wrong or partial data", BOOK_1, books.get(0));
        assertBooksMatch("getBooks returned wrong or partial data", BOOK_2, books.get(1));
        assertBooksMatch("getBooks returned wrong or partial data", BOOK_3, books.get(2));
        assertBooksMatch("getBooks returned wrong or partial data", BOOK_4, books.get(3));
    }

    @Test
    public void getBooks_throws_dao_exception_for_invalid_data_source() {
        String methodName = "getBooks";
        try {
            invalidConnectionDao.getBooks();
            Assert.fail(didNotThrowAnyException(methodName));
        } catch (DaoException e) {
            // expected
        } catch (Exception e) {
            Assert.fail(didNotThrowDaoException(methodName));
        }
    }

    @Test
    public void getBookById_returns_specified_book() {
        testBook = dao.getBookById(BOOK_1.getBookId());
        assertBooksMatch("getBookById(int id) returned wrong or partial data.", BOOK_1, testBook);
    }

    @Test
    public void getBookById_returns_null_if_not_found() {
        testBook = dao.getBookById(INVALID_BOOK_ID);
        Assert.assertNull("getBookById(int id) didn't return null for id that doesn't exist." , testBook);
    }

    @Test
    public void getBookById_throws_dao_exception_for_invalid_data_source() {
        String methodName = "getBookById";

        try {
            invalidConnectionDao.getBookById(1);
            Assert.fail(didNotThrowAnyException(methodName));
        } catch (DaoException e) {
            // expected
        } catch (Exception e) {
            Assert.fail(didNotThrowDaoException(methodName));
        }
    }

    @Test
    public void updateBookRating_return_book_with_new_rating() {
        BigDecimal newRating = new BigDecimal("3.0");
        Book testBook = dao.updateBookRating(BOOK_1.getBookId(), newRating);
        Book updatedBook = dao.getBookById(BOOK_1.getBookId());
        Assert.assertEquals("updateBookRating(int id, BigDecimal newRating) did not return a book object with the updated starRating", testBook.getStarRating(), updatedBook.getStarRating());
    }

    @Test
    public void updateBookRating_throws_exception_for_invalid_bookid() {
        try {
            dao.updateBookRating(INVALID_BOOK_ID, BigDecimal.ONE);
            Assert.fail("Expected DaoException not thrown");
        } catch (DaoException expected) {
            // updateBookRating threw a DaoException as expected
        }
    }

    @Test
    public void updateBookRating_throws_dao_exception_for_invalid_data_source() {
        String methodName = "updateBookRating";
        try {
            invalidConnectionDao.updateBookRating(1, new BigDecimal("5.0"));
            Assert.fail(didNotThrowAnyException(methodName));
        } catch (DaoException e) {
            // expected
        } catch (Exception e) {
            Assert.fail(didNotThrowDaoException(methodName));
        }
    }

    private void assertBooksMatch(String message, Book expected, Book actual) {
        Assert.assertEquals(message, expected.getBookId(), actual.getBookId());
        Assert.assertEquals(message, expected.getBookTitle(), actual.getBookTitle());
        Assert.assertEquals(message, expected.getStarRating(), actual.getStarRating());
        Assert.assertEquals(message, expected.isOutOfPrint(), actual.isOutOfPrint());
        Assert.assertEquals(message, expected.getForewordBy(), actual.getForewordBy());
        Assert.assertEquals(message, expected.getPublisherId(), actual.getPublisherId());
        Assert.assertEquals(message, expected.getPublishedDate(), actual.getPublishedDate());
    }
}
