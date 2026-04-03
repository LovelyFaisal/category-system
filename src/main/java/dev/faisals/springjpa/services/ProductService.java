package dev.faisals.springjpa.service;

import dev.faisals.springjpa.model.Product;
import dev.faisals.springjpa.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepo repo;

    public List<Product> getProducts() {
        return repo.findAll();
    }

    public Product getProductById(int prodId) {
        return repo.findById(prodId).orElse(new Product());
    }

    public void addProduct(Product product) {
        repo.save(product);
    }
    public void updateProduct(Product product) {
        repo.save(product);
    }

    public void deleteProduct(Product product) {
        repo.delete(product);
    }
}
