package com.example.microservices.consumer;

import com.example.microservices.consumer.repository.ProductRepository;
import com.example.microservices.consumer.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.example.microservices"})
@RestController
public class Application {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value = "/orders/{id}", method = RequestMethod.GET)
    public Order fetchProductPrice(@PathVariable final long id) {
        int productId = 1;
        return new Order(id, "Sample Order", productRepository.fetchProduct(productId));

    }

    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
