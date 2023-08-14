package com.allianz.example.service;

import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.database.entity.SellerEntity;
import com.allianz.example.database.repository.ProductEntityRepository;
import com.allianz.example.database.repository.SellerEntityRepository;
import com.allianz.example.mapper.ProductMapper;
import com.allianz.example.mapper.SellerMapper;
import com.allianz.example.model.ProductDTO;
import com.allianz.example.model.SellerDTO;
import com.allianz.example.model.requestDTO.ProductRequestDTO;
import com.allianz.example.model.requestDTO.SellerRequestDTO;
import com.allianz.example.util.BaseDTO;
import com.allianz.example.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service

public class ProductService extends BaseService<ProductDTO, ProductEntity, ProductRequestDTO, ProductEntityRepository, ProductMapper> {
    @Autowired
    ProductMapper productMapper;

    @Autowired
    ProductEntityRepository productEntityRepository;

    @Override
    protected ProductMapper getMapper() {
        return productMapper;
    }

    @Override
    protected ProductEntityRepository getRepository() {
        return productEntityRepository;
    }
}
