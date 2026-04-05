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
    private String nameAr;
    private String nameEn;
    private String slug;
    private List<CategoryDTO> children;
}