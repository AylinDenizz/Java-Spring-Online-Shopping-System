package com.allianz.example.model.requestDTO;

import com.allianz.example.util.BaseDTO;
import lombok.Data;

@Data
public class CustomerRequestDTO extends BaseDTO {
    private String companyName;
}
