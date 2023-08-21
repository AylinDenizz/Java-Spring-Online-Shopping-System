package com.allianz.example.service;


import com.allianz.example.database.entity.CustomerEntity;
import com.allianz.example.database.entity.PersonEntity;
import com.allianz.example.database.repository.CustomerEntityRepository;
import com.allianz.example.database.repository.PersonEntityRepository;
import com.allianz.example.database.specification.AddressSpesification;
import com.allianz.example.database.specification.CustomerSpesification;
import com.allianz.example.mapper.CustomerMapper;
import com.allianz.example.mapper.PersonMapper;
import com.allianz.example.model.CustomerDTO;
import com.allianz.example.model.PersonDTO;
import com.allianz.example.model.requestDTO.CustomerRequestDTO;
import com.allianz.example.model.requestDTO.PersonRequestDTO;
import com.allianz.example.util.BaseDTO;
import com.allianz.example.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service

public class CustomerService extends BaseService<CustomerDTO, CustomerEntity, CustomerRequestDTO,
        CustomerEntityRepository, CustomerMapper, CustomerSpesification> {
    @Autowired
    CustomerEntityRepository customerEntityRepository;

    @Autowired
    CustomerMapper customerMapper;

    @Override
    protected CustomerMapper getMapper() {
        return customerMapper;
    }

    @Autowired
    CustomerSpesification customerSpesification;

    @Override
    protected CustomerEntityRepository getRepository() {
        return customerEntityRepository;
    }

    @Override
    protected CustomerSpesification getSpecification() {
        return customerSpesification;
    }

    public CustomerDTO create(CustomerDTO customerDTO) {
        CustomerEntity customer = customerMapper.dtoToEntity(customerDTO);
        customerEntityRepository.save(customer);
        return customerMapper.entityToDTO(customer);
    }

    public List<CustomerDTO> getAll() {
        List<CustomerEntity> categoryEntityList = customerEntityRepository.findAll();
        return customerMapper.entityListToDTOList(categoryEntityList);
    }

    public CustomerDTO getByUuid(UUID uuid) {
        CustomerDTO customerDTO = customerMapper.entityToDTO(customerEntityRepository.findByUuid(uuid).get());
        return customerDTO;
    }
}
