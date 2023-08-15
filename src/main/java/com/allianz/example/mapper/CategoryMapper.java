package com.allianz.example.mapper;

import com.allianz.example.database.entity.CategoryEntity;
import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.model.CategoryDTO;
import com.allianz.example.model.OrderItemDTO;
import com.allianz.example.model.ProductDTO;
import com.allianz.example.model.requestDTO.CategoryRequestDTO;
import com.allianz.example.model.requestDTO.PageDTO;
import com.allianz.example.util.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class CategoryMapper implements BaseMapper<CategoryDTO, CategoryEntity, CategoryRequestDTO> {
    private final ProductMapper productMapper;

    @Autowired
    public CategoryMapper(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Override
    public CategoryDTO entityToDTO(CategoryEntity entity) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(entity.getId());
        categoryDTO.setUpdatedDate(entity.getUpdatedDate());
        categoryDTO.setCreationDate(entity.getCreationDate());
        categoryDTO.setName(entity.getName());
        categoryDTO.setUuid(entity.getUuid());
        if (entity.getProductList() != null) {
            Set<ProductDTO> productDTOS = new HashSet<>(productMapper.entityListToDTOList(new ArrayList<>(entity.getProductList())));
            categoryDTO.setProductList(productDTOS);
        }

        return categoryDTO;
    }

    @Override
    public CategoryEntity dtoToEntity(CategoryDTO dto) {

        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId(dto.getId());
        categoryEntity.setUpdatedDate(dto.getUpdatedDate());
        categoryEntity.setCreationDate(dto.getCreationDate());
        categoryEntity.setName(dto.getName());
        categoryEntity.setUuid(dto.getUuid());
        if (dto.getProductList() != null) {
            Set<ProductEntity> productDTOS = new HashSet<>(productMapper.dtoListTOEntityList(new ArrayList<>(dto.getProductList())));
            categoryEntity.setProductList(productDTOS);
        }

        return categoryEntity;
    }

    @Override
    public List<CategoryDTO> entityListToDTOList(List<CategoryEntity> categoryEntities) {
        List<CategoryDTO> categoryDTOS = new ArrayList<>();
        for (CategoryEntity entity : categoryEntities) {
            categoryDTOS.add(entityToDTO(entity));
        }
        return categoryDTOS;
    }

    @Override
    public List<CategoryEntity> dtoListTOEntityList(List<CategoryDTO> categoryDTOS) {
        List<CategoryEntity> categoryEntities = new ArrayList<>();
        for (CategoryDTO categoryDTO : categoryDTOS) {
            categoryEntities.add(dtoToEntity(categoryDTO));
        }
        return categoryEntities;
    }

    @Override
    public CategoryEntity requestDTOToEntity(CategoryRequestDTO dto) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId(dto.getId());
        categoryEntity.setUpdatedDate(dto.getUpdatedDate());
        categoryEntity.setCreationDate(dto.getCreationDate());
        categoryEntity.setName(dto.getName());
        categoryEntity.setUuid(dto.getUuid());

        if (dto.getProductList() != null) {
            Set<ProductEntity> productDTOS = new HashSet<>(productMapper.requestDTOListTOEntityList(new ArrayList<>(dto.getProductList())));
            categoryEntity.setProductList(productDTOS);
        }
        return categoryEntity;
    }

    @Override
    public List<CategoryEntity> requestDTOListTOEntityList(List<CategoryRequestDTO> categoryRequestDTOS) {
        List<CategoryEntity> categoryEntities = new ArrayList<>();
        for (CategoryRequestDTO categoryDTO : categoryRequestDTOS) {
            categoryEntities.add(requestDTOToEntity(categoryDTO));
        }
        return categoryEntities;
    }

    @Override
    public PageDTO<CategoryDTO> pageEntityToPageDTO(Page<CategoryEntity> entities) {
        PageDTO<CategoryDTO> pageDTO = new PageDTO<>();
        pageDTO.setTotalPages(entities.getTotalPages());
        pageDTO.setSize(entities.getSize());
        pageDTO.setContent(entityListToDTOList(entities.getContent()));
        pageDTO.setNumber(entities.getNumber());
        pageDTO.setTotalElements(entities.getTotalElements());
        pageDTO.setNumberOfElement(entities.getNumberOfElements());
        pageDTO.setSort(entities.getSort());

        return pageDTO;
    }


    @Override
    public CategoryEntity requestDTOToExistEntity(CategoryRequestDTO dto, CategoryEntity entity) {
        entity.setId(dto.getId());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setCreationDate(dto.getCreationDate());
        entity.setName(dto.getName());
        entity.setUuid(dto.getUuid());

        if (dto.getProductList() != null) {
            Set<ProductEntity> productDTOS = new HashSet<>(productMapper.requestDTOListTOEntityList(new ArrayList<>(dto.getProductList())));
            entity.setProductList(productDTOS);
        }
        return entity;
    }


}
