package com.allianz.example.service;

import com.allianz.example.database.entity.CategoryEntity;
import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.database.entity.SellerEntity;
import com.allianz.example.database.repository.ProductEntityRepository;
import com.allianz.example.database.repository.SellerEntityRepository;
import com.allianz.example.mapper.ProductMapper;
import com.allianz.example.mapper.SellerMapper;
import com.allianz.example.model.CategoryDTO;
import com.allianz.example.model.ProductDTO;
import com.allianz.example.model.SellerDTO;
import com.allianz.example.model.requestDTO.CategoryRequestDTO;
import com.allianz.example.model.requestDTO.ProductRequestDTO;
import com.allianz.example.model.requestDTO.SellerRequestDTO;
import com.allianz.example.util.BaseDTO;
import com.allianz.example.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service

public class ProductService extends BaseService<ProductDTO, ProductEntity, ProductRequestDTO, ProductEntityRepository, ProductMapper> {
    @Autowired
    ProductMapper productMapper;

    @Autowired
    ProductEntityRepository productEntityRepository;

    @Autowired
    CategoryService categoryService;

    @Override
    protected ProductMapper getMapper() {
        return productMapper;
    }

    @Override
    protected ProductEntityRepository getRepository() {
        return productEntityRepository;
    }

    @Transactional
    public ProductDTO saveWithCategory(ProductRequestDTO productRequestDTO) {
        ProductDTO productDTO = productMapper.entityToDTO((productMapper.requestDTOToEntity(productRequestDTO)));
        productRequestDTO.setCategoryList(null);
        productRequestDTO.setTax(null);
        if (productDTO.getCategoryList() != null) {
            Set<CategoryDTO> categoryDTOSet = new HashSet<>(new ArrayList<>
                    (productDTO.getCategoryList()));
            Set<CategoryDTO> categoryDTOS = new HashSet<>();
            for (CategoryDTO categoryDTO : categoryDTOSet) {
                if (categoryDTO != null) {
                    CategoryDTO category = categoryService.getByUuid(categoryDTO.getUuid());
                    categoryDTOS.add(category);
                }
            }
            productDTO.setCategoryList(categoryDTOS);
        } else {
            Set<CategoryDTO> categoryDTOS = new HashSet<>();
            productDTO.setCategoryList(categoryDTOS);
        }

        getRepository().save(productMapper.dtoToEntity(productDTO));
        return productDTO;
    }
}

/*
        Set<CategoryRequestDTO> categoryDTOSet = new HashSet<>(new ArrayList<>
                (productRequestDTO.getCategoryList()));
        ProductDTO productDTO = productMapper.entityToDTO((productEntityRepository.save
                (productMapper.requestDTOToEntity(productRequestDTO))));
        if (productDTO.getCategoryList() != null) {
            for (CategoryRequestDTO categoryRequestDTO : categoryDTOSet) {
                productDTO.getCategoryList().add(categoryService.getByUuid(categoryRequestDTO.getUuid()));
                productRequestDTO.setCategoryList(null);
                productRequestDTO.setTax(null);
            }
        } else {  Set<CategoryDTO> categoryDTOS = new HashSet<>();
            productDTO.setCategoryList(categoryDTOS);
        }

    }
}
*/