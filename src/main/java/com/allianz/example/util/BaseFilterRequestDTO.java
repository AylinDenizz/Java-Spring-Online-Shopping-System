package com.allianz.example.util;

import com.allianz.example.model.SortDTO;
import lombok.Data;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Sort;

import java.util.List;

@Data
public class BaseFilterRequestDTO {
    private int pageNumber;
    private int pageSize;
    private SortDTO sortDTO;
    private List<SearchCriteria> filters;

}
