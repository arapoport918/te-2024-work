package com.techelevator.ssgeek.dao;

import com.techelevator.ssgeek.model.Customer;
import com.techelevator.ssgeek.model.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.image.renderable.RenderableImage;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class JdbcProductDaoTests extends BaseDaoTests {
    private static final Product PRODUCT_1 = new Product(1, "Product 1",
            "Description 1",   BigDecimal.valueOf(9.99).setScale(2, RoundingMode.HALF_UP), "product-1.png");
    private static final Product PRODUCT_2 = new Product(2, "Product 2",
            "Description 2",   BigDecimal.valueOf(19.00).setScale(2, RoundingMode.HALF_UP), "product-2.png");
    private static final Product PRODUCT_3 = new Product(3, "Product 3",
            "Description 3",   BigDecimal.valueOf(123.45).setScale(2, RoundingMode.HALF_UP), "product-3.png");
    private static final Product PRODUCT_4 = new Product(4, "Product 4",
            "Description 4",   BigDecimal.valueOf(0.99).setScale(2, RoundingMode.HALF_UP), "product-4.png");
    private final int INVALID_ID = -1;
    private JdbcProductDao dao;
    private Product test;

    @Before
    public void setup() {
        dao = new JdbcProductDao(dataSource);
        test = new Product(0, "Test Product",
                "Test Description", BigDecimal.valueOf(0.01), "product-test.png");
    }

    @Test
    public void getProductById_with_valid_id_returns_correct_customer() {
        Product product1 = dao.getProductById(1);
        assertProductsMatch(PRODUCT_1, product1);

        Product product2 = dao.getProductById(2);
        assertProductsMatch(PRODUCT_2, product2);

        Product product3 = dao.getProductById(3);
        assertProductsMatch(PRODUCT_3, product3);

        Product product4 = dao.getProductById(4);
        assertProductsMatch(PRODUCT_4, product4);
    }

    @Test
    public void getProductById_with_invalid_id_returns_null_customer() {
        Product invalidProduct = dao.getProductById(INVALID_ID);
        Assert.assertNull(invalidProduct);
    }

    @Test
    public void getProducts_returns_list_of_customers_of_correct_length() {
        List<Product> products = dao.getProducts();
        Assert.assertNotNull(products);
        Assert.assertEquals(4, products.size());
    }
    @Test
    public void getProducts_returns_list_of_customers_in_correct_order() {
        List<Product> products = dao.getProducts();
        Assert.assertNotNull(products);

        assertProductsMatch(PRODUCT_1, products.get(0));
        assertProductsMatch(PRODUCT_2, products.get(1));
        assertProductsMatch(PRODUCT_3, products.get(2));
        assertProductsMatch(PRODUCT_4, products.get(3));
    }

    @Test
    public void getProductsWithNoSales_returns_correct_list_length_of_products_where_sale_id_is_null() {
        List<Product> noSalesProducts = dao.getProductsWithNoSales();
        Assert.assertEquals(1, noSalesProducts.size());
    }

    @Test
    public void getProductsWithNoSales_returns_correct_list_order_of_products_where_sale_id_is_null() {
        List<Product> noSalesProducts = dao.getProductsWithNoSales();
        assertProductsMatch(PRODUCT_3, noSalesProducts.get(0));
    }

    @Test
    public void createProduct_creates_a_new_product() {
        Product createdProduct = dao.createProduct(test);
        Assert.assertNotNull(createdProduct);

        int newCustomerId = createdProduct.getProductId();
        Assert.assertTrue(newCustomerId > 0);

        Product retrievedProduct = dao.getProductById(newCustomerId);
        assertProductsMatch(createdProduct, retrievedProduct);
    }

    @Test
    public void updateProduct_updates_an_existing_product() {
        Product productToUpdate = dao.getProductById(PRODUCT_1.getProductId());

        productToUpdate.setName("Updated Product");
        productToUpdate.setDescription("Updated Description");
        productToUpdate.setPrice(BigDecimal.valueOf(100.00));
        productToUpdate.setImageName("Updated-Image.png");

        Product updatedProduct = dao.updateProduct(productToUpdate);

        Product retrievedProduct = dao.getProductById(PRODUCT_1.getProductId());
        assertProductsMatch(updatedProduct, retrievedProduct);
    }

    @Test
    public void deleteProductById_deletes_product_when_given_valid_id() {
        int rows = dao.deleteProductById(1);
        Assert.assertEquals(1, rows);
        Product product = dao.getProductById(1);
        Assert.assertNull(product);
    }

    private void assertProductsMatch(Product expected, Product actual) {
        Assert.assertEquals(expected.getProductId(), actual.getProductId());
        Assert.assertEquals(expected.getName(), actual.getName());
        Assert.assertEquals(expected.getDescription(), actual.getDescription());
        Assert.assertEquals(expected.getPrice(), actual.getPrice());
        Assert.assertEquals(expected.getImageName(), actual.getImageName());
    }

}
