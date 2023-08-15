package com.allianz.example.util;

import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
@Data
public class PageDTO<DTO extends BaseDTO>{


    private int TotalPages;
    private long TotalElements;
    private int number;
    private int size;
    private int numberOfElement;
    private List<DTO> content;
    private boolean hasContent;
    private Sort sort;
}
