package com.example.microservices.consumer.repository;

import com.example.microservices.consumer.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProductRepository {
    private String url;

    @Autowired
    public ProductRepository(@Value("${product.provider}") String url) {
        this.url = url;
    }

    public Product fetchProduct(int id) {
        return new RestTemplate().getForObject(url + "/products/" + id,
                Product.class);


    }

}
