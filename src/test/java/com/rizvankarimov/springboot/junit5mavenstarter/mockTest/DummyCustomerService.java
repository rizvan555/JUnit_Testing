package com.rizvankarimov.springboot.junit5mavenstarter.mockTest;

public interface DummyCustomerService {
    public void addCustomer(String userName);

    public void removeCustomer(String userName);

    public void updateCustomer(String userName);

    public String getCustomer(String userName);
}
