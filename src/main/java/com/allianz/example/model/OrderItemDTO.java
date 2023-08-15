package com.allianz.example.model;

import com.allianz.example.util.BaseDTO;
import lombok.Data;
import org.springframework.data.domain.Sort;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderItemDTO extends BaseDTO {
    private ProductDTO product;
    private Integer quantity;
    private BigDecimal sellPrice;

}
