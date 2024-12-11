package com.techelevator.ssgeek.dao;

import com.techelevator.ssgeek.model.Product;
import com.techelevator.ssgeek.model.Sale;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.List;

public class JdbcSaleDaoTests extends BaseDaoTests {

    private static final Sale SALE_1 = new Sale(1, 1, LocalDate.parse("2022-01-01"),
            null, "Customer 1");
    private static final Sale SALE_2 = new Sale(2, 1, LocalDate.parse("2022-02-01"),
            LocalDate.parse("2022-02-02"), "Customer 1");
    private static final Sale SALE_3 = new Sale(3, 2, LocalDate.parse("2022-03-01"),
            null, "Customer 2");
    private static final Sale SALE_4 = new Sale(4, 2, LocalDate.parse("2022-01-01"),
            LocalDate.parse("2022-01-02"), "Customer 2");
    private final int INVALID_ID = -1;
    private JdbcSaleDao dao;
    private Sale test;

    @Before
    public void setup() {
        dao = new JdbcSaleDao(dataSource);
        test = new Sale(0, 3, LocalDate.parse("2024-01-01"), LocalDate.parse("2024-01-10"), "Test Customer");
    }
    @Test
    public void getSaleById_with_valid_id_returns_correct_sale() {
        Sale sale1 = dao.getSaleById(1);
        assertSalesMatch(SALE_1, sale1);

        Sale sale2 = dao.getSaleById(2);
        assertSalesMatch(SALE_2, sale2);

        Sale sale3 = dao.getSaleById(3);
        assertSalesMatch(SALE_3, sale3);

        Sale sale4 = dao.getSaleById(4);
        assertSalesMatch(SALE_4, sale4);
    }

    @Test
    public void getSaleById_with_invalid_id_returns_null_sale() {
        Sale invalidSale = dao.getSaleById(INVALID_ID);
        Assert.assertNull(invalidSale);
    }

    @Test
    public void getUnshippedSales_returns_correct_number_of_unshipped_orders() {
        List<Sale> sales = dao.getUnshippedSales();
        Assert.assertEquals(2, sales.size());
    }

    @Test
    public void getUnshippedSales_returns_unshipped_sales_in_correct_order() {
        List<Sale> sales = dao.getUnshippedSales();
        assertSalesMatch(SALE_1, sales.get(0));
        assertSalesMatch(SALE_3, sales.get(1));
    }

    @Test
    public void getSalesByCustomerId_returns_correct_number_of_orders_for_given_customerId() {
        List<Sale> sales = dao.getSalesByCustomerId(1);
        Assert.assertEquals(2, sales.size());

        sales = dao.getSalesByCustomerId(2);
        Assert.assertEquals(2, sales.size());
    }

    @Test
    public void getSalesByCustomerId_returns_sales_for_a_given_customer_in_correct_order() {
        List<Sale> sales = dao.getSalesByCustomerId(1);
        assertSalesMatch(SALE_1, sales.get(0));
        assertSalesMatch(SALE_2, sales.get(1));

        sales = dao.getSalesByCustomerId(2);
        assertSalesMatch(SALE_3, sales.get(0));
        assertSalesMatch(SALE_4, sales.get(1));
    }

    @Test
    public void getSalesByProductId_returns_correct_number_of_orders_for_given_productId() {
        List<Sale> sales = dao.getSalesByProductId(1);
        Assert.assertEquals(3, sales.size());

        sales = dao.getSalesByProductId(2);
        Assert.assertEquals(1, sales.size());

        sales = dao.getSalesByProductId(3);
        Assert.assertEquals(0, sales.size());

        sales = dao.getSalesByProductId(4);
        Assert.assertEquals(2, sales.size());
    }

    @Test
    public void getSalesByProductId_returns_sales_for_a_given_product_in_correct_order() {
        List<Sale> sales = dao.getSalesByProductId(1);
        assertSalesMatch(SALE_1, sales.get(0));
        assertSalesMatch(SALE_2, sales.get(1));
        assertSalesMatch(SALE_3, sales.get(2));

        sales = dao.getSalesByProductId(2);
        assertSalesMatch(SALE_1, sales.get(0));

        sales = dao.getSalesByProductId(4);
        assertSalesMatch(SALE_1, sales.get(0));
        assertSalesMatch(SALE_2, sales.get(1));
    }

    @Test
    public void createSale_creates_a_new_sale() {
        Sale createdSale = dao.createSale(test);
        Assert.assertNotNull(createdSale);

        int newSaleId = createdSale.getSaleId();
        Assert.assertTrue(newSaleId > 0);

        Sale retrievedSale = dao.getSaleById(newSaleId);
        assertSalesMatch(createdSale, retrievedSale);
    }

    @Test
    public void updateSale_updates_an_existing_sale() {
        Sale saleToUpdate = dao.getSaleById(SALE_1.getSaleId());

        saleToUpdate.setCustomerId(2);
        saleToUpdate.setSaleDate(LocalDate.parse("2024-01-01"));
        saleToUpdate.setShipDate(LocalDate.parse("2024-01-06"));
        saleToUpdate.setCustomerName("Updated Name");

        Sale updatedSale = dao.updateSale(saleToUpdate);

        Sale retrievedSale = dao.getSaleById(SALE_1.getSaleId());
        assertSalesMatch(updatedSale, retrievedSale);
    }

    @Test
    public void deleteSaleById_deletes_sale_with_valid_id() {
        int rows = dao.deleteSaleById(1);
        Assert.assertEquals(1, rows);

        Sale sale = dao.getSaleById(1);
        Assert.assertNull(sale);
    }


    private void assertSalesMatch(Sale expected, Sale actual) {
        Assert.assertEquals(expected.getSaleId(), actual.getSaleId());
        Assert.assertEquals(expected.getCustomerId(), actual.getCustomerId());
        Assert.assertEquals(expected.getSaleDate(), actual.getSaleDate());
        Assert.assertEquals(expected.getShipDate(), actual.getShipDate());
        Assert.assertEquals(expected.getCustomerName(), actual.getCustomerName());
    }

}
