package com.microservice.Web_Client.controller;

import com.microservice.Web_Client.model.Product;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;

@RestController
public class WebController {

    private WebClient webClient;

    public WebController() {
        this.webClient = WebClient.create("http://localhost:8082/");

    }

    // Non-synchronized  non-blocking
    @GetMapping("getAllProd")
    public Mono<String> getAllProds() {
        return webClient.get()
                .uri("/getAllProducts")
                .retrieve()
                .bodyToMono(String.class);

    }

    // Non-synchronized  non-blocking
    @GetMapping("getName")
    public Flux<String> getName() {
        return webClient.get()
                .uri("/getName")
                .retrieve()
                .bodyToFlux(String.class);

    }


    //same as restTemplate synchronized
    @GetMapping("getAllProdSyn")
    public String getAllProducts() {
        return webClient.get()
                .uri("/getAllProducts")
                .retrieve()
                .bodyToMono(String.class)
                .block();

    }
    @PostMapping("/postProducts")
    public Mono<Product> saveProducts(@RequestBody Product product) {
        return webClient.post()
                .uri("/createProduct")
                .contentType(MediaType.APPLICATION_JSON)  // Set the Content-Type to application/json
                .body(Mono.just(product), Product.class)
                .retrieve()
                .bodyToMono(Product.class);




}

    @GetMapping("/geAllProducts")
    public Mono<ArrayList> getProductsAll() {
        return webClient.get()
                .uri("/getListOfProducts")
                .retrieve()
                .bodyToMono(ArrayList.class);
    }
}