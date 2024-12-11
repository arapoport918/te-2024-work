package com.techelevator.ssgeek.dao;

import com.techelevator.ssgeek.model.LineItem;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sound.sampled.Line;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class JdbcLineItemDaoTests extends BaseDaoTests {

    private static final LineItem LINE_ITEM_1 = new LineItem(1, 1, 1, 1,
            "Product 1", BigDecimal.valueOf(9.99).setScale(2, RoundingMode.HALF_UP));
    private static final LineItem LINE_ITEM_2 = new LineItem(2, 1, 2, 1,
            "Product 2", BigDecimal.valueOf(19.00).setScale(2, RoundingMode.HALF_UP));
    private static final LineItem LINE_ITEM_3 = new LineItem(3, 1, 4, 1,
            "Product 4", BigDecimal.valueOf(0.99).setScale(2, RoundingMode.HALF_UP));
    private static final LineItem LINE_ITEM_4 = new LineItem(4, 2, 4, 10,
            "Product 4", BigDecimal.valueOf(0.99).setScale(2, RoundingMode.HALF_UP));
    private static final LineItem LINE_ITEM_5 = new LineItem(5, 2, 1, 10,
            "Product 1", BigDecimal.valueOf(9.99).setScale(2, RoundingMode.HALF_UP));
    private static final LineItem LINE_ITEM_6 = new LineItem(6, 3, 1, 100,
            "Product 1", BigDecimal.valueOf(9.99).setScale(2, RoundingMode.HALF_UP));

    private JdbcLineItemDao dao;

    @Before
    public void setup() {
        dao = new JdbcLineItemDao(dataSource);
    }

    @Test
    public void getLineItemsBySaleId_returns_list_of_correct_length() {
        List<LineItem> items = dao.getLineItemsBySaleId(1);
        Assert.assertEquals(3, items.size());

        items = dao.getLineItemsBySaleId(2);
        Assert.assertEquals(2, items.size());

        items = dao.getLineItemsBySaleId(3);
        Assert.assertEquals(1, items.size());
    }

    @Test
    public void getLineItemsBySaleId_returns_list_of_valid_values_in_correct_order() {
        List<LineItem> items = dao.getLineItemsBySaleId(1);
        assertLineItemsMatch(LINE_ITEM_1, items.get(0));
        assertLineItemsMatch(LINE_ITEM_2, items.get(1));
        assertLineItemsMatch(LINE_ITEM_3, items.get(2));

        items = dao.getLineItemsBySaleId(2);
        assertLineItemsMatch(LINE_ITEM_4, items.get(0));
        assertLineItemsMatch(LINE_ITEM_5, items.get(1));

        items = dao.getLineItemsBySaleId(3);
        assertLineItemsMatch(LINE_ITEM_6, items.get(0));
    }

    private void assertLineItemsMatch(LineItem expected, LineItem actual) {

        Assert.assertEquals(expected.getLineItemId(), actual.getLineItemId());
        Assert.assertEquals(expected.getSaleId(), actual.getSaleId());
        Assert.assertEquals(expected.getProductId(), actual.getProductId());
        Assert.assertEquals(expected.getQuantity(), actual.getQuantity());
        Assert.assertEquals(expected.getProductName(), actual.getProductName());
        Assert.assertEquals(expected.getPrice(), actual.getPrice());

    }
}
