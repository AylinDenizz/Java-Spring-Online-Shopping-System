package com.allianz.example.service;

import com.allianz.example.database.entity.OrderEntity;
import com.allianz.example.database.repository.OrderEntityRepository;
import com.allianz.example.mapper.OrderMapper;
import com.allianz.example.model.OrderDTO;
import com.allianz.example.model.requestDTO.OrderRequestDTO;
import com.allianz.example.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service

public class OrderService extends BaseService<OrderDTO, OrderEntity, OrderRequestDTO, OrderEntityRepository, OrderMapper> {

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    OrderEntityRepository orderEntityRepository;

    @Override
    protected OrderMapper getMapper() {
        return orderMapper;
    }

    @Override
    protected OrderEntityRepository getRepository() {
        return orderEntityRepository;
    }

}
