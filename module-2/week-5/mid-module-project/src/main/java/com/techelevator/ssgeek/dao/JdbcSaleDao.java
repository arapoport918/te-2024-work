package com.techelevator.ssgeek.dao;

import com.techelevator.ssgeek.exception.DaoException;
import com.techelevator.ssgeek.model.Sale;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcSaleDao implements SaleDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcSaleDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Sale getSaleById(int saleId) {
        String sql = "SELECT s.sale_id, s.customer_id, s.sale_date, s.ship_date, c.name FROM sale s " +
                "JOIN customer c ON s.customer_id = c.customer_id " +
                "WHERE s.sale_id = ?" +
                "ORDER BY s.sale_id;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, saleId);

        try {
            if (results.next()) {
                return mapRowsToSale(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        return null;
    }

    @Override
    public List<Sale> getUnshippedSales() {
        String sql = "SELECT s.sale_id, s.customer_id, s.sale_date, s.ship_date, c.name FROM sale s " +
                "JOIN customer c ON s.customer_id = c.customer_id " +
                "WHERE ship_date IS NULL " +
                "ORDER BY s.sale_id;";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            return listSales(results);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("unable to connect to server or database", e);
        }

    }

    @Override
    public List<Sale> getSalesByCustomerId(int customerId) {
        String sql = "SELECT s.sale_id, s.customer_id, s.sale_date, s.ship_date, c.name FROM sale s " +
                "JOIN customer c ON s.customer_id = c.customer_id " +
                "WHERE s.customer_id = ?";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, customerId);
            return listSales(results);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("unable to connect to server or database", e);
        }

    }

    @Override
    public List<Sale> getSalesByProductId(int productId) {
        String sql = "SELECT s.sale_id, s.customer_id, s.sale_date, s.ship_date, c.name FROM sale s " +
                "JOIN customer c ON s.customer_id = c.customer_id " +
                "JOIN line_item li ON s.sale_id = li.sale_id " +
                "JOIN product p ON li.product_id = p.product_id " +
                "WHERE p.product_id = ?;";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, productId);
            return listSales(results);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("unable to connect to server or database", e);
        }

    }

    @Override
    public Sale createSale(Sale newSale) {
        String sql = "INSERT INTO sale (customer_id, sale_date, ship_date) " +
                "VALUES (?, ?, ?) RETURNING sale_id;";

        try {
            int newSaleId = jdbcTemplate.queryForObject(sql, int.class, newSale.getCustomerId(), newSale.getSaleDate(),
                    newSale.getShipDate());
            return getSaleById(newSaleId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

    }

    @Override
    public Sale updateSale(Sale updatedSale) {
        String sql = "UPDATE sale SET customer_id = ?, sale_date = ?, ship_date = ? WHERE sale_id = ?;";

        try {
            int rows = jdbcTemplate.update(sql, updatedSale.getCustomerId(), updatedSale.getSaleDate(),
                    updatedSale.getShipDate(), updatedSale.getSaleId());

            if (rows == 0) {
                throw new DaoException("Zero rows affected, expected at least one");
            }

            return getSaleById(updatedSale.getSaleId());
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

    }

    @Override
    public int deleteSaleById(int saleId) {
        String removeFromLineItem = "DELETE FROM line_item WHERE sale_id = ?;";
        String removeFromSale = "DELETE FROM sale WHERE sale_id = ?;";

        try {
            jdbcTemplate.update(removeFromLineItem, saleId);
            return jdbcTemplate.update(removeFromSale, saleId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

    }

    private Sale mapRowsToSale(SqlRowSet results) {
        Sale sale = new Sale();

        sale.setSaleId(results.getInt("sale_id"));
        sale.setCustomerId(results.getInt("customer_id"));

        if (results.getDate("sale_date") != null) {
            sale.setSaleDate(results.getDate("sale_date").toLocalDate());
        }

        if (results.getDate("ship_date") != null) {
            sale.setShipDate(results.getDate("ship_date").toLocalDate());
        }

        sale.setCustomerName(results.getString("name"));

        return sale;
    }

    private List<Sale> listSales(SqlRowSet results) {
        List<Sale> sales = new ArrayList<>();

        while (results.next()) {
            sales.add(mapRowsToSale(results));
        }

        return sales;
    }
}
