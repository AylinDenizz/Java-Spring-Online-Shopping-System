package com.allianz.example.service;

import com.allianz.example.database.entity.OrderEntity;
import com.allianz.example.database.repository.OrderEntityRepository;
import com.allianz.example.mapper.OrderMapper;
import com.allianz.example.model.OrderDTO;
import com.allianz.example.util.BaseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service

public class OrderService extends BaseDTO {

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    OrderEntityRepository orderEntityRepository;

    public OrderDTO create(OrderDTO orderDTO) {
        OrderEntity order = orderMapper.dtoToEntity(orderDTO);
        orderEntityRepository.save(order);
        return orderMapper.entityToDTO(order);
    }

    public List<OrderDTO> getAll() {
        List<OrderEntity> orderEntities = orderEntityRepository.findAll();
        return orderMapper.entityListToDTOList(orderEntities);
    }

    public OrderDTO getByUUID(UUID uuid) {
        OrderDTO orderDTO = orderMapper.entityToDTO(orderEntityRepository.findByUuid(uuid).get());
        return orderDTO;
    }
}
