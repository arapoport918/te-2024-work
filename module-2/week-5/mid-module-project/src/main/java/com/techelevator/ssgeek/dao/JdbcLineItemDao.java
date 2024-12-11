package com.techelevator.ssgeek.dao;

import com.techelevator.ssgeek.exception.DaoException;
import com.techelevator.ssgeek.model.LineItem;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcLineItemDao implements LineItemDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcLineItemDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public List<LineItem> getLineItemsBySaleId(int saleId) {
        String sql = "SELECT li.line_item_id, li.sale_id, li.product_id, li.quantity, p.name, p.price " +
                "FROM line_item li " +
                "JOIN product p ON li.product_id = p.product_id " +
                "WHERE li.sale_id = ?" +
                "ORDER BY li.line_item_id;";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, saleId);
            return listLineItems(results);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to database or server", e);
        }

    }

    private LineItem mapRowToLineItem(SqlRowSet results) {
        LineItem lineItem = new LineItem();

        lineItem.setLineItemId(results.getInt("line_item_id"));
        lineItem.setSaleId(results.getInt("sale_id"));
        lineItem.setProductId(results.getInt("product_id"));
        lineItem.setQuantity(results.getInt("quantity"));
        lineItem.setProductName(results.getString("name"));
        lineItem.setPrice(results.getBigDecimal("price"));

        return lineItem;
    }

    private List<LineItem> listLineItems(SqlRowSet results) {
        List<LineItem> lineItems = new ArrayList<>();

        while (results.next()) {
            lineItems.add(mapRowToLineItem(results));
        }

        return lineItems;
    }
}
