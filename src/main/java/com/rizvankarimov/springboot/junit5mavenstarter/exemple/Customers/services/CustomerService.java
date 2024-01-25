package com.rizvankarimov.springboot.junit5mavenstarter.exemple.Customers.services;

import com.rizvankarimov.springboot.junit5mavenstarter.exemple.Customers.Customer;
import com.rizvankarimov.springboot.junit5mavenstarter.exemple.Customers.CustomerRepository;

public class CustomerService {
    private CustomerRepository customerRepository;
    private InfoService infoService;

    // Burada "addYourCustomer" metodunu cagiririq ve elave edirik.
    public void addCustomer(Customer customer){
        customerRepository.addYourCustomer(customer);
        infoService.sendNewCustomAddMail(customer);
    }



    // Burada Setter Injection istifade edib "customerRepository" ve "infoService" obyektlerini set edirik.
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    public void setInfoService(InfoService infoService) {
        this.infoService = infoService;
    }
}
