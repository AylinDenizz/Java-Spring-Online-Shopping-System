package com.allianz.example.database.entity;

import com.allianz.example.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Table
@Entity
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "category_uuid"
        )
)
@Data
public class CategoryEntity extends BaseEntity {

    @Column
    private String name;


    @ManyToMany(mappedBy = "categoryList", cascade = CascadeType.ALL)


    private Set<ProductEntity> productList = new HashSet<>();


}
