package com.techelevator.ssgeek.dao;

import com.techelevator.ssgeek.model.Customer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.print.attribute.standard.ColorSupported;
import java.util.ArrayList;
import java.util.List;

public class JdbcCustomerDaoTests extends BaseDaoTests {
    private static final Customer CUSTOMER_1 = new Customer(1, "Customer 1",
            "Addr 1-1", "Addr 1-2", "City 1", "S1", "11111");
    private static final Customer CUSTOMER_2 = new Customer(2, "Customer 2",
            "Addr 2-1", "Addr 2-2", "City 2", "S2", "22222");
    private static final Customer CUSTOMER_3 = new Customer(3, "Customer 3",
            "Addr 3-1", null, "City 3", "S3", "33333");
    private static final Customer CUSTOMER_4 = new Customer(4, "Customer 4",
            "Addr 4-1", null, "City 4", "S4", "44444");
    private final int INVALID_ID = -1;
    private JdbcCustomerDao dao;
    private Customer test;

    @Before
    public void setup() {
        dao = new JdbcCustomerDao(dataSource);
        test = new Customer(0, "Test Customer",
                "Test Address1", "Test Address2", "Test City", "TS", "99999");
    }

    @Test
    public void getCustomerById_with_valid_id_returns_correct_customer() {
        Customer customer1 = dao.getCustomerById(1);
        assertCustomersMatch(CUSTOMER_1, customer1);

        Customer customer2 = dao.getCustomerById(2);
        assertCustomersMatch(CUSTOMER_2, customer2);

        Customer customer3 = dao.getCustomerById(3);
        assertCustomersMatch(CUSTOMER_3, customer3);

        Customer customer4 = dao.getCustomerById(4);
        assertCustomersMatch(CUSTOMER_4, customer4);
    }

    @Test
    public void getCustomerById_with_invalid_id_returns_null_customer() {
        Customer invalidCustomer = dao.getCustomerById(INVALID_ID);
        Assert.assertNull(invalidCustomer);
    }

    @Test
    public void getCustomers_returns_list_of_customers_of_correct_length() {
        List<Customer> customers = dao.getCustomers();
        Assert.assertNotNull(customers);
        Assert.assertEquals(4, customers.size());
    }
    @Test
    public void getCustomers_returns_list_of_customers_in_correct_order() {
        List<Customer> customers = dao.getCustomers();
        Assert.assertNotNull(customers);

        assertCustomersMatch(CUSTOMER_1, customers.get(0));
        assertCustomersMatch(CUSTOMER_2, customers.get(1));
        assertCustomersMatch(CUSTOMER_3, customers.get(2));
        assertCustomersMatch(CUSTOMER_4, customers.get(3));
    }

    @Test
    public void createCustomer_creates_a_new_customer() {
        Customer createdCustomer = dao.createCustomer(test);
        Assert.assertNotNull(createdCustomer);

        int newCustomerId = createdCustomer.getCustomerId();
        Assert.assertTrue(newCustomerId > 0);

        Customer retrievedCustomer = dao.getCustomerById(newCustomerId);
        assertCustomersMatch(createdCustomer, retrievedCustomer);
    }

    @Test
    public void updateCustomer_updates_an_existing_customer() {
        Customer customerToUpdate = dao.getCustomerById(CUSTOMER_1.getCustomerId());

        customerToUpdate.setName("Updated Customer");
        customerToUpdate.setStreetAddress1("Updated St");
        customerToUpdate.setStreetAddress2(null);
        customerToUpdate.setCity("Updated City");
        customerToUpdate.setState("UC");
        customerToUpdate.setZipCode("00001");

        Customer updatedCustomer = dao.updateCustomer(customerToUpdate);

        Customer retrievedCustomer = dao.getCustomerById(CUSTOMER_1.getCustomerId());
        assertCustomersMatch(updatedCustomer, retrievedCustomer);
    }

    private void assertCustomersMatch(Customer expected, Customer actual) {
        Assert.assertEquals(expected.getCustomerId(), actual.getCustomerId());
        Assert.assertEquals(expected.getName(), actual.getName());
        Assert.assertEquals(expected.getStreetAddress1(), actual.getStreetAddress1());
        Assert.assertEquals(expected.getStreetAddress2(), actual.getStreetAddress2());
        Assert.assertEquals(expected.getCity(), actual.getCity());
        Assert.assertEquals(expected.getState(), actual.getState());
        Assert.assertEquals(expected.getZipCode(), actual .getZipCode());
    }

}
