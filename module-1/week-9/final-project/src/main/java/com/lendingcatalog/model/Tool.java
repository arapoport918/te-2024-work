package com.lendingcatalog.model;

import java.time.LocalDate;
import java.util.UUID;

public class Tool implements CatalogItem, LoggableItem{
    private String id;
    private String type;
    private String manufacturer;
    private int count;

    public Tool(String type, String manufacturer, int count) {
        this.type = type;
        this.manufacturer = manufacturer;
        this.count = count;
    }

    @Override
    public boolean matchesName(String searchStr) {
        String search = searchStr.toLowerCase();
        String compareTo = this.type.toLowerCase();

        return search.equals(compareTo);
    }

    @Override
    public boolean matchesCreator(String searchStr) {
        String search = searchStr.toLowerCase();
        String compareTo = this.manufacturer.toLowerCase();

        return search.equals(compareTo);
    }

    @Override
    public boolean matchesYear(int searchYear) {
        return false;
    }

    @Override
    public void registerItem() {
        id = UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
        return "*" + type + System.lineSeparator() +
                " - Manufactured by: " + manufacturer + System.lineSeparator() +
                " - Quantity: " + count + System.lineSeparator() +
                " - Id: " + id + System.lineSeparator();
    }

    @Override
    public String logForm() {
        return this.toString() + System.lineSeparator() + " Created on: " + LocalDate.now();
    }
}
