package com.lendingcatalog.model;

import java.time.LocalDate;
import java.util.Locale;
import java.util.UUID;

public class Book implements CatalogItem, LoggableItem {
    private String id;
    private String title;
    private String author;
    private LocalDate publishDate;

    public Book(String title, String author, LocalDate publishDate) {
        this.title = title;
        this.author = author;
        this.publishDate = publishDate;
    }

    @Override
    public boolean matchesName(String searchStr) {
        String search = searchStr.toLowerCase();
        String compareTo = this.title.toLowerCase();

        return search.equals(compareTo);
    }

    @Override
    public boolean matchesCreator(String searchStr) {
        String search = searchStr.toLowerCase();
        String compareTo = this.author.toLowerCase();

        return search.equals(compareTo);
    }

    @Override
    public boolean matchesYear(int searchYear) {
        return searchYear == publishDate.getYear();
    }

    @Override
    public void registerItem() {
        id = UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
        return "*" + title + System.lineSeparator() +
                " - Written by: " + author + System.lineSeparator() +
                " - Published by: " + publishDate + System.lineSeparator() +
                " - Id: " + id + System.lineSeparator();
    }

    @Override
    public String logForm() {
        return this.toString() + System.lineSeparator() + " Created on: " + LocalDate.now();
    }
}
