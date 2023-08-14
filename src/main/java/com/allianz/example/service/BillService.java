package com.allianz.example.service;

import com.allianz.example.database.entity.BillEntity;
import com.allianz.example.database.entity.PersonEntity;
import com.allianz.example.database.repository.BillEntityRepository;
import com.allianz.example.database.repository.PersonEntityRepository;
import com.allianz.example.mapper.BillMapper;

import com.allianz.example.mapper.PersonMapper;
import com.allianz.example.model.BillDTO;
import com.allianz.example.model.PersonDTO;
import com.allianz.example.model.requestDTO.BillRequestDTO;
import com.allianz.example.model.requestDTO.PersonRequestDTO;
import com.allianz.example.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class BillService extends BaseService<BillDTO, BillEntity, BillRequestDTO, BillEntityRepository, BillMapper> {
    @Autowired
    BillEntityRepository billEntityRepository;

    @Autowired
    BillMapper billMapper;

    @Override
    protected BillMapper getMapper() {
        return billMapper;
    }

    @Override
    protected BillEntityRepository getRepository() {
        return billEntityRepository;
    }

}
