package com.example.microservices.consumer.model;

public class Order {

    private final long id;

    private final String name;
    private final String productDescription;

    public Order(final long id, final String name, final Product product) {
        this.id = id;
        this.name = name;
        this.productDescription = product.getDescription();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getProductDescription() {
        return productDescription;
    }

}
