package dev.faisals.springjpa.services;

import dev.faisals.springjpa.CategoryDTO.CategoryDTO;
import dev.faisals.springjpa.repositories.CategoryRepo;
import dev.faisals.springjpa.entities.Category;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CategoryService  {

    @Autowired
    CategoryRepo repo;

    public List<CategoryDTO> getFullTree() {
        return getTree(repo.findAllWithParent());
    }

    public List<CategoryDTO> getTree(@NonNull List<Category> all) {
        Map<Long, CategoryDTO> map = all.stream()
                .collect(Collectors.toMap(
                        Category::getId,
                        c -> new CategoryDTO(c.getId(), c.getName(), new ArrayList<>())
                ));

        List<CategoryDTO> roots = new ArrayList<>();

        for (Category c : all) {
            if (c.getParent() == null) {
                roots.add(map.get(c.getId()));
            } else {
                map.get(c.getParent().getId())
                        .getChildren()
                        .add(map.get(c.getId()));
            }
        }

        return roots;
    }

    public Category addCategory(Category category) {
        return repo.save(category);
    }
}
