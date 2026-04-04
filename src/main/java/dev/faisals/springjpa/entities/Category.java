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
    private String name;

//    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "parent_id")
    private Long parent;

}