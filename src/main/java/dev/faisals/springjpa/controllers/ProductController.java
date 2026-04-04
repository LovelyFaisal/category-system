package dev.faisals.springjpa.controllers;

import dev.faisals.springjpa.entities.Product;
import dev.faisals.springjpa.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {


    @Autowired
    ProductService service;

    @GetMapping("/products")
    public List<Product> getProducts() {
        return service.getProducts();
    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable int id) {
        return service.getProductById(id);
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product prod) {
        return service.addProduct(prod);
    }
}
