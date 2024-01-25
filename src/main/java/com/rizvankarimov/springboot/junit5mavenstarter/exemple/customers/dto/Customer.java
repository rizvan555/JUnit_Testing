package com.rizvankarimov.springboot.junit5mavenstarter.exemple.customers.dto;

public class Customer {
    private Integer id;

    public Customer(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
