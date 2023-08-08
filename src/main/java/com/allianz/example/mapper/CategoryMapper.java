package com.allianz.example.mapper;

import com.allianz.example.database.entity.CategoryEntity;
import com.allianz.example.model.CategoryDTO;
import com.allianz.example.model.requestDTO.CategoryRequestDTO;
import com.allianz.example.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CategoryMapper implements IBaseMapper<CategoryDTO, CategoryEntity, CategoryRequestDTO> {
    @Autowired
    ProductMapper productMapper;

    @Override
    public CategoryDTO entityToDTO(CategoryEntity entity) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setUuid(entity.getUuid());
        categoryDTO.setId(entity.getId());
        categoryDTO.setUpdatedDate(entity.getUpdatedDate());
        categoryDTO.setCreationDate(entity.getCreationDate());
        categoryDTO.setName(entity.getName());
        categoryDTO.setUuid(entity.getUuid());
       // categoryDTO.setProductList(productMapper.entityListToDTOList(entity.getProductList()));


        return categoryDTO;
    }

    @Override
    public CategoryEntity dtoToEntity(CategoryDTO dto) {

        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setUuid(dto.getUuid());
        categoryEntity.setId(dto.getId());
        categoryEntity.setUpdatedDate(dto.getUpdatedDate());
        categoryEntity.setCreationDate(dto.getCreationDate());
        categoryEntity.setName(dto.getName());
        categoryEntity.setUuid(dto.getUuid());


        return categoryEntity;
    }

    @Override
    public List<CategoryDTO> entityListToDTOList(List<CategoryEntity> categoryEntities) {
        List<CategoryDTO> categoryDTOS = new ArrayList<>();
        for (CategoryEntity entity: categoryEntities) {
            categoryDTOS.add(entityToDTO(entity));
        }
        return categoryDTOS;
    }
    @Override
    public List<CategoryEntity> dtoListTOEntityList(List<CategoryDTO> categoryDTOS) {
        List<CategoryEntity> categoryEntities = new ArrayList<>();
        for (CategoryDTO categoryDTO: categoryDTOS) {
            categoryEntities.add(dtoToEntity(categoryDTO));
        }
        return categoryEntities;
    }

    @Override
    public CategoryEntity requestDTOToEntity(CategoryRequestDTO dto) {
    CategoryEntity categoryEntity = new CategoryEntity();
    categoryEntity.setName(categoryEntity.getName());
    categoryEntity.setUuid(categoryEntity.getUuid());
    categoryEntity.setUpdatedDate(categoryEntity.getUpdatedDate());
    categoryEntity.setCreationDate(categoryEntity.getCreationDate());
    categoryEntity.setId(categoryEntity.getId());

    return categoryEntity;
    }
}
