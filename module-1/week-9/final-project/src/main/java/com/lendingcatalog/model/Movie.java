package com.lendingcatalog.model;

import java.time.LocalDate;
import java.util.UUID;

public class Movie implements CatalogItem, LoggableItem {
    private String id;
    private String name;
    private String director;
    private LocalDate releaseDate;

    public Movie(String name, String director, LocalDate releaseDate) {
        this.name = name;
        this.director = director;
        this.releaseDate = releaseDate;
    }

    @Override
    public boolean matchesName(String searchStr) {
        String search = searchStr.toLowerCase();
        String compareTo = this.name.toLowerCase();

        return search.equals(compareTo);
    }

    @Override
    public boolean matchesCreator(String searchStr) {
        String search = searchStr.toLowerCase();
        String compareTo = this.director.toLowerCase();

        return search.equals(compareTo);
    }

    @Override
    public boolean matchesYear(int searchYear) {
        return searchYear == releaseDate.getYear();
    }

    @Override
    public void registerItem() {
        id = UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
        return "*" + name + System.lineSeparator() +
                " - Directed by: " + director + System.lineSeparator() +
                " - Released: " + releaseDate + System.lineSeparator() +
                " - Id: " + id + System.lineSeparator();
    }

    @Override
    public String logForm() {
        return this.toString() + System.lineSeparator() + " Created on: " + LocalDate.now();
    }

    public boolean isValid() {
        if(!this.name.isEmpty() && !this.director.isEmpty() && this.releaseDate != null) {
            return true;
        }
        return false;
    }
}
