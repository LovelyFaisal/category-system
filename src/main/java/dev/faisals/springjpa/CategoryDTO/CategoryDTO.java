package dev.faisals.springjpa.CategoryDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class CategoryDTO {
    private Long id;
    private String name;
    private List<CategoryDTO> children;
}