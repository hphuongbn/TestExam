package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerService {
    private List<Customer> customers = new ArrayList<>();

    public void addCustomer(Customer customer) {
        if (!isEmailValid(customer.getEmail())) {
            throw new IllegalArgumentException("Customer email address is invalid");
        }
        else if (isEmailUnique(customer.getEmail())) {
            customers.add(customer);
        } else {
            throw new IllegalArgumentException("Email must be unique");
        }
    }

    public List<Customer> getAllCustomers() {
        return customers;
    }

    private boolean isEmailUnique(String email) {
        return customers.stream().noneMatch(c -> c.getEmail().equals(email));
    }

    private boolean isEmailValid(String email) {
        Pattern pattern = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }
}
