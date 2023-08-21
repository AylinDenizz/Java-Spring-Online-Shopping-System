package com.allianz.example.controller;
import com.allianz.example.database.entity.AddressEntity;
import com.allianz.example.database.repository.AddressEntityRepository;
import com.allianz.example.database.specification.AddressSpesification;
import com.allianz.example.mapper.AddressMapper;
import com.allianz.example.model.AddressDTO;
import com.allianz.example.model.requestDTO.AddressRequestDTO;
import com.allianz.example.service.AddressService;
import com.allianz.example.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("AddressDTO")
public class AddressController extends BaseController<AddressEntity, AddressDTO, AddressRequestDTO,
        AddressEntityRepository, AddressMapper, AddressSpesification, AddressService> {


    @Autowired
    AddressService AddressService;

    @Autowired
    AddressMapper AddressMapper;

    @Override
    protected AddressService getService() {
        return AddressService;
    }
}