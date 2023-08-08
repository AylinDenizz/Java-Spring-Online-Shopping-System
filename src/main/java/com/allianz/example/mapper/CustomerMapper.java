package com.allianz.example.mapper;

import com.allianz.example.database.entity.CategoryEntity;
import com.allianz.example.database.entity.CustomerEntity;
import com.allianz.example.model.CustomerDTO;
import com.allianz.example.model.requestDTO.CustomerRequestDTO;
import com.allianz.example.util.BaseDTO;
import com.allianz.example.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CustomerMapper implements IBaseMapper<CustomerDTO, CustomerEntity, CustomerRequestDTO> {

    @Autowired
    PersonMapper personMapper;

    @Autowired
    OrderMapper orderMapper;
    @Override
    public CustomerDTO entityToDTO(CustomerEntity entity) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setUpdatedDate(entity.getUpdatedDate());
        customerDTO.setId(entity.getId());
        customerDTO.setCompanyName(entity.getCompanyName());
        customerDTO.setCreationDate(entity.getCreationDate());
        customerDTO.setUuid(entity.getUuid());
        customerDTO.setIsCorporate(entity.getIsCorporate());
        customerDTO.setTaxNumber(entity.getTaxNumber());
        customerDTO.setTaxOffice(entity.getTaxOffice());
        customerDTO.setPerson(personMapper.entityToDTO(entity.getPerson()));
        customerDTO.setOrderList(orderMapper.entityListToDTOList(entity.getOrderList()));

        return customerDTO;
    }

    @Override
    public CustomerEntity dtoToEntity(CustomerDTO dto) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setUpdatedDate(dto.getUpdatedDate());
        customerEntity.setId(dto.getId());
        customerEntity.setCompanyName(dto.getCompanyName());
        customerEntity.setCreationDate(dto.getCreationDate());
        customerEntity.setUuid(dto.getUuid());
        customerEntity.setIsCorporate(dto.getIsCorporate());
        customerEntity.setTaxNumber(dto.getTaxNumber());
        customerEntity.setTaxOffice(dto.getTaxOffice());
        customerEntity.setPerson(personMapper.dtoToEntity(dto.getPerson()));
        customerEntity.setOrderList(orderMapper.dtoListTOEntityList(dto.getOrderList()));

        return customerEntity;
    }

    @Override
    public List<CustomerDTO> entityListToDTOList(List<CustomerEntity> customerEntities) {


        List<CustomerDTO> customerDTOS = new ArrayList<>();
        for (CustomerEntity customer: customerEntities) {
            customerDTOS.add(entityToDTO(customer));
        }
        return customerDTOS;
    }

    @Override
    public List<CustomerEntity> dtoListTOEntityList(List<CustomerDTO> customerDTOS) {
        List<CustomerEntity> customerEntities =new ArrayList<>();
        for (CustomerDTO customerDTO: customerDTOS){
            customerEntities.add(dtoToEntity(customerDTO));
        }
        return customerEntities;
    }

    @Override
    public CustomerEntity requestDTOToEntity(CustomerRequestDTO dto) {
        CustomerEntity customer = new CustomerEntity();
        customer.setCompanyName(dto.getCompanyName());
        customer.setCreationDate(dto.getCreationDate());
        customer.setId(dto.getId());
        customer.setUuid(dto.getUuid());
        customer.setUpdatedDate(dto.getUpdatedDate());

        return customer;
    }
}
