package dev.faisals.springjpa.repositories;

import dev.faisals.springjpa.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {

    @Query(value = """
    WITH RECURSIVE subtree AS (
        SELECT * FROM categories WHERE id = :targetId
        UNION ALL
        SELECT c.* FROM categories c
        INNER JOIN subtree s ON c.parent_id = s.id
    )
    SELECT * FROM subtree
    """, nativeQuery = true)
    List<Category> findSubTree(@Param("targetId") Long targetId);
}
