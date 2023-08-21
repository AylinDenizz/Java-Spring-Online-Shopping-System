package com.allianz.example.service;


import com.allianz.example.database.entity.CategoryEntity;
import com.allianz.example.database.entity.PersonEntity;
import com.allianz.example.database.repository.CategoryEntityRepository;
import com.allianz.example.database.repository.PersonEntityRepository;
import com.allianz.example.database.specification.AddressSpesification;
import com.allianz.example.database.specification.CategorySpesification;
import com.allianz.example.mapper.CategoryMapper;

import com.allianz.example.mapper.PersonMapper;
import com.allianz.example.model.CategoryDTO;
import com.allianz.example.model.PersonDTO;
import com.allianz.example.model.requestDTO.CategoryRequestDTO;
import com.allianz.example.model.requestDTO.PersonRequestDTO;
import com.allianz.example.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryService extends BaseService<CategoryDTO, CategoryEntity, CategoryRequestDTO,
        CategoryEntityRepository, CategoryMapper, CategorySpesification> {
    @Autowired
    CategoryMapper categoryMapper;

    @Autowired
    CategoryEntityRepository categoryEntityRepository;

    @Autowired
    CategorySpesification categorySpesification;

    @Override
    protected CategoryMapper getMapper() {
        return categoryMapper;
    }

    @Override
    protected CategoryEntityRepository getRepository() {
        return categoryEntityRepository;
    }

    @Override
    protected CategorySpesification getSpecification() {
        return categorySpesification;
    }

    public CategoryDTO create(CategoryDTO categoryDTO) {
        CategoryEntity category = categoryMapper.dtoToEntity(categoryDTO);
        categoryEntityRepository.save(category);
        return categoryMapper.entityToDTO(category);
    }

    public List<CategoryDTO> getAll() {
        List<CategoryEntity> categoryEntityList = categoryEntityRepository.findAll();
        return categoryMapper.entityListToDTOList(categoryEntityList);
    }

    public CategoryDTO getByUuid(UUID uuid) {

        CategoryDTO categoryDTO = categoryMapper.entityToDTO(categoryEntityRepository.findByUuid(uuid).get());
        if (categoryDTO != null) {
            return categoryDTO;
        } else {
            return null;
        }
    }


    public CategoryDTO updateEntity(UUID uuid, CategoryDTO categoryDTO) {
        CategoryEntity entity = getRepository().findByUuid(uuid).orElse(null);
        if (entity == null) {
            return null;
        }
        return categoryMapper.entityToDTO(getRepository().save(entity));
    }
}

