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

    private final List<Book> testBooks = new ArrayList<>(Arrays.asList(BOOK_1, BOOK_2, BOOK_3, BOOK_4));
    private Book testBook;

    private final int INVALID_BOOK_ID = 999;

    @Before
    public void setup() {
        dao = new JdbcBookDao(dataSource);
        invalidConnectionDao = new JdbcBookDao(invalidDataSource);
        testBook = new Book(99, "Test book", new BigDecimal("3.7"), false, 1, 1, LocalDate.now());
    }

    @Test
    public void getBookById_throws_dao_exception_for_invalid_connection() {
        String methodName = "getBookById";
        try {
            invalidConnectionDao.getBookById(1);
            Assert.fail(didNotThrowAnyExceptionForCannotGetConnection(methodName));
        } catch (DaoException e) {
            // expected
        } catch (Exception e) {
            Assert.fail(didNotThrowDaoExceptionForCannotGetConnection(methodName));
        }
    }

    @Test
    public void createBook_returns_new_book_id() {
        Book createdBook = dao.createBook(testBook);
        Assert.assertNotNull("createBook returned null", createdBook);

        // verify value was saved to database, retrieve it and compare values
        Book retrievedBook = dao.getBookById(createdBook.getBookId());
        assertBooksMatch("createBook did not return the newly inserted record", createdBook, retrievedBook);
    }

    @Test
    public void createBook_throws_dao_exception_for_data_integrity_violation() {
        testBook.setPublisherId(999); // invalid publisher_id

        String methodName = "createBook";
        try {
            dao.createBook(testBook);
            Assert.fail(didNotThrowAnyExceptionForDataIntegrity(methodName));
        } catch (DaoException e) {
            if (e.getMessage().equalsIgnoreCase(methodName + NOT_IMPLEMENTED_LONG_SUFFIX)) {
                Assert.fail(threwNotImplementedException(methodName));
            }
        } catch (Exception e) {
            Assert.fail(didNotThrowDaoExceptionForDataIntegrity(methodName));
        }
    }

    @Test
    public void createBook_throws_dao_exception_for_invalid_connection() {
        String methodName = "createBook";
        try {
            invalidConnectionDao.createBook(testBook);
            Assert.fail(didNotThrowAnyExceptionForCannotGetConnection(methodName));
        } catch (DaoException e) {
            // expected
        } catch (Exception e) {
            Assert.fail(didNotThrowDaoExceptionForCannotGetConnection(methodName));
        }
    }

    @Test
    public void deleteBookById_removes_book() {
        // test that book exists in dao
        testBook = dao.getBookById(BOOK_1.getBookId());
        assertBooksMatch("failed to confirm book exists in dao BEFORE delete", BOOK_1, testBook);
        int numDeleted = dao.deleteBookById(BOOK_1.getBookId());
        Assert.assertEquals("deleteBookById(int id) didn't return 1, the number of books deleted", 1, numDeleted);
        // test that book no longer exists in dao
        testBook = dao.getBookById(BOOK_1.getBookId());
        Assert.assertNull("deleteBookById(int id) failed to remove the correct book", testBook);
    }

    @Test
    public void deleteBookById_returns_zero_when_book_doesnt_exist() {
        // delete a book with an invalid id
        int numDeleted = dao.deleteBookById(INVALID_BOOK_ID);
        Assert.assertEquals("deleteBookById(int id) didn't return 0 for non-existent book", 0, numDeleted);
    }

    @Test
    public void deleteBookById_throws_dao_exception_for_invalid_connection() {

        String methodName = "deleteBookById";
        try {
            invalidConnectionDao.deleteBookById(1);
            Assert.fail(didNotThrowAnyExceptionForCannotGetConnection(methodName));
        } catch (DaoException e) {
            // expected
        } catch (Exception e) {
            Assert.fail(didNotThrowDaoExceptionForCannotGetConnection(methodName));
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
