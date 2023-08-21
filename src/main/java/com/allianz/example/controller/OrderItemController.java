package com.allianz.example.controller;

import com.allianz.example.database.entity.OrderItemEntity;
import com.allianz.example.database.repository.OrderItemEntityRepository;
import com.allianz.example.database.specification.OrderItemSpesification;
import com.allianz.example.mapper.OrderItemMapper;
import com.allianz.example.model.OrderItemDTO;
import com.allianz.example.model.requestDTO.OrderItemRequestDTO;
import com.allianz.example.service.OrderItemService;
import com.allianz.example.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("OrderItemDTO")
public class OrderItemController extends BaseController<OrderItemEntity, OrderItemDTO, OrderItemRequestDTO,
        OrderItemEntityRepository, OrderItemMapper, OrderItemSpesification, OrderItemService> {


    @Autowired
    OrderItemService OrderItemService;

    @Autowired
    OrderItemMapper OrderItemMapper;

    @Override
    protected OrderItemService getService() {
        return OrderItemService;
    }
}
