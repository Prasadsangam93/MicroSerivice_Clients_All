package com.microservice.controller;

import com.microservice.config.ProductInf;
import com.microservice.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FeignController {

    @Autowired

    private ProductInf productInf;
    @GetMapping("/getProductAll")
    public String getProducts(){
        return productInf.getProduct();
    }
    @GetMapping("/getNames")
    public  String getName( ){
        return  productInf.getName();
    }

    @PostMapping("/saveProduct")
    public Product createProducts(@RequestBody Product product){
        return  productInf.createProducts(product);
    }

    @GetMapping("/getAllProd")
    public List<Product> getAllProducts(){
        return productInf.getListOfProducts();
    }









}
