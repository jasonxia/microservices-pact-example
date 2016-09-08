package com.example.microservices.provider.model;

public class Product {

    private final long id;
    private final String description;

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
