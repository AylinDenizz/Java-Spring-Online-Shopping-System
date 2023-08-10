package com.allianz.example.service;


import com.allianz.example.database.entity.CategoryEntity;
import com.allianz.example.database.repository.CategoryEntityRepository;
import com.allianz.example.mapper.CategoryMapper;

import com.allianz.example.model.CategoryDTO;
import com.allianz.example.util.BaseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class CategoryService{
    @Autowired
    CategoryMapper categoryMapper;

    @Autowired
    CategoryEntityRepository categoryEntityRepository;

    public CategoryDTO create(CategoryDTO categoryDTO) {
        CategoryEntity category = categoryMapper.dtoToEntity(categoryDTO);
        categoryEntityRepository.save(category);
        return categoryMapper.entityToDTO(category);
    }

    public List<CategoryDTO> getAll() {
        List<CategoryEntity> categoryEntityList = categoryEntityRepository.findAll();
        return categoryMapper.entityListToDTOList(categoryEntityList);
    }

    public CategoryDTO getByUUID(UUID uuid) {

        CategoryDTO categoryDTO = categoryMapper.entityToDTO(categoryEntityRepository.findByUuid(uuid).get());
        if (categoryDTO != null) {
            return categoryDTO;
        } else{
            return null;
        }
    }
}
