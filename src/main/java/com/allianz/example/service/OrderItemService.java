package com.allianz.example.service;


import com.allianz.example.database.entity.OrderItemEntity;
import com.allianz.example.database.entity.PersonEntity;
import com.allianz.example.database.repository.OrderEntityRepository;
import com.allianz.example.database.repository.OrderItemEntityRepository;
import com.allianz.example.database.repository.PersonEntityRepository;
import com.allianz.example.database.specification.AddressSpesification;
import com.allianz.example.database.specification.OrderItemSpesification;
import com.allianz.example.mapper.OrderItemMapper;
import com.allianz.example.mapper.PersonMapper;
import com.allianz.example.model.OrderItemDTO;
import com.allianz.example.model.PersonDTO;
import com.allianz.example.model.requestDTO.OrderItemRequestDTO;
import com.allianz.example.model.requestDTO.PersonRequestDTO;
import com.allianz.example.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service

public class OrderItemService  extends BaseService<OrderItemDTO, OrderItemEntity, OrderItemRequestDTO,
        OrderItemEntityRepository, OrderItemMapper, OrderItemSpesification> {
    @Autowired
    OrderItemEntityRepository orderItemEntityRepository;

    @Autowired
    OrderItemMapper orderItemMapper;

    @Override
    protected OrderItemMapper getMapper() {
        return orderItemMapper;
    }

    @Autowired
    OrderItemSpesification orderItemSpesification;

    @Override
    protected OrderItemEntityRepository getRepository() {
        return orderItemEntityRepository;
    }

    @Override
    protected OrderItemSpesification getSpecification() {
        return orderItemSpesification;
    }

    public OrderItemDTO create(OrderItemDTO orderItemDTO) {
        OrderItemEntity orderItem = orderItemMapper.dtoToEntity(orderItemDTO);
        orderItemEntityRepository.save(orderItem);
        return orderItemMapper.entityToDTO(orderItem);
    }

    public List<OrderItemDTO> getAll() {
        List<OrderItemEntity> orderItemEntities = orderItemEntityRepository.findAll();
        return orderItemMapper.entityListToDTOList(orderItemEntities);
    }

    public OrderItemDTO getByUuid(UUID uuid) {
        OrderItemDTO orderItemDTO = orderItemMapper.entityToDTO(orderItemEntityRepository.findByUuid(uuid).get());
        return orderItemDTO;
    }
}
