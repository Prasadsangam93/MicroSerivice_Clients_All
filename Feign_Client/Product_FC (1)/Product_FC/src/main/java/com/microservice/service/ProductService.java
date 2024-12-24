package com.microservice.service;


import com.microservice.entity.Product;

import java.util.List;

public interface ProductService {


    Product createProduct(Product product);

    List<Product> getAllProducts();
}