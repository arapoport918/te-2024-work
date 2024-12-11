package com.techelevator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class App {

    // The regex string to split the Strings in the dataset.
    private static final String FIELD_DELIMITER = "\\|";

    private static final int TITLE_FIELD = 0;
    private static final int AUTHOR_FIELD = 1;
    private static final int PUBLISHED_YEAR_FIELD = 2;
    private static final int PRICE_FIELD = 3;

    private final Scanner keyboard = new Scanner(System.in);

    private List<String> titles = new ArrayList<>();
    private List<String> authors = new ArrayList<>();
    private List<Integer> publishedYears = new ArrayList<>();
    private List<BigDecimal> prices = new ArrayList<>();

    public static void main(String[] args) {

        App app = new App();
        app.loadData();
        app.run();

    }

    private void loadData() {

        String[] dataset = Dataset.load();

        /*
         Requirement: 1
         Populate the instance variables `titles`, `authors`, `publishedYears`,
         and `prices` by splitting each string in the `dataset` array and adding
         the individual fields to the appropriate list.
         See README for additional details.
         */


        for (String datasetElement : dataset) {

            String[] splitDatasetElements = datasetElement.split(FIELD_DELIMITER);

            titles.add(splitDatasetElements[TITLE_FIELD]);
            authors.add(splitDatasetElements[AUTHOR_FIELD]);
            publishedYears.add(Integer.parseInt(splitDatasetElements[PUBLISHED_YEAR_FIELD]));
            prices.add(new BigDecimal(splitDatasetElements[PRICE_FIELD]));

        }


    }

    private void run() {

        while (true) {
            // Main menu loop
            printMainMenu();
            int mainMenuSelection = promptForMenuSelection("Please choose an option: ");
            if (mainMenuSelection == 1) {
                // Display data and subsets loop
                while (true) {
                    printDataAndSubsetsMenu();
                    int dataAndSubsetsMenuSelection = promptForMenuSelection("Please choose an option: ");
                    if (dataAndSubsetsMenuSelection == 1) {
                        displayDataset(Dataset.load());
                    } else if (dataAndSubsetsMenuSelection == 2) {
                        displayTitlesList(titles);
                    } else if (dataAndSubsetsMenuSelection == 3) {
                        displayAuthorsList(authors);
                    } else if (dataAndSubsetsMenuSelection == 4) {
                        displayPublishedYearsList(publishedYears);
                    } else if (dataAndSubsetsMenuSelection == 5) {
                        displayPricesList(prices);
                    } else if (dataAndSubsetsMenuSelection == 0) {
                        break;
                    }
                }
            } else if (mainMenuSelection == 2) {
                while (true) {
                    printSearchBooksMenu();
                    int searchBooksMenuSelection = promptForMenuSelection("Please choose an option: ");
                    if (searchBooksMenuSelection == 1) {
                        // Search by title
                        String filterTitle = promptForString("Enter title: ");
                        /*
                         Requirement: 3b
                         Replace `displayTitlesList(titles)` with calls to the
                          `filterByTitle()` and `displaySearchResults()` methods.
                         */
                        List<Integer> titleIndexes = filterByTitle(filterTitle);
                        displaySearchResults(titleIndexes, TITLE_FIELD);
                    } else if (searchBooksMenuSelection == 2) {
                        // Search by author
                        String filterAuthor = promptForString("Enter author: ");
                        /*
                         Requirement: 4b
                         Replace `displayAuthorsList(authors)` with calls to the
                         `filterByAuthor()` and `displaySearchResults()` methods.
                         */
                        List<Integer> authorIndexes = filterByAuthor(filterAuthor);
                        displaySearchResults(authorIndexes, AUTHOR_FIELD);
                    } else if (searchBooksMenuSelection == 3) {
                        // Search by published year
                        int filterYear = promptForPublishedYear("Enter date (YYYY): ");
                        /*
                         Requirement: 5b
                         Replace `displayPublishedYearsList(publishedYears)` with calls
                         to the `filterByPublishedYear()` and `displaySearchResults()` methods.
                         */
                        List<Integer> publishedYearIndexes = filterByPublishedYear(filterYear);
                        displaySearchResults(publishedYearIndexes, PUBLISHED_YEAR_FIELD);
                    } else if (searchBooksMenuSelection == 4) {
                        // Search by published year range
                        int filterFromYear = promptForPublishedYear("Enter \"from\" date (YYYY): ");
                        int filterToYear = promptForPublishedYear("Enter \"to\" date (YYYY): ");
                        /*
                         Requirement: 6b
                         Replace `displayPublishedYearsList(publishedYears)` with calls
                         to the `filterByPublishedYearRange()` and `displaySearchResults()` methods.
                         */
                        List<Integer> publishedYearRangesIndexes = filterByPublishedYearRange(filterFromYear, filterToYear);
                        displaySearchResults(publishedYearRangesIndexes, PUBLISHED_YEAR_FIELD);
                    } else if (searchBooksMenuSelection == 5) {
                        // Find the most recent books
                        /*
                         Requirement: 7b
                         Replace `displayPublishedYearsList(publishedYears)` with calls
                         to the `findMostRecentBooks()` and `displaySearchResults()` methods.
                         */
                        List<Integer> mostRecentlyPublishedBook = findMostRecentBooks();
                        displaySearchResults(mostRecentlyPublishedBook, PUBLISHED_YEAR_FIELD);
                    } else if (searchBooksMenuSelection == 6) {
                        // Search by price
                        double filterPrice = promptForPrice("Enter price: ");
                        /*
                         Requirement: 8b
                         Replace `displayPricesList(prices)` with calls to the
                         `filterByPrice()` and `displaySearchResults()` methods.
                         */
                        List<Integer> pricesIndexes = filterByPrice(filterPrice);
                        displaySearchResults(pricesIndexes, PRICE_FIELD);
                    } else if (searchBooksMenuSelection == 7) {
                        // Search by price range
                        double filterFromPrice = promptForPrice("Enter \"from\" price: ");
                        double filterToPrice = promptForPrice("Enter \"to\" price: ");
                        /*
                         Requirement: 9b
                         Replace `displayPricesList(prices)` with calls to the
                         `filterByPriceRange()` and `displaySearchResults()` methods.
                         */
                        List<Integer> pricesRangeIndexes = filterByPriceRange(filterFromPrice, filterToPrice);
                        displaySearchResults(pricesRangeIndexes, PRICE_FIELD);
                        //displayPricesList(prices);
                    } else if (searchBooksMenuSelection == 8) {
                        // Find the least expensive books
                        /*
                         Requirement: 10b
                         Replace `displayPricesList(prices)` with calls to the
                         `findLeastExpensiveBooks()` and `displaySearchResults()` methods.
                         */
                        List<Integer> leastExpensiveBooks = findLeastExpensiveBooks();
                        displaySearchResults(leastExpensiveBooks, PRICE_FIELD);
                    } else if (searchBooksMenuSelection == 0) {
                        break;
                    }
                }
            } else if (mainMenuSelection == 0) {
                break;
            }
        }

    }


    private void sortSearchResults(List<Integer> indexes, int primaryField) {

        if (primaryField == TITLE_FIELD) {
            for (int i = 0; i < indexes.size(); i++) {
                for (int j = 0; j < indexes.size(); j++) {
                    if (titles.get(j).compareTo(titles.get(j + 1)) >= 0) {
                        String tempValue = titles.get(j);
                        titles.set(j, titles.get(j + 1));
                        titles.set(j + 1, tempValue);
                    }
                }
            }
        } else if (primaryField == AUTHOR_FIELD) {
            for (int i = 0; i < indexes.size(); i++) {
                for (int j = 0; j < indexes.size(); j++) {
                    if (authors.get(j).compareTo(authors.get(j + 1)) >= 0) {
                        String tempValue = authors.get(j);
                        authors.set(j, authors.get(j + 1));
                        authors.set(j + 1, tempValue);
                    }
                }
            }
        } else if (primaryField == PUBLISHED_YEAR_FIELD) {
            for (int i = 0; i < indexes.size(); i++) {
                for (int j = 0; j < indexes.size(); j++) {
                    if (publishedYears.get(j) >= publishedYears.get(j +1)) {
                        int tempValue = publishedYears.get(j);
                        publishedYears.set(j, publishedYears.get(j + 1));
                        publishedYears.set(j + 1, tempValue);
                    }
                }
            }

        } else {
            for (int i = 0; i < indexes.size(); i++) {
                for (int j = 0; j < indexes.size(); j++) {
                    if (prices.get(j).compareTo(prices.get(j + 1)) >= 1) {
                        BigDecimal tempValue = prices.get(j).setScale(2, RoundingMode.HALF_UP);
                        prices.set(j, prices.get(j + 1));
                        prices.set(j + 1, tempValue);
                    }
                }
            }
        }
        //Bubble Sort, Work in Progress, Credit: Abebba

    }

    /*
     Requirement: 2
     Write the displaySearchResults(List<Integer> indexes) method.
     See README for additional details.
     */

    private void displaySearchResults(List<Integer> indexes, int primaryField) {

        //sortSearchResults(indexes, primaryField); causing bug in PubYear range function

        for (Integer index : indexes) {
            if (primaryField == TITLE_FIELD) {
                System.out.println(titles.get(index) + ": " + authors.get(index) + ": " + publishedYears.get(index) + ": $" + prices.get(index));
            } else if (primaryField == AUTHOR_FIELD) {
                System.out.println(authors.get(index) + ": " + titles.get(index) + ": " + publishedYears.get(index) + ": $" + prices.get(index));
            } else if (primaryField == PUBLISHED_YEAR_FIELD) {
                System.out.println(publishedYears.get(index) + ": " + titles.get(index) + ": " + authors.get(index) + ": $" + prices.get(index));
            } else {
                System.out.println("$" + prices.get(index) + ": " + titles.get(index) + ": " + authors.get(index) + ": " + publishedYears.get(index));
            }
        }
        System.out.println(); //creates a break (credit: Zack)
    }


    /*
     Requirement: 3a
     Complete the `filterByTitle()` method.
     See README for additional details.
     */

    private List<Integer> filterByTitle(String filterTitle) {

        List<Integer> indexes = new ArrayList<>();

        for (int i = 0; i < titles.size(); i++) {
            String uppercaseTitle = titles.get(i).toUpperCase();
            String uppercaseInput = filterTitle.toUpperCase();
            if (uppercaseTitle.contains(uppercaseInput)) {
                indexes.add(i);
            }
        }
        return indexes;
    }

    /*
     Requirement: 4a
     Complete the `filterByAuthor()` method.
     See README for additional details.
     */
    private List<Integer> filterByAuthor(String filterAuthor) {
        List<Integer> indexes = new ArrayList<>();

        for (int i = 0; i < authors.size(); i++) {
            String uppercaseAuthor = authors.get(i).toUpperCase();
            String uppercaseInput = filterAuthor.toUpperCase();
            if (uppercaseAuthor.contains(uppercaseInput)) {
                indexes.add(i);
            }
        }
        return indexes;
    }

    /*
     Requirement: 5a
     Complete the `filterByPublishedYear()` method.
     See README for additional details.
     */
    private List<Integer> filterByPublishedYear(int filterYear) {

        List<Integer> indexes = new ArrayList<>();

        for (int i = 0; i < publishedYears.size(); i++) {
            if (publishedYears.get(i) == filterYear) {
                indexes.add(i);
            }
        }
        return indexes;
    }

    /*
     Requirement: 6a
     Complete the `filterByPublishedYearRange()` method.
     See README for additional details.
     */
    private List<Integer> filterByPublishedYearRange(int filterFromYear, int filterToYear) {

        List<Integer> indexes = new ArrayList<>();

        for (int i = 0; i < prices.size(); i++) {
            if (publishedYears.get(i) >= filterFromYear && publishedYears.get(i) <= filterToYear) {
                indexes.add(i);
            }
        }

        return indexes;
    }

    /*
     Requirement: 7a
     Add the `private List<Integer> findMostRecentBooks()` method.
     See README for additional details.
     */

    private List<Integer> findMostRecentBooks() {

        List<Integer> indexes = new ArrayList<>();

        Integer maxValue = Collections.max(publishedYears);

        for (int i = 0; i < publishedYears.size(); i++) {
            if (publishedYears.get(i).equals(maxValue)) {
                indexes.add(i);
            }
        }

        return indexes;
    }


    /*
     Requirement: 8a
     Complete the `filterByPrice()` method.
     See README for additional details.
     */
    private List<Integer> filterByPrice(double filterPrice) {

        List<Integer> indexes = new ArrayList<>();

        BigDecimal priceInput = new BigDecimal(filterPrice).setScale(2, RoundingMode.HALF_UP);

        for (int i = 0; i < prices.size(); i++) {
            if (prices.get(i).compareTo(priceInput) <= 0) {
                indexes.add(i);
            }
        }

        return indexes;
    }

    /*
     Requirement: 9a
     Complete the `filterByPriceRange()` method.
     See README for additional details.
     */
    private List<Integer> filterByPriceRange(double filterFromPrice, double filterToPrice) {

        List<Integer> indexes = new ArrayList<>();

        BigDecimal priceRangeMin = new BigDecimal(filterFromPrice).setScale(2, RoundingMode.HALF_UP);
        BigDecimal priceRangeMax = new BigDecimal(filterToPrice).setScale(2, RoundingMode.HALF_UP);

        for (int i = 0; i < prices.size(); i++) {
            if (prices.get(i).compareTo(priceRangeMin) >= 0 && prices.get(i).compareTo(priceRangeMax) <= 0) {
                indexes.add(i);
            }
        }

        return indexes;
    }

    /*
     Requirement: 10a
     Add the `private List<Integer> findLeastExpensiveBooks()` method.
     See README for additional details.
     */

    private List<Integer> findLeastExpensiveBooks() {

        List<Integer> indexes = new ArrayList<>();
        BigDecimal lowestPrice = new BigDecimal(String.valueOf(prices.get(0)));

        for (int i = 1; i < prices.size(); i++) {
            if (prices.get(i).compareTo(lowestPrice) < 0) {
                lowestPrice = prices.get(i);
            }
        }

        for (int i = 0; i < prices.size(); i++) {
            if (prices.get(i).equals(lowestPrice)) {
                indexes.add(i);
            }
        }

        return indexes;

    }


    // UI methods

    private void printMainMenu() {
        System.out.println("1: Display data and subsets");
        System.out.println("2: Search books");
        System.out.println("0: Exit");
        System.out.println();
    }

    private void printDataAndSubsetsMenu() {
        System.out.println("1: Display dataset");
        System.out.println("2: Display titles");
        System.out.println("3: Display authors");
        System.out.println("4: Display published years");
        System.out.println("5: Display prices");
        System.out.println("0: Return to main menu");
        System.out.println();
    }

    private void printSearchBooksMenu() {
        System.out.println("1: Search by title");
        System.out.println("2: Search by author");
        System.out.println("3: Search by published year");
        System.out.println("4: Search by published year range");
        System.out.println("5: Find most recent books");
        System.out.println("6: Search by price");
        System.out.println("7: Search by price range");
        System.out.println("8: Find least expensive books");
        System.out.println("0: Return to main menu");
        System.out.println();
    }

    private void displayDataset(String[] dataset) {
        System.out.println("Dataset");
        System.out.println("-------");
        for (String data : dataset) {
            System.out.println(data);
        }
        System.out.println();
        promptForReturn();
    }

    private void displayTitlesList(List<String> titles) {
        System.out.println("Titles");
        System.out.println("-------");
        for (int i = 0; i < titles.size(); i++) {
            System.out.println(i + ": " + titles.get(i));
        }
        System.out.println();
        promptForReturn();
    }

    private void displayAuthorsList(List<String> authors) {
        System.out.println("Authors");
        System.out.println("-------");
        for (int i = 0; i < authors.size(); i++) {
            System.out.println(i + ": " + authors.get(i));
        }
        System.out.println();
        promptForReturn();
    }

    private void displayPublishedYearsList(List<Integer> publishedYears) {
        System.out.println("Published Years");
        System.out.println("---------------");
        for (int i = 0; i < publishedYears.size(); i++) {
            System.out.println(i + ": " + publishedYears.get(i));
        }
        System.out.println();
        promptForReturn();
    }

    private void displayPricesList(List<BigDecimal> prices) {
        System.out.println("Prices");
        System.out.println("------");
        for (int i = 0; i < prices.size(); i++) {
            System.out.println(i + ": " + prices.get(i));
        }
        System.out.println();
        promptForReturn();
    }

    private int promptForMenuSelection(String prompt) {
        System.out.print(prompt);
        int menuSelection;
        try {
            menuSelection = Integer.parseInt(keyboard.nextLine());
        } catch (NumberFormatException e) {
            menuSelection = -1;
        }
        return menuSelection;
    }

    private String promptForString(String prompt) {
        System.out.print(prompt);
        return keyboard.nextLine();
    }

    private int promptForPublishedYear(String prompt) {
        int year;
        while (true) {
            System.out.println(prompt);
            try {
                year = Integer.parseInt(keyboard.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("The year provided is not well-formed. It must be YYYY.");
            }
        }
        return year;
    }

    private double promptForPrice(String prompt) {
        double price;
        while (true) {
            System.out.println(prompt);
            try {
                price = Double.parseDouble(keyboard.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("The price provided is not a valid monetary value.");
            }
        }
        return price;
    }

    private void promptForReturn() {
        System.out.println("Press RETURN to continue.");
        keyboard.nextLine();
    }
}
