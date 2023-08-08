package com.allianz.example.mapper;

import com.allianz.example.database.entity.PersonEntity;
import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.database.entity.TaxEntity;
import com.allianz.example.model.ProductDTO;
import com.allianz.example.model.requestDTO.ProductRequestDTO;
import com.allianz.example.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ProductMapper implements IBaseMapper<ProductDTO, ProductEntity, ProductRequestDTO> {
    @Autowired
    TaxMapper taxMapper;

    @Autowired
    CategoryMapper categoryMapper;
    @Override
    public ProductDTO entityToDTO(ProductEntity entity) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setUuid(entity.getUuid());
        productDTO.setCreationDate(entity.getCreationDate());
        productDTO.setId(entity.getId());
        productDTO.setUpdatedDate(entity.getUpdatedDate());
        productDTO.setName(entity.getName());
        productDTO.setQuantity(entity.getQuantity());
        productDTO.setCode(entity.getCode());
        productDTO.setColor(entity.getColor());
        productDTO.setTax(taxMapper.entityToDTO(entity.getTax()));
        productDTO.setBuyPrice(entity.getBuyPrice());
        productDTO.setSellPrice(entity.getSellPrice());
        //productDTO.setCategoryList(categoryMapper.entityListToDTOList(entity.getCategoryList()));

        return productDTO;


    }

    @Override
    public ProductEntity dtoToEntity(ProductDTO dto) {
        ProductEntity product = new ProductEntity();
        product.setUuid(dto.getUuid());
        product.setCreationDate(dto.getCreationDate());
        product.setId(dto.getId());
        product.setUpdatedDate(dto.getUpdatedDate());
        product.setName(dto.getName());
        product.setQuantity(dto.getQuantity());
        product.setCode(dto.getCode());
        product.setColor(dto.getColor());
        product.setTax(taxMapper.dtoToEntity(dto.getTax()));
        product.setBuyPrice(dto.getBuyPrice());
        product.setSellPrice(dto.getSellPrice());
        //productDTO.setCategoryList(categoryMapper.entityListToDTOList(entity.getCategoryList()));

        return product;
    }

    @Override
    public List<ProductDTO> entityListToDTOList(List<ProductEntity> productEntities) {
        List<ProductDTO> dtos = new ArrayList<>();
        for (ProductEntity entity: productEntities) {
            dtos.add(entityToDTO(entity));
        }
        return dtos;
    }

    @Override
    public List<ProductEntity> dtoListTOEntityList(List<ProductDTO> productDTOS) {
        List<ProductEntity> entities = new ArrayList<>();
        for (ProductDTO dto: productDTOS) {
            entities.add(dtoToEntity(dto));
        }
        return entities;
    }

    @Override
    public ProductEntity requestDTOToEntity(ProductRequestDTO dto) {

        ProductEntity entity = new ProductEntity();
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());

        return entity;
    }
}
