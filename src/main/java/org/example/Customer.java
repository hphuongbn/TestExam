package org.example;

public class Customer {
    private String name;
    private String customerNumber;
    private String email;

    public Customer(String name, String customerNumber, String email) {
        this.name = name;
        this.customerNumber = customerNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", customerNumber='" + customerNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}