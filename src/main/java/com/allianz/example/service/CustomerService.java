package com.allianz.example.service;


import com.allianz.example.database.entity.CustomerEntity;
import com.allianz.example.database.repository.CustomerEntityRepository;
import com.allianz.example.mapper.CustomerMapper;
import com.allianz.example.model.CustomerDTO;
import com.allianz.example.util.BaseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service

public class CustomerService extends BaseDTO {
    @Autowired
    CustomerEntityRepository customerEntityRepository;

    @Autowired
    CustomerMapper customerMapper;

    public CustomerDTO create(CustomerDTO customerDTO) {
        CustomerEntity customer = customerMapper.dtoToEntity(customerDTO);
        customerEntityRepository.save(customer);
        return customerMapper.entityToDTO(customer);
    }

    public List<CustomerDTO> getAll() {
        List<CustomerEntity> categoryEntityList = customerEntityRepository.findAll();
        return customerMapper.entityListToDTOList(categoryEntityList);
    }

    public CustomerDTO getByUUID(UUID uuid) {
        CustomerDTO customerDTO = customerMapper.entityToDTO(customerEntityRepository.findByUuid(uuid).get());
        return customerDTO;
    }
}
