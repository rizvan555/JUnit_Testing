package com.rizvankarimov.springboot.junit5mavenstarter.exemple.customers.repositories;

import com.rizvankarimov.springboot.junit5mavenstarter.exemple.customers.dto.Customer;

import java.util.Map;

public abstract class CustomerRepository {
    public void addYourCustomer(Customer customer){
        System.out.println("Customer Added");
    }

    public void deleteYourCustomer(Integer customer) {
        System.out.println("Customer Deleted");
    }

    public Customer findCustomerById(Integer customerId){
        System.out.println("Customer Found");
        return null;
    }
}
