package com.allianz.example.service;

import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.database.repository.ProductEntityRepository;
import com.allianz.example.mapper.ProductMapper;
import com.allianz.example.model.ProductDTO;
import com.allianz.example.util.BaseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service

public class ProductService {
    @Autowired
    ProductMapper productMapper;

    @Autowired
    ProductEntityRepository productEntityRepository;

    public ProductDTO create(ProductDTO productDTO) {
        ProductEntity productEntity = productMapper.dtoToEntity(productDTO);
        productEntityRepository.save(productEntity);
        return productMapper.entityToDTO(productEntity);
    }

    public List<ProductDTO> getAll() {
        List<ProductEntity> productEntityList = productEntityRepository.findAll();
        return productMapper.entityListToDTOList(productEntityList);
    }

    public ProductDTO getByUUID(UUID uuid) {
        ProductDTO productDTO = productMapper.entityToDTO(productEntityRepository.findByUuid(uuid).get());
        return productDTO;
    }
}
