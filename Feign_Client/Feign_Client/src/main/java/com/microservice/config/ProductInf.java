package com.microservice.config;


import com.microservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name="ProductAPI",url="http://localhost:8082")
public interface ProductInf {


    @GetMapping("/getAllProducts")
    public  String getProduct();

    @GetMapping("/getName")
    public  String getName();

    @PostMapping("/crateProduct")
    public Product createProducts(@RequestBody Product product);

    @GetMapping("/getListOfProducts")
    public List<Product> getListOfProducts();


}
