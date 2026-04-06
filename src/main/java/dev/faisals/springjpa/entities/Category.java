package dev.faisals.springjpa.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String slug;

    @Column()
    private String nameAr;

    @Column()
    private String nameEn;

    @Column(name = "sort_order")
    private Integer sortOrder = 0;

    @Column(name = "parent_id")
    private Long parentId;

}