package dev.faisals.springjpa.services;

import dev.faisals.springjpa.CategoryDTO.CategoryDTO;
import dev.faisals.springjpa.repositories.CategoryRepo;
import dev.faisals.springjpa.entities.Category;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    CategoryRepo repo;

    public List<CategoryDTO> getFullTree() {
        List<Category> list = repo.findAll(Sort.by(Sort.Direction.ASC, "parentId", "sortOrder"));
        return getTree(list);
    }

    public List<CategoryDTO> getSubTree(Long targetId) {
        List<Category> list = repo.findSubTree(targetId);
        Category category = list.get(0);
        CategoryDTO dto = new CategoryDTO(category.getId(), category.getNameAr(), category.getNameEn(), category.getSlug(), new ArrayList<>());
        List<CategoryDTO> listt = new ArrayList<>();
        listt.add(dto);
        return getTree(list);
    }

    public List<CategoryDTO> getTree(@NonNull List<Category> all) {
        Map<Long, CategoryDTO> map = all.stream()
                .collect(Collectors.toMap(
                        Category::getId,
                        c -> new CategoryDTO(c.getId(), c.getNameAr(), c.getNameEn(), c.getSlug(), new ArrayList<>())
                ));

        List<CategoryDTO> roots = new ArrayList<>();

        for (Category c : all) {
            CategoryDTO dto = map.get(c.getId());
            if (c.getParentId() == null) {
                roots.add(dto);
            } else {
                CategoryDTO parent = map.get(c.getParentId());
                if (parent != null) {
                    parent.getChildren().add(dto);
                } else {
                    roots.add(map.get(c.getId()));
                }
            }
        }
        return roots;
    }

    public Category addCategory(Category category) {
        return repo.save(category);
    }
}
