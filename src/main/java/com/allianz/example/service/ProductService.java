package com.allianz.example.service;

import com.allianz.example.database.entity.CategoryEntity;
import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.database.entity.SellerEntity;
import com.allianz.example.database.repository.ProductEntityRepository;
import com.allianz.example.database.repository.SellerEntityRepository;
import com.allianz.example.database.specification.AddressSpesification;
import com.allianz.example.database.specification.ProductSpesification;
import com.allianz.example.mapper.CategoryMapper;
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
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service

public class ProductService extends BaseService<ProductDTO, ProductEntity, ProductRequestDTO,
        ProductEntityRepository, ProductMapper, ProductSpesification> {
    private final EntityManager entityManager;

    public ProductService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Autowired
    ProductMapper productMapper;

    @Autowired
    ProductSpesification productSpesification;

    @Autowired
    CategoryMapper categoryMapper;

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

    @Override
    protected ProductSpesification getSpecification() {
        return productSpesification;
    }

    @Transactional
    public ProductDTO saveWithCategory(ProductRequestDTO productRequestDTO) {
        ProductEntity productEntity = productMapper.requestDTOToEntity(productRequestDTO);
        Set<CategoryRequestDTO> categoryDTOSet = productRequestDTO.getCategoryList();
        if (categoryDTOSet != null) {
            Set<CategoryEntity> categoryEntitySet = new HashSet<>();
            for (CategoryRequestDTO categoryDTO : categoryDTOSet) {
                if (categoryDTO != null) {
                    CategoryEntity categoryEntity = categoryMapper.dtoToEntity
                            (categoryService.getByUuid(categoryDTO.getUuid()));
                    categoryEntitySet.add(categoryEntity);
                }
            }
            productEntity.setCategoryList(categoryEntitySet);
        } else {
            productEntity.setCategoryList(new HashSet<>());
        }

        ProductEntity savedProductEntity = productEntityRepository.save(productEntity);


        return productMapper.entityToDTO(savedProductEntity);
    }




    @Transactional
    public CategoryEntity saveWithMerge(CategoryEntity category) {
        // Detached nesneyi merge işlemiyle tekrar yönetilen nesne haline getiriyoruz
        CategoryEntity managedCategory = entityManager.merge(category);
        // Yönetilen nesneyi kaydediyoruz
        entityManager.persist(managedCategory);
        return managedCategory;
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