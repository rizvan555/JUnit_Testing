package com.rizvankarimov.springboot.junit5mavenstarter.mockTest;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.*;

public class BehaviorTest {
    //Bu adlarla userlerin cagirilmasini yoxlayiriq
    @Test
    void testBehavior() {
        DummyCustomerService customerService = mock(DummyCustomerService.class);

        customerService.addCustomer("Rizvan");
        customerService.addCustomer("Fateh");

        verify(customerService).addCustomer("Rizvan");
        verify(customerService).addCustomer("Fateh");
    }


    //Her userin nece defe cagirildigini yoxlayiriq
    @Test
    void howManyTimeCalledName() {
        DummyCustomerService customerService = mock(DummyCustomerService.class);

        customerService.addCustomer("Rizvan");
        customerService.addCustomer("Rizvan");
        customerService.addCustomer("Rizvan");
        customerService.addCustomer("Fateh");

        verify(customerService,times(3)).addCustomer("Rizvan");
        verify(customerService,times(1)).addCustomer("Fateh");

        //removeCustomer methodu cagirilmayib
        verify(customerService,never()).removeCustomer(anyString());
        verify(customerService,never()).addCustomer("Fatima"); //hec bir defe cagirilmayib

        //en azi bir defe cagirilib
        verify(customerService, atLeast(1)).addCustomer("Fateh");
    }


    //cagirilan userlerin ardiclliq sirasini yoxlayiriq
    @Test
    void whichSequenceName() {
        DummyCustomerService customerService = mock(DummyCustomerService.class);
        customerService.addCustomer("Rizvan");
        customerService.addCustomer("Fateh");
        customerService.updateCustomer("Fatima");

        InOrder inOrder = inOrder(customerService);

        inOrder.verify(customerService).addCustomer("Rizvan");      //1
        inOrder.verify(customerService).addCustomer("Fateh");       //2
        inOrder.verify(customerService).updateCustomer("Fatima");   //3
    }


    //Yalniz verilen metodlar olsun, basqalari olmasin
    @Test
    void norMoreAnotherTest() {
        DummyCustomerService customerService = mock(DummyCustomerService.class);
        customerService.addCustomer("Rizvan");
        customerService.addCustomer("Fateh");

        verify(customerService).addCustomer("Rizvan");
        verify(customerService).removeCustomer("Fateh");

        verifyNoMoreInteractions(customerService); //basqa cagirilan methodlar olmasin
    }
}
