package com.rizvankarimov.springboot.junit5mavenstarter;

import com.rizvankarimov.springboot.junit5mavenstarter.exemple.Customers.Customer;
import com.rizvankarimov.springboot.junit5mavenstarter.exemple.Customers.CustomerRepository;
import com.rizvankarimov.springboot.junit5mavenstarter.exemple.Customers.services.CustomerService;
import com.rizvankarimov.springboot.junit5mavenstarter.exemple.Customers.services.InfoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class CustomerServiceTest {
    private CustomerService customerService; // Burada "customerService" obyektini cagiririq.
    private CustomerRepository customerRepository; // Burada "customerRepository" obyektini cagiririq.
    private InfoService infoService; // Burada "infoService" obyektini cagiririq.
    @BeforeEach
    void setUp() {
         customerService = new CustomerService(); // Burada "customerService" obyektini yaradiriq.
         customerRepository = Mockito.mock(CustomerRepository.class);  // Burada "customerRepository" obyektini yaradiriq.
         infoService = Mockito.mock(InfoService.class); // Burada "infoService" obyektini yaradiriq.

            customerService.setCustomerRepository(customerRepository); // Burada Setter Injection istifade edib "customerRepository" obyektlerini set edirik.
            customerService.setInfoService(infoService); // Burada Setter Injection istifade edib "infoService" obyektlerini set edirik.
    }

    @Test
    public void addCustomerTest(){
        Customer customer = new Customer(); // Burada "customer" obyektini yaradiriq.
        customerService.addCustomer(customer); // Burada "addCustomer" metodunu cagiririq ve elave edirik.

        Mockito.verify(customerRepository).addYourCustomer(customer); //Burada "customerRepository" obyektinin "addYourCustomer" metodunu cagiririq ve "customer" obyektini gonderirik yoxlayiriq ki, elave edib ya yox.
        Mockito.verify(infoService).sendNewCustomAddMail(customer); //Burada "infoService" obyektinin "sendNewCustomAddMail" metodunu cagiririq ve "customer" obyektini gonderirik yoxlayiriq ki, elave edib ya yox.
    }
}
