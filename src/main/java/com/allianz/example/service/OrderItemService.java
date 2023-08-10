package com.allianz.example.service;


import com.allianz.example.database.entity.OrderItemEntity;
import com.allianz.example.database.repository.OrderItemEntityRepository;
import com.allianz.example.mapper.OrderItemMapper;
import com.allianz.example.model.OrderItemDTO;
import com.allianz.example.util.BaseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service

public class OrderItemService  {
    @Autowired
    OrderItemEntityRepository orderItemEntityRepository;

    @Autowired
    OrderItemMapper orderItemMapper;

    public OrderItemDTO create(OrderItemDTO orderItemDTO) {
        OrderItemEntity orderItem = orderItemMapper.dtoToEntity(orderItemDTO);
        orderItemEntityRepository.save(orderItem);
        return orderItemMapper.entityToDTO(orderItem);
    }

    public List<OrderItemDTO> getAll() {
        List<OrderItemEntity> orderItemEntities = orderItemEntityRepository.findAll();
        return orderItemMapper.entityListToDTOList(orderItemEntities);
    }

    public OrderItemDTO getByUUID(UUID uuid) {
        OrderItemDTO orderItemDTO = orderItemMapper.entityToDTO(orderItemEntityRepository.findByUuid(uuid).get());
        return orderItemDTO;
    }
}
