package dev.faisals.springjpa.controllers;
import dev.faisals.springjpa.CategoryDTO.CategoryDTO;
import dev.faisals.springjpa.entities.Category;
import dev.faisals.springjpa.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    CategoryService service;

    @GetMapping("/categories")
    public List<CategoryDTO> getProducts() {
        return service.getFullTree();
    }


    @PostMapping("/categories")
    public Category addCategory(@RequestBody Category category) {
        return service.addCategory(category);
    }
}
