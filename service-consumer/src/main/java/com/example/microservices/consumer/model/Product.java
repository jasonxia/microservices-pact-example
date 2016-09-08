package com.example.microservices.consumer.model;

public class Product {

    private long id;
    private String description;

    public Product() {

    }

    public Product(final long id, final String description) {
        this.id = id;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

}
