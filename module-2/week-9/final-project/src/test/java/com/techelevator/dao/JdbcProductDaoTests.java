package com.techelevator.dao;

import com.techelevator.model.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class JdbcProductDaoTests extends BaseDaoTests {
    private static final Product PRODUCT_1 = new Product(1, "104", "Product 1", "Description 1", BigDecimal.valueOf(19.99).setScale(2, RoundingMode.HALF_UP), "image-1");
    private static final Product PRODUCT_2 = new Product(2, "200", " Test Product 2", "Description 2", BigDecimal.valueOf(100).setScale(2, RoundingMode.HALF_UP), "image-2");
    private static final Product PRODUCT_3 = new Product(3, "340", "Product 3", "Description 3", BigDecimal.valueOf(5.69).setScale(2, RoundingMode.HALF_UP), "image-3");
    private static final Product PRODUCT_4 = new Product(4, "400", " Test Product 4", "Description 4", BigDecimal.valueOf(42.00).setScale(2, RoundingMode.HALF_UP), "image-4");
    private JdbcProductDao dao;

    @Before
    public void setup() {
        dao = new JdbcProductDao(dataSource);
    }

    @Test
    public void getProducts_returns_all_products() {
        List<Product> products = dao.getProducts();


    }

    @Test
    public void getProductById_returns_correct_product_when_given_valid_id() {
        Product product = dao.getProductById(1);
        compareProducts(PRODUCT_1, product);

        product = dao.getProductById(2);
        compareProducts(PRODUCT_2, product);

        product = dao.getProductById(3);
        compareProducts(PRODUCT_3, product);

        product = dao.getProductById(4);
        compareProducts(PRODUCT_4, product);
    }

    @Test
    public void getProductById_returns_null_when_given_invalid_id() {
        Product invalidProduct = dao.getProductById(0);
        Assert.assertNull(invalidProduct);
    }

    @Test
    public void searchProductBySkuAndName_returns_correct_products_when_given_both_parameters() {
        List<Product> test = dao.searchProductBySkuAndName("4", "test");
    }

    @Test
    public void searchProductBySku_returns_correct_products_when_sku_similarity_found() {
        List<Product> product = dao.searchProductBySku("4");
    }

    @Test
    public void searchProductByName_returns_correct_products_when_name_similarity_found() {
        List<Product> product = dao.searchProductBySku("test");
        product = dao.searchProductBySku("oduct");
    }

    private void compareProducts(Product expected, Product actual) {
        Assert.assertEquals(expected.getProductId(), actual.getProductId());
        Assert.assertEquals(expected.getProductSku(), actual.getProductSku());
        Assert.assertEquals(expected.getName(), actual.getName());
        Assert.assertEquals(expected.getDescription(), actual.getDescription());
        Assert.assertEquals(expected.getPrice(), actual.getPrice());
        Assert.assertEquals(expected.getImageName(), actual.getImageName());
    }

}
