package com.allianz.example.controller;

import com.allianz.example.database.entity.CategoryEntity;
import com.allianz.example.database.repository.CategoryEntityRepository;
import com.allianz.example.database.specification.CategorySpesification;
import com.allianz.example.mapper.CategoryMapper;
import com.allianz.example.model.CategoryDTO;
import com.allianz.example.model.requestDTO.CategoryRequestDTO;
import com.allianz.example.service.CategoryService;
import com.allianz.example.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("CategoryDTO")
public class CategoryController extends BaseController<CategoryEntity, CategoryDTO, CategoryRequestDTO,
        CategoryEntityRepository, CategoryMapper, CategorySpesification, CategoryService> {


    @Autowired
    CategoryService CategoryService;

    @Autowired
    CategoryMapper CategoryMapper;

    @Override
    protected CategoryService getService() {
        return CategoryService;
    }
}