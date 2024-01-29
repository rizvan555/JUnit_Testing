package com.rizvankarimov.springboot.junit5mavenstarter.mockTest;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class SpyTest {

    // Burada spy ile heqiqi obyektin metodlarini(addCustomer) cagiririq
    @Test
    void testSpy() {
        DummyCustomerService service = spy(new DummyCustomerServiceImpl());
        service.addCustomer("Rizvan");
    }


    // Burada spy ile bir metodun davranisini deyisirik
    @Test
    void testSpyChange() {
        DummyCustomerService service = spy(new DummyCustomerServiceImpl());
        doNothing().when(service).addCustomer("Rizvan"); // burada deyirik ki, "addCustomer: Rizvan" yazilmayacaq

        service.addCustomer("Rizvan");  //burada artiq yuxarida testdeki kimi, "addCustomer: Rizvan" yazilmayaca
    }

    // Remove cagirdigimizda hata vermesini isteyirik
    @Test
    void testSpyChangeWhenCallRemoveCustomer() {
        DummyCustomerService service = spy(new DummyCustomerServiceImpl());
        doThrow(new IllegalArgumentException()).when(service).removeCustomer(anyString());

        //service.removeCustomer("*****");

        doNothing().when(service).removeCustomer("Rizvan1");
        doNothing().when(service).removeCustomer("Rizvan2");
        doCallRealMethod().when(service).removeCustomer("Rizvan3"); // burada real methodu cagirir

        service.removeCustomer("Rizvan1");
        service.removeCustomer("Rizvan2");
        service.removeCustomer("Rizvan3"); // burada real methodu cagirir

        //Burada biz demek istedik ki, "Rizvan3" cagirilinca bu dogrudur demekdir ve bize yalniz o halda "Rizvan3" cixar.
    }
}

