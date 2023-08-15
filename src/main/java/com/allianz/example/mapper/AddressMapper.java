package com.allianz.example.mapper;

import com.allianz.example.database.entity.AddressEntity;
import com.allianz.example.model.AddressDTO;
import com.allianz.example.model.OrderItemDTO;
import com.allianz.example.model.requestDTO.AddressRequestDTO;
import com.allianz.example.model.requestDTO.PageDTO;
import com.allianz.example.util.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

@Component
public class AddressMapper implements BaseMapper<AddressDTO, AddressEntity, AddressRequestDTO> {
    private final PersonMapper personMapper;

    @Autowired
    public AddressMapper(PersonMapper personMapper) {
        this.personMapper = personMapper;
    }

    @Override
    public AddressDTO entityToDTO(AddressEntity entity) {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setCreationDate(entity.getCreationDate());
        addressDTO.setUuid(entity.getUuid());
        addressDTO.setId(entity.getId());
        addressDTO.setAddress(entity.getAddress());
        addressDTO.setTitle(entity.getTitle());
        addressDTO.setUpdatedDate(entity.getUpdatedDate());
        addressDTO.setPerson(personMapper.entityToDTO(entity.getPerson()));

        return addressDTO;
    }

    @Override
    public AddressEntity dtoToEntity(AddressDTO dto) {
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setCreationDate(dto.getCreationDate());
        addressEntity.setUuid(dto.getUuid());
        addressEntity.setId(dto.getId());
        addressEntity.setAddress(dto.getAddress());
        addressEntity.setTitle(dto.getTitle());
        addressEntity.setUpdatedDate(dto.getUpdatedDate());
        addressEntity.setPerson(personMapper.dtoToEntity(dto.getPerson()));

        return addressEntity;

    }

    @Override
    public List<AddressDTO> entityListToDTOList(List<AddressEntity> addressEntities) {
        List<AddressDTO> addressDTOList = new ArrayList<>();

        for (AddressEntity addressEntity : addressEntities) {
            addressDTOList.add(entityToDTO(addressEntity));
        }

        return addressDTOList;
    }

    @Override
    public List<AddressEntity> dtoListTOEntityList(List<AddressDTO> addressDTOS) {
        List<AddressEntity> addressList = new ArrayList<>();

        for (AddressDTO addressDTO : addressDTOS) {
            addressList.add(dtoToEntity(addressDTO));
        }

        return addressList;


    }

    @Override
    public AddressEntity requestDTOToEntity(AddressRequestDTO dto) {
        AddressEntity entity = new AddressEntity();

        entity.setCreationDate(dto.getCreationDate());
        entity.setUuid(dto.getUuid());
        entity.setId(dto.getId());
        entity.setAddress(dto.getAddress());
        entity.setTitle(dto.getTitle());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setPerson(personMapper.requestDTOToEntity(dto.getPerson()));

        return entity;
    }

    @Override
    public List<AddressEntity> requestDTOListTOEntityList(List<AddressRequestDTO> addressRequestDTOS) {
        List<AddressEntity> addressList = new ArrayList<>();

        for (AddressRequestDTO addressDTO : addressRequestDTOS) {
            addressList.add(requestDTOToEntity(addressDTO));
        }

        return addressList;

    }

    @Override
    public AddressEntity requestDTOToExistEntity(AddressRequestDTO dto, AddressEntity entity) {
        entity.setCreationDate(dto.getCreationDate());
        entity.setUuid(dto.getUuid());
        entity.setId(dto.getId());
        entity.setAddress(dto.getAddress());
        entity.setTitle(dto.getTitle());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setPerson(personMapper.requestDTOToEntity(dto.getPerson()));

        return entity;
    }

    @Override
    public PageDTO<AddressDTO> pageEntityToPageDTO(Page<AddressEntity> entities) {
        PageDTO<AddressDTO> pageDTO = new PageDTO<>();
        pageDTO.setTotalPages(entities.getTotalPages());
        pageDTO.setSize(entities.getSize());
        pageDTO.setContent(entityListToDTOList(entities.getContent()));
        pageDTO.setNumber(entities.getNumber());
        pageDTO.setTotalElements(entities.getTotalElements());
        pageDTO.setNumberOfElement(entities.getNumberOfElements());
        pageDTO.setSort(entities.getSort());

        return  pageDTO;
    }

}
