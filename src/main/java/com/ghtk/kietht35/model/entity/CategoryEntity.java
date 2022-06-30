package com.ghtk.kietht35.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "category")
@Getter
@Setter
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    private String name;
    private String code;
    private Integer status;
    private String description;
    private LocalDateTime modifiedAt;
}
