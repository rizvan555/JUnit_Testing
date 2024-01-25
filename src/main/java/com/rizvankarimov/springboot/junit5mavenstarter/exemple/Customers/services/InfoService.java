package com.rizvankarimov.springboot.junit5mavenstarter.exemple.Customers.services;

import com.rizvankarimov.springboot.junit5mavenstarter.exemple.Customers.Customer;

public class InfoService {
    public void sendNewCustomAddMail(Customer customer){
        System.out.println("New Customer Added Mail Sent");
    }
}
