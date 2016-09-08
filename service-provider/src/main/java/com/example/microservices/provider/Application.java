package com.example.microservices.provider;

import com.example.microservices.provider.model.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.example.microservices" })
@RestController
public class Application {

    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable final long id) {
        return new Product(id, "This is the description for product " + id);
    }

    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
