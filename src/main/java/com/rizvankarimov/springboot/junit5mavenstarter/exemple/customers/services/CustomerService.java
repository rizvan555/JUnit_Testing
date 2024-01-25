package com.rizvankarimov.springboot.junit5mavenstarter.exemple.customers.services;

import com.rizvankarimov.springboot.junit5mavenstarter.exemple.customers.dto.Customer;
import com.rizvankarimov.springboot.junit5mavenstarter.exemple.customers.repositories.CustomerRepository;

public class CustomerService {
    private CustomerRepository customerRepository;
    private InfoService infoService;

    // Burada "addYourCustomer" metodunu cagiririq ve elave edirik.
    public void addCustomer(Customer customer){
        customerRepository.addYourCustomer(customer);
        infoService.sendNewCustomAddMail(customer);
    }

    public void deleteCustomer(Integer customerId){
        customerRepository.deleteYourCustomer(customerId);
    }


    // Burada Setter Injection istifade edib "customerRepository" ve "infoService" obyektlerini set edirik.
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    public void setInfoService(InfoService infoService) {
        this.infoService = infoService;
    }
}
