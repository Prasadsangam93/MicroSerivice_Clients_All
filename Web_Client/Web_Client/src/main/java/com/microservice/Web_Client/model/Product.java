package com.microservice.Web_Client.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Product {


    private  Long id;

    private String name;

    private Double price;
}
