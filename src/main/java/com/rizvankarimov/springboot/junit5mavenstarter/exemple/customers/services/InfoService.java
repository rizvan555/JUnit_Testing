package com.rizvankarimov.springboot.junit5mavenstarter.exemple.customers.services;

import com.rizvankarimov.springboot.junit5mavenstarter.exemple.customers.dto.Customer;

public class InfoService {


    public void sendNewCustomAddMail(Customer customer){
        System.out.println("New Customer Added Mail Sent");
    }
}
