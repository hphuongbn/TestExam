package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerServiceTest {

    private CustomerService customerService;

    @BeforeEach
    void setUp() {
        customerService = new CustomerService();
    }


    @Test
    void testAddCustomerWithUniqueEmail() {
        Customer customer = new Customer("Duke", "C001", "duke@java.org");
        customerService.addCustomer(customer);

        assertEquals(1, customerService.getAllCustomers().size());
        assertEquals("Duke", customerService.getAllCustomers().get(0).getName());
    }

    @Test
    void testEmailIsValid(){
        Customer customer = new Customer("Duke", "C001", "duke.org");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {customerService.addCustomer(customer);});

        assertEquals("Customer email address is incorrect", exception.getMessage());
    }

    @Test
    void testAddCustomerWithDuplicateEmailThrowsException() {
        Customer customer1 = new Customer("Duke", "C001", "duke@java.org");
        Customer customer2 = new Customer("Mike", "C002", "duke@java.org");

        customerService.addCustomer(customer1);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            customerService.addCustomer(customer2);
        });

        assertEquals("Email must be unique", exception.getMessage());
    }

    @Test
    void testGetAllCustomers() {
        Customer customer1 = new Customer("Duke", "C001", "duke@java.org");
        Customer customer2 = new Customer("Mike", "C002", "mike@java.org");

        customerService.addCustomer(customer1);
        customerService.addCustomer(customer2);

        assertEquals(2, customerService.getAllCustomers().size());
    }
}