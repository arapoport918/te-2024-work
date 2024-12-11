package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Product;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcProductDao implements ProductDao {
    private final JdbcTemplate jdbcTemplate;
    private final String SQL_STATEMENT_BASE = "SELECT product_id, product_sku, name, description, price, image_name " +
            "FROM product ";

    public JdbcProductDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Product> getProducts() {
        String sql = SQL_STATEMENT_BASE + ";";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            return listProducts(results);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Cannot connect to server or database.", e);
        }
    }

    @Override
    public List<Product> searchProductBySkuAndName(String sku, String name) {
        String sql = SQL_STATEMENT_BASE + "WHERE product_sku ILIKE ? AND name ILIKE ?;";

        if (sku != null) {
            sku = "%" + sku + "%";
        }

        if (name != null) {
            name = "%" + name + "%";
        }

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, sku, name);
            if (results.next()) {
                return listProducts(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Cannot connect to server or database.", e);
        }

        return null;
    }

    @Override
    public List<Product> searchProductBySku(String sku) {
        String sql = SQL_STATEMENT_BASE + "WHERE product_sku ILIKE ?;";

        if (sku != null) {
            sku = "%" + sku + "%";
        }

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, sku);
            if (results.next()) {
                return listProducts(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Cannot connect to server or database.", e);
        }

        return null;
    }

    @Override
    public List<Product> searchProductByName(String name) {
        String sql = SQL_STATEMENT_BASE + "WHERE name ILIKE ?;";

        if (name != null) {
            name = "%" + name + "%";
        }

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, name);

            if (results.next()) {
                return listProducts(results);
            }

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Cannot connect to server or database.", e);
        }

        return null;
    }

    @Override
    public Product getProductById(int id) {
        String sql = SQL_STATEMENT_BASE + "WHERE product_id = ?";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql,id);

            if (results.next()) {
                return map(results);
            }

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Cannot connect to server or database.", e);
        }

        return null;
    }

    private Product map(SqlRowSet results) {
        Product product = new Product();

        product.setProductId(results.getInt("product_id"));
        product.setProductSku(results.getString("product_sku"));
        product.setName(results.getString("name"));
        product.setDescription(results.getString("description"));
        product.setPrice(results.getBigDecimal("price").setScale(2, RoundingMode.HALF_UP));
        product.setImageName(results.getString("image_name"));

        return product;
    }

    private List<Product> listProducts(SqlRowSet results) {
        List<Product> productList = new ArrayList<>();

        while (results.next()) {
            productList.add(map(results));
        }

        return productList;
    }

    private String sqlStringTransformForSearch(String term) {
        if (term != null) {
            return "%" + term + "%";
        }
        return "";
    }
}
