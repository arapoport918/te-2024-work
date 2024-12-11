# Module Assessment - DAO

## Introduction

This practice assessment verifies the competencies that you learned during the module. It's a hands-on assessment that you'll complete inside your IDE.

This part of the hands-on assessment has you write three methods for a DAO class. The DAO methods are for the `BooksDB` database.

**After completing this part, you may `add`, `commit`, and `push` the code to your repository. Since this is a practice assessment, it's not graded and you don't need to submit this assessment to BootcampOS.**

## Hints and suggestions

* If you haven't done so already, create the `BooksDB` database. The script for the data is in the `part_one_sql` folder.
* `push` your code often. Whenever you reach a point where you feel like you've made good progress and your code builds, commit and push your changes.
* The code you submit must build properly to get scored. _Please make sure you don't have any build errors._

## Exploring the code

In the `com.techelevator.model` package is a `Book` class. This class represents a record in the `book` table of the `BooksDB` database. You'll use this model for your DAO code.

In the `com.techelevator.dao` package is a `BookDao` interface like you've seen in DAO code earlier in this module.

The `JdbcBookDao` class implements the `BookDao` interface, and this is where you'll write your code. You need to write the code for the `getBooks()`, `getBookById(int id)`, and `updateBookRating(int id, BigDecimal newRating)` methods. The `JdbcTemplate` is already defined in the class and instantiated in the class constructor. You're also provided a mapping method—`mapRowToBook()`—to map a SQL row to a `Book` object.

## Running the tests

The project includes JUnit tests for you to verify your code. The tests are in `src/test/java/com.techelevator.dao/JdbcBookDaoTests.java`.

The tests load a test version of the `BooksDB` database with test data. This is similar to the tests you ran for the DAO exercises earlier in the module.

> To run all tests in _IntelliJ_, you can right-click the `java` folder beneath `test`, and select **Run 'All Tests'**.

## Code requirements

As stated before, you'll complete the `getBooks()`, `getBookById(int id)`, and `updateBookRating(int id, BigDecimal newRating)` methods. Complete each method and run the tests to verify your work.

The `getBooks()` method must:
* Select all rows the the `book` table
* Map each row to a `Book` object
* Return a `List` of `Book` objects
* Throw a `DaoException` when `JdbcTemplate` can't get a connection to the database

The `getBookById(int id)` method must:
* Select a specific row from the `book` table, given the `book_id`
* Map the row to a `Book` object
* Return a `Book` object
* Throw a `DaoException` when `JdbcTemplate` can't get a connection to the database

The `updateBookRating(int id, BigDecimal newRating)` method must:
* Update the `star_rating` of a row in the `book` table, given a specific `book_id`
* Retrieve the updated `Book` object and return it
* Throw a `DaoException` when `JdbcTemplate` can't get a connection to the database
* Throw a `DaoException` when there's no book with the given `id` in the database
* Throw a `DaoException` when there would be a data integrity violation from the data change

## Submit your work

Since this is a practice assessment, you don't need to submit your work. Be sure that all tests in the `test` folder pass.
