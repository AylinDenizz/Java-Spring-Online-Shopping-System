package com.allianz.example.service;

import com.allianz.example.database.entity.PersonEntity;
import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.database.repository.PersonEntityRepository;
import com.allianz.example.database.repository.ProductEntityRepository;
import com.allianz.example.database.specification.AddressSpesification;
import com.allianz.example.database.specification.PersonSpesification;
import com.allianz.example.mapper.PersonMapper;
import com.allianz.example.mapper.ProductMapper;
import com.allianz.example.model.PersonDTO;
import com.allianz.example.model.ProductDTO;
import com.allianz.example.model.requestDTO.PersonRequestDTO;
import com.allianz.example.model.requestDTO.ProductRequestDTO;
import com.allianz.example.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

//bean
@Service
public class PersonService extends BaseService<PersonDTO, PersonEntity,PersonRequestDTO,
        PersonEntityRepository, PersonMapper, PersonSpesification> {


    @Autowired
    PersonEntityRepository personEntityRepository;

    @Autowired
    PersonMapper personMapper;

    @Autowired
    PersonSpesification personSpesification;

    @Override
    protected PersonMapper getMapper() {
        return personMapper;
    }

    @Override
    protected PersonEntityRepository getRepository() {
        return personEntityRepository;
    }

    @Override
    protected PersonSpesification getSpecification() {
        return personSpesification;
    }


}
