package com.techelevator.ssgeek.dao;

import com.techelevator.ssgeek.exception.DaoException;
import com.techelevator.ssgeek.model.Product;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

public class JdbcProductDao implements ProductDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcProductDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Product getProductById(int productId) {
        String sql = "SELECT * FROM product WHERE product_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, productId);

        if (results.next()) {
            return mapRowToProduct(results);
        }

        return null;
    }

    @Override
    public List<Product> getProducts() {
        String sql = "SELECT * FROM product ORDER BY product_id;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            return listProducts(results);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

    }

    @Override
    public List<Product> getProductsWithNoSales() {
        String sql = "SELECT * FROM product p " +
                "LEFT OUTER JOIN line_item li ON p.product_id = li.product_id " +
                "WHERE sale_id IS null;";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            return listProducts(results);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

    }

    @Override
    public Product createProduct(Product newProduct) {
        String sql = "INSERT INTO product (name, description, price, image_name) " +
                "VALUES (?, ?, ?, ?) RETURNING product_id;";

        try {
            int newProductId = jdbcTemplate.queryForObject(sql, int.class, newProduct.getName(), newProduct.getDescription(),
                    newProduct.getPrice(), newProduct.getImageName());
            return getProductById(newProductId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

    }

    @Override
    public Product updateProduct(Product updatedProduct) {
        String sql = "UPDATE product SET name = ?, description = ?, price = ?, image_name = ? WHERE product_id = ?;";
        int rows;

        try {
            rows = jdbcTemplate.update(sql, updatedProduct.getName(), updatedProduct.getDescription(),
                    updatedProduct.getPrice(), updatedProduct.getImageName(), updatedProduct.getProductId());

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        if (rows == 0 ) {
            throw new DaoException("Zero rows affected, expected at least one");
        }

        return getProductById(updatedProduct.getProductId());


    }

    @Override
    public int deleteProductById(int productId) {
        String removeFromLineItem = "DELETE FROM line_item WHERE product_id = ?;";
        String removeFromProduct = "DELETE FROM product WHERE product_id = ?;";

        try {
            jdbcTemplate.update(removeFromLineItem, productId);
            return jdbcTemplate.update(removeFromProduct, productId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
    }

    private Product mapRowToProduct(SqlRowSet results) {
        Product product = new Product();

        product.setProductId(results.getInt("product_id"));
        product.setName(results.getString("name"));
        product.setDescription(results.getString("description"));
        product.setPrice(results.getBigDecimal("price"));
        product.setImageName(results.getString("image_name"));

        return product;
    }

    private List<Product> listProducts(SqlRowSet results) {
        List<Product> products = new ArrayList<>();

        while (results.next()) {
            products.add(mapRowToProduct(results));
        }

        return products;
    }
}
