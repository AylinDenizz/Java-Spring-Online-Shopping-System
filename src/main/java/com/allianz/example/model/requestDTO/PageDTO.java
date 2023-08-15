package com.allianz.example.model.requestDTO;

import com.allianz.example.util.BaseDTO;
import lombok.Data;
import org.springframework.data.domain.Sort;

import java.util.List;

@Data
public class PageDTO<DTO extends BaseDTO> {


    private int TotalPages;
    private long TotalElements;
    private int number;
    private int size;
    private int numberOfElement;
    private List<DTO> content;
    private boolean hasContent;
    private Sort sort;
}

