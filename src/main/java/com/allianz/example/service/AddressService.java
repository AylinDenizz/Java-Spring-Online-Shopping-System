package com.allianz.example.service;

import com.allianz.example.database.entity.AddressEntity;
import com.allianz.example.database.entity.PersonEntity;
import com.allianz.example.database.repository.AddressEntityRepository;
import com.allianz.example.database.repository.PersonEntityRepository;
import com.allianz.example.mapper.AddressMapper;
import com.allianz.example.mapper.PersonMapper;
import com.allianz.example.model.AddressDTO;
import com.allianz.example.model.PersonDTO;
import com.allianz.example.model.requestDTO.AddressRequestDTO;
import com.allianz.example.model.requestDTO.PersonRequestDTO;
import com.allianz.example.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AddressService  extends BaseService<AddressDTO, AddressEntity, AddressRequestDTO, AddressEntityRepository, AddressMapper> {

    @Autowired
    AddressEntityRepository addressEntityRepository;

    @Autowired
    AddressMapper addressMapper;

    @Override
    protected AddressMapper getMapper() {
        return addressMapper;
    }

    @Override
    protected AddressEntityRepository getRepository() {
        return addressEntityRepository;
    }


}
