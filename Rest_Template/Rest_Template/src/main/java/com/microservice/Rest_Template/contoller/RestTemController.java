package com.microservice.Rest_Template.contoller;


import com.microservice.Rest_Template.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RestTemController{

    @Lazy
    @Autowired
    private RestTemplate res;

    @GetMapping("/getProdRest")
    public  String getAllProduct(){
        return  res.getForObject("http://localhost:8082/getAllProducts", String.class);
    }

    @GetMapping("/getNamRest")
    public  String getName(){
        return res.getForObject("http://localhost:8082/getName", String.class);
    }

    @PostMapping("/postProduct")
    public Product saveProduct(@RequestBody Product  product) {
        return res.postForObject("http://localhost:8082/createProduct", product, Product.class);

    }

    @GetMapping("/getProdAll")
    public List<Product> getAllProducts() {
        return res.getForObject("http://localhost:8082/getListOfProducts", ArrayList.class);


    }
    @Bean
    private RestTemplate restTemplate(){
        return new RestTemplate();
    }



}
