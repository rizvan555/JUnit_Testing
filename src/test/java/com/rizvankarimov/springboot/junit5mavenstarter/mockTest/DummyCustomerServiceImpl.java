package com.rizvankarimov.springboot.junit5mavenstarter.mockTest;

public class DummyCustomerServiceImpl implements DummyCustomerService {
    @Override
    public void addCustomer(String customerName){
        System.out.println("addCustomer("+customerName +")");
    }

    @Override
    public void removeCustomer(String userName) {
        System.out.println("removeCustomer("+userName +")");
    }

    @Override
    public void updateCustomer(String userName) {
        System.out.println("updateCustomer("+userName +")");
    }

    @Override
    public String getCustomer(String userName) {
        return "getCustomer("+userName +")";
    }
}
