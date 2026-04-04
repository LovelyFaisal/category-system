package dev.faisals.springjpa.services;

import dev.faisals.springjpa.entities.Product;
import dev.faisals.springjpa.repositories.ProductRepo;
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

    public Product addProduct(Product product) {
        return repo.save(product);
    }
    public void updateProduct(Product product) {
        repo.save(product);
    }

    public void deleteProduct(Product product) {
        repo.delete(product);
    }
}
