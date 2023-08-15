package com.allianz.example.model;

import lombok.Data;
import org.hibernate.sql.results.graph.BiDirectionalFetch;
import org.springframework.data.domain.Sort;
@Data
public class SortDTO {
    private String coloumnName;
    private Sort.Direction direction;

}
