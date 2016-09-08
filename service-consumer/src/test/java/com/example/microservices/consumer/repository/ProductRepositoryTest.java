package com.example.microservices.consumer.repository;

import au.com.dius.pact.consumer.*;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.PactFragment;
import org.junit.Rule;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ProductRepositoryTest {

    @Rule
    public PactProviderRule mockProvider = new PactProviderRule("Product_Provider", "localhost", 8080, this);

    @Pact(provider="Product_Provider", consumer="Product_Consumer")
    public PactFragment createFragment(PactDslWithProvider builder) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json;charset=UTF-8");

        return builder.uponReceiving("a request for Products")
                .path("/products/1")
                .method("GET")
                .willRespondWith()
                .headers(headers)
                .status(200)
                .body("{\"id\":1,\"description\":\"This is the description for product 1\"}")
                .toFragment();
    }

    @Test
    @PactVerification("Product_Provider")
    public void runTest() {
        assertEquals(new ProductRepository("http://localhost:8080").fetchProduct(1).getId(), 1);
    }
}