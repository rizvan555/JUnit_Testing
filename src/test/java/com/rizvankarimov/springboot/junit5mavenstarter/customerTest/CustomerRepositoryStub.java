package com.rizvankarimov.springboot.junit5mavenstarter.customerTest;

import com.rizvankarimov.springboot.junit5mavenstarter.exemple.customers.dto.Customer;
import com.rizvankarimov.springboot.junit5mavenstarter.exemple.customers.repositories.CustomerRepository;

import java.util.HashMap;
import java.util.Map;

public class CustomerRepositoryStub extends CustomerRepository {

    private final Map<Integer,Customer> customerList = new HashMap<Integer,Customer>(); // Müsterileri saxlamaq ücün ArrayList yaradiriq
    @Override
    public void addYourCustomer(Customer customer) {
        customerList.put(customer.getId(), customer);
    }

    @Override
    public void deleteYourCustomer(Integer customerId) {
        customerList.remove(customerId);
    }

    @Override
    public Customer findCustomerById(Integer customerId) {
        return customerList.get(customerId);
    }

    public void deleteAll(){
        customerList.clear();
    }
}
