package com.rizvankarimov.springboot.junit5mavenstarter.customerTest;

import com.rizvankarimov.springboot.junit5mavenstarter.exemple.customers.dto.Customer;
import com.rizvankarimov.springboot.junit5mavenstarter.exemple.customers.services.CustomerService;
import com.rizvankarimov.springboot.junit5mavenstarter.exemple.customers.services.InfoService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerServiceTest {
    private CustomerService customerService;                                                            // Burada "customerService" obyektini cagiririq.
    private CustomerRepositoryStub customerRepository = new CustomerRepositoryStub();                   // Burada "customerRepository" obyektini cagiririq ve ona Stub elave edirik.
    private InfoService infoService; // Burada "infoService" obyektini cagiririq.


    @BeforeEach
    void setUp() {
         customerService = new CustomerService();                                                       // Burada "customerService" obyektini yaradiriq.
         infoService = Mockito.mock(InfoService.class);                                                 // Burada "infoService" obyektini yaradiriq.

            customerService.setCustomerRepository(customerRepository);                                  // Burada Setter Injection istifade edib "customerRepository" obyektlerini set edirik.
            customerService.setInfoService(infoService);                                                // Burada Setter Injection istifade edib "infoService" obyektlerini set edirik.
    }

    @Test
    public void addCustomerTest(){
        Customer customer = new Customer(1);                                                        // Burada "customer" obyektini yaradiriq.
        customerService.addCustomer(customer);                                                          // Burada "addCustomer" metodunu cagiririq ve elave edirik.

        //Mockito.verify(customerRepository).addYourCustomer(customer);                                 // Burada "customerRepository" obyektinin "addYourCustomer" metodunu cagiririq ve "customer" obyektini gonderirik yoxlayiriq ki, elave edib ya yox.
        //assertTrue(customerRepository.getCustomerList().containsValue(customer));                     // Burada "customerRepository" obyektinin "getCustomerList" metodunu cagiririq ve "customer" obyektini gonderirik yoxlayiriq ki, elave edib ya yox.

        assertEquals(customer,customerRepository.findCustomerById(customer.getId()));                   // Burada "customerRepository" obyektinin "FindCustomerById" metodunu cagiririq ve "customer" obyektini gonderirik yoxlayiriq ki, elave edib ya yox.
        Mockito.verify(infoService).sendNewCustomAddMail(customer);                                     // Burada "infoService" obyektinin "sendNewCustomAddMail" metodunu cagiririq ve "customer" obyektini gonderirik yoxlayiriq ki, elave edib ya yox.
    }

    @Test
    public void deleteCustomerTest(){
        customerRepository.addYourCustomer(new Customer(1));                                          // Burada "customerRepository" obyektinin "addYourCustomer" metodunu cagiririq ki, metodlarin bir birinden xebersiz ishlemesi heyata kecsin, yeni ki, siralama olmasin.
        assertNotNull(customerRepository.findCustomerById(1));                                 // Burada "customerRepository" obyektinin "FindCustomerById" metodunu cagiririq ve "customer" obyektini gonderirik yoxlayiriq ki, bele bir id varmi, ya yox.
        customerService.deleteCustomer(1);                                                     // Burada "deleteCustomer" metodunu cagiririq ve silirik.
        assertNull(customerRepository.findCustomerById(1));                                    // Burada "customerRepository" obyektinin "FindCustomerById" metodunu cagiririq ve "customer" obyektini gonderirik yoxlayiriq ki, silib ya yox.

    }

    @AfterEach
    public void afterEach(){
        customerRepository.deleteAll();
    }
}
