package com.allianz.example.controller;

import com.allianz.example.database.entity.BillEntity;
import com.allianz.example.database.repository.BillEntityRepository;
import com.allianz.example.database.specification.BillSpesification;
import com.allianz.example.mapper.BillMapper;
import com.allianz.example.model.BillDTO;
import com.allianz.example.model.requestDTO.BillRequestDTO;
import com.allianz.example.service.BillService;
import com.allianz.example.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("BillDTO")
public class BillController extends BaseController<BillEntity, BillDTO, BillRequestDTO,
        BillEntityRepository, BillMapper, BillSpesification, BillService > {

    @Autowired
    BillService BillService;

    @Autowired
    BillMapper BillMapper;

    @Override
    protected BillService getService() {
        return BillService;
    }
}