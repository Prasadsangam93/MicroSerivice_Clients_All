package com.microservice.controller;


import com.microservice.entity.Product;
import com.microservice.repository.ProductRepository;
import com.microservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/getAllProducts")
    public  String getProduct(){
        return  "Mobile \nIphone \nLaptop";
    }

    @GetMapping("/getName")
    public  String getName(){
        return " i am product microservice";
    }

    @PostMapping("/createProduct")
    public Product createProducts(@RequestBody Product  product){
        return productService.createProduct(product);
    }

    @GetMapping("/getListOfProducts")
    public List<Product> getListOfProducts(){
        return productService.getAllProducts();

    }


}
