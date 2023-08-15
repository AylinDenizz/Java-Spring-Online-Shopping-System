package com.allianz.example.util;

import com.allianz.example.model.SortDTO;
import lombok.Data;
import org.springframework.data.domain.Sort;

@Data
public class BaseFilterRequestDTO {
    private int pageNumber;
    private int pageSize;
    private SortDTO sortDTO;

}
